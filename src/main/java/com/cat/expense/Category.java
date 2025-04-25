package com.cat.expense;

public enum Category {
    FOOD("猫粮"),
    SNACK("零食"),
    TOY("玩具"),
    MEDICAL("生病");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
