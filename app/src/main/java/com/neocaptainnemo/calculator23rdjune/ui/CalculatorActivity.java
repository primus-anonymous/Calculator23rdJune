package com.neocaptainnemo.calculator23rdjune.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.neocaptainnemo.calculator23rdjune.R;
import com.neocaptainnemo.calculator23rdjune.model.CalculatorImpl;
import com.neocaptainnemo.calculator23rdjune.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView resultTxt;

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("themes.xml", Context.MODE_PRIVATE);

        int theme = preferences.getInt("theme", R.style.Theme_Calculator23rdJune);

        setTheme(theme);

        setContentView(R.layout.activity_calculator);

        resultTxt = findViewById(R.id.result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        String keyOne = getResources().getString(R.string.key_1);
        String keyOneShort = getString(R.string.key_1);

        float dimenOne = getResources().getDimension(R.dimen.default_padding);

        int color = ContextCompat.getColor(this, R.color.btn_color);

        View layout = getLayoutInflater().inflate(R.layout.activity_calculator, null);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.rectangle);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

        }

        resultTxt.setBackground(drawable);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);
        digits.put(R.id.key_0, 0);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPressed(digits.get(view.getId()));
            }
        };


        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
        findViewById(R.id.key_0).setOnClickListener(digitClickListener);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.key_plus, Operator.ADD);
        operators.put(R.id.key_minus, Operator.SUB);
        operators.put(R.id.key_mult, Operator.MULT);
        operators.put(R.id.key_div, Operator.DIV);


        View.OnClickListener operatorsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_mult).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_div).setOnClickListener(operatorsClickListener);

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });

        Button themeOne = findViewById(R.id.theme1);
        Button themeTwo = findViewById(R.id.theme2);
        Button themeThree = findViewById(R.id.theme3);

        if (themeOne != null) {
            themeOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    preferences.edit()
                            .putInt("theme", R.style.Theme_Calculator23rdJune)
                            .commit();

                    recreate();
                }
            });
        }

        if (themeTwo != null) {
            themeTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preferences.edit()
                            .putInt("theme", R.style.Theme_Calculator23rdJune_V2)
                            .commit();

                    recreate();

                }
            });
        }

        if (themeThree != null) {
            themeThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preferences.edit()
                            .putInt("theme", R.style.Theme_Calculator23rdJune_V3)
                            .commit();

                    recreate();

                }
            });
        }

    }

    @Override
    public void showResult(String result) {
        resultTxt.setText(result);
    }
}