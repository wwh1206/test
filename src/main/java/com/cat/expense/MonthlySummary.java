package com.cat.expense;

import java.util.*;

public class MonthlySummary {
    private Map<String, Map<Category, Double>> monthlyData = new HashMap<>();

    public void addRecord(ExpenseRecord record) {
        String monthKey = record.getMonthKey();
        monthlyData.putIfAbsent(monthKey, new EnumMap<>(Category.class));

        Map<Category, Double> monthData = monthlyData.get(monthKey);
        monthData.merge(record.getCategory(), record.getAmount(), Double::sum);
    }

    public void generateReport(String month) {
        Map<Category, Double> data = monthlyData.get(month);
        if (data == null) {
            System.out.println("无该月记录");
            return;
        }

        System.out.println("=== " + month + " 月度报告 ===");
        data.forEach((category, total) -> 
            System.out.printf("%s: ¥%.2f%n", category, total));
        System.out.printf("总支出: ¥%.2f%n", 
            data.values().stream().mapToDouble(Double::doubleValue).sum());
    }
}
