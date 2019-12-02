package com.fsy.dto;

public class ColumnDto {
    //INT VARCHAR DATETIME FLOAT DOUBLE
    private String columnType;

    private String columnName;

    private Integer columnLength;

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(Integer columnLength) {
        this.columnLength = columnLength;
    }
}
