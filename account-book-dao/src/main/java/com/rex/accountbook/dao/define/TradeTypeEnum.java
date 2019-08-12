package com.rex.accountbook.dao.define;

public enum TradeTypeEnum {

    INCOME("I", "收入"), COST("C", "支出");

    private String type;
    private String name;

    TradeTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
