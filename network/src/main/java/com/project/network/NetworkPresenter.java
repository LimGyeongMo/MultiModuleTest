package com.project.network;

import android.content.Context;
import android.util.Log;

import com.project.network.request.BusResponse;
import com.project.network.request.RequestBus;
import com.project.network.resultInterface.BusBaseInterface;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkPresenter {
    private Context context;

    public NetworkPresenter(Context context) {
        this.context = context;
    }

    public void getSlideTaxi(RequestBus requestBus, BusBaseInterface anInterface) {
        Retrofit2Client
                .getClient(context)
                .getSlideTaxi(requestBus)
                .enqueue(new Callback<BusResponse>() {
                    @Override
                    public void onResponse(Call<BusResponse> call, Response<BusResponse> response) {
                        try {
                            anInterface.success(null);
                        } catch (Exception e) {
                            anInterface.success(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<BusResponse> call, Throwable t) {
                        anInterface.success(null);
                    }
                });
    }
}


