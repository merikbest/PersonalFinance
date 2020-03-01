package model;

import saveload.SaveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Statistics {
    public static double getBallanceCurrency(Currency currency) {
        SaveData saveData = SaveData.getInstance();
        double amount = 0;
        for (Account account : saveData.getAccounts()) {
            if (currency.equals(account.getCurrency())) {
                amount += account.getAmount();
            }
        }
        return amount;
    }

    public static double getBallance(Currency currency) {
        SaveData saveData = SaveData.getInstance();
        double amount = 0;
        for (Account account : saveData.getAccounts()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }


    public static HashMap<String, Double> getDataForChartOnIncomeArticles(boolean income) {
        return getDataForChartOnArticle(true);
    }

    public static HashMap<String, Double> getDataForChartOnExpArticles(boolean income) {
        return getDataForChartOnArticle(false);
    }

    private static HashMap<String, Double> getDataForChartOnArticle(boolean income) {
        List<Transaction> transactions = SaveData.getInstance().getTransactions();
        HashMap<String, Double> data = new HashMap<>();
        for (Transaction transaction : transactions) {
            if ((income && transaction.getAmount() > 0) || (!income && transaction.getAmount() < 0)) {
                String key = transaction.getArticle().getTitle();
                double summa = 0;
                double amount = transaction.getAmount();
                if (!income)
                    amount *= -1;
                if (data.containsKey(key))
                    summa = data.get(key);
                summa += amount * transaction.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(summa));
            }
        }
        return data;
    }

    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}