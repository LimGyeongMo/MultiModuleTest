package com.project.network.request;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestBus {
    @SerializedName("token")
    private String Token;
    @SerializedName("sendTime")
    private String SendTime;
    @SerializedName("proc")
    private String Proc;
    @SerializedName("requestData")
    private StringBuilder requestData = new StringBuilder();

    private int ParamCount = 0;

    public RequestBus(String Proc) {
        this.Token = "";
        this.SendTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.Proc = Proc;
    }

    public String getToken() {return Token;}

    public void addParam(String param) {
        if (ParamCount > 0) {
            requestData.append("");
        }
        requestData.append(param);
        ParamCount++;
    }

    public void commit() {
        this.requestData.toString();
    }

    public String getRequestData() {
        return requestData.toString();
    }

}
