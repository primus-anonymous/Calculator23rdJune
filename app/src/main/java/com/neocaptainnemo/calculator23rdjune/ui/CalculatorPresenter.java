package com.neocaptainnemo.calculator23rdjune.ui;

import com.neocaptainnemo.calculator23rdjune.model.Calculator;
import com.neocaptainnemo.calculator23rdjune.model.Operator;

import java.text.DecimalFormat;

public class CalculatorPresenter {

    private final DecimalFormat formater = new DecimalFormat("#.##");

    private final CalculatorView view;
    private final Calculator calculator;

    private double argOne;

    private Double argTwo;

    private Operator selectedOperator;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {

        if (argTwo == null) {

            argOne = argOne * 10 + digit;

            showFormatted(argOne);
        } else {
            argTwo = argTwo * 10 + digit;

            showFormatted(argTwo);

        }
    }

    public void onOperatorPressed(Operator operator) {
        if (selectedOperator != null) {

            argOne = calculator.perform(argOne, argTwo, selectedOperator);

            showFormatted(argOne);
        }

        argTwo = 0.0;

        selectedOperator = operator;
    }

    public void onDotPressed() {


    }

    private void showFormatted(double value) {
        view.showResult(formater.format(value));
    }
}
