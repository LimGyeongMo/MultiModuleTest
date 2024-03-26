package com.project.network;

import android.content.Context;
import android.os.Build;

import com.project.network.app.MyPreferencesManager;
import com.project.network.request.BusResponse;
import com.project.network.request.RequestBus;

import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class Retrofit2Client {

    private static MyPreferencesManager myPreferencesManager;
    private static RetrofitInterface retrofitInterface;
    private static String token = "";

    public static RetrofitInterface getClient(Context context){
        myPreferencesManager = MyPreferencesManager.getInstance(context);

        if (retrofitInterface == null ) {

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            CookieManager manager = new CookieManager();
            manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

            OkHttpClient builder = new OkHttpClient
                    .Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .addInterceptor(chain -> {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + token)
                                .addHeader("OsType", "ANDROID")
                                .addHeader("OsVersion", Build.VERSION.SDK_INT + "")
                                .addHeader("Model", Build.MODEL)
                                .addHeader("AppVersion", "1")
                                .addHeader("PrivateIP",  "131.121....")
                                .build();
                        return chain.proceed(newRequest);
                    })
                    .cookieJar(new JavaNetCookieJar(manager))
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Define.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder)
                    .build();

            retrofitInterface = retrofit.create(RetrofitInterface.class);

        }
            return retrofitInterface;

    }
    public interface RetrofitInterface {
        @POST("Main/Proc")
        Call<BusResponse> getSlideTaxi(@Body RequestBus requestBus);
    }
}
