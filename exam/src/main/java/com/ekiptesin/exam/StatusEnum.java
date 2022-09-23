package com.ekiptesin.exam;

public enum StatusEnum {
    OPEN("O"), PASSIVE("P");

    private String code;

    private StatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
