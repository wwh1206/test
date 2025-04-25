package com.cat.expense;

import java.util.*;
import java.text.ParseException;

public class CatExpenseTracker {
    private static MonthlySummary summary = new MonthlySummary();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. 添加记录\n2. 生成报告\n3. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    generateReport();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void addExpense() {
        try {
            System.out.print("请输入金额：");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("分类(1.猫粮 2.零食 3.玩具 4.生病)：");
            Category category = Category.values()[scanner.nextInt()-1];
            scanner.nextLine();

            System.out.print("日期(yyyy-MM-dd)：");
            Date date = dateFormat.parse(scanner.nextLine());

            summary.addRecord(new ExpenseRecord(amount, category, date));
            System.out.println("记录添加成功！");
        } catch (Exception e) {
            System.out.println("输入错误：" + e.getMessage());
        }
    }

    private static void generateReport() {
        System.out.print("输入月份(yyyy-MM)：");
        String month = scanner.nextLine();
        summary.generateReport(month);
    }
}
