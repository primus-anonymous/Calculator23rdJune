package com.neocaptainnemo.calculator23rdjune.model;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.neocaptainnemo.calculator23rdjune.R;

public enum Theme {
    ONE(R.style.Theme_Calculator23rdJune, R.string.theme_1, "themeone"),
    TWO(R.style.Theme_Calculator23rdJune_V2, R.string.theme_2, "themetwo"),
    THREE(R.style.Theme_Calculator23rdJune_V3, R.string.theme_3, "themethree");

    @StyleRes
    private final int themeRes;
    @StringRes
    private final int title;

    private final String key;

    Theme(int themeRes, int title, String key) {
        this.themeRes = themeRes;
        this.title = title;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getTitle() {
        return title;
    }

    public int getThemeRes() {
        return themeRes;
    }
}
