package model;

import exception.ModelException;

import java.util.List;
import java.util.Objects;

public class Account extends Common {
    private String titleWallet;
    private Currency currency;
    private double startAmount;
    private double amount;

    public Account() {
    }

    public Account(String titleWallet, Currency currency, double startAmount) throws ModelException {
        if (titleWallet.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.titleWallet = titleWallet;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTitleWallet() {
        return titleWallet;
    }

    public void setTitleWallet(String titleWallet) {
        this.titleWallet = titleWallet;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(titleWallet, account.titleWallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleWallet);
    }

    @Override
    public String getValueFromComboBox() {
        return titleWallet;
    }

    public void setAmountTransactionsAndTransfers(List<Transaction> transactions, List<Transfer> transfers) {
        this.amount = startAmount;
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().equals(this)) {
                this.amount += transaction.getAmount();
            }
        }

        for (Transfer transfer : transfers) {
            if (transfer.getFromAccount().equals(this)) {
                this.amount -= transfer.getFromAmount();
            }
            if (transfer.getToAccount().equals(this)) {
                this.amount += transfer.getToAmount();
            }
        }
    }
}
