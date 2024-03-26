package com.project.network.request;

import com.google.gson.annotations.SerializedName;

public class BusResponse {

    @SerializedName("seq")
    private int seq;
    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("resultMessage")
    private String resultMessage;
    @SerializedName("resultData")
    private String resultData;

    @SerializedName("rowCount")
    private String rowCount;

    @SerializedName("dataType")
    private String dataType;

    @SerializedName("columnName")
    private String columnName;

    @SerializedName("columnType")
    private String columnType;


    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultData() {
        if (resultData == null){
            resultData = "";
        }
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

    public String getRowCount() {
        return rowCount;
    }

    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnName() {
        if (columnName == null){
            columnName = "";
        }
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        if (columnType == null){
            columnType = "";
        }
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
}