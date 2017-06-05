package com.android.app.weather.forecast.model;

/**
 * Created by pnthang on 10/26/2015.
 */
public class InformationFunction {

    private int icon;
    private String nameFunction;

    public String getNameFunction() {
        return nameFunction;
    }

    public void setNameFunction(String nameFunction) {
        this.nameFunction = nameFunction;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public InformationFunction(int icon, String nameFunction) {
        this.icon = icon;
        this.nameFunction = nameFunction;
    }
}
