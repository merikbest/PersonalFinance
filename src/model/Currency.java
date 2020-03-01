package model;

import exception.ModelException;

import java.util.Objects;

public class Currency extends Common {
    private String currencyName;
    private String currencyCode;
    private double currencyRate;
    private boolean on;
    private boolean base;

    public Currency() {
    }

    public Currency(String currencyName, String currencyCode, double currencyRate, boolean on, boolean base) throws ModelException {
        if (currencyName.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currencyCode.length() == 0) throw new ModelException(ModelException.CODE_EMPTY);
        if (currencyRate <= 0) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
        this.on = on;
        this.base = base;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        on = on;
    }

    public boolean isBase() {
        return base;
    }

    public void setBaseCurrency(boolean baseCurrency) {
        base = baseCurrency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyName='" + currencyName + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyRate=" + currencyRate +
                ", on=" + on +
                ", base=" + base +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(currencyCode, currency.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode);
    }

    @Override
    public String getValueFromComboBox() {
        return currencyName;
    }

    public double getRateByCurrency(Currency currency) {
        return currencyRate / currency.currencyRate;
    }
}
