package com.cat.expense;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ExpenseRecord {
    private double amount;
    private Category category;
    private Date date;

    public ExpenseRecord(double amount, Category category, Date date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String getMonthKey() {
        return new SimpleDateFormat("yyyy-MM").format(date);
    }

    // Getters
    public double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public Date getDate() { return date; }
}
