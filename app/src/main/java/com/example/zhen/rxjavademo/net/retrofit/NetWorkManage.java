package com.example.zhen.rxjavademo.net.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManage {

    private Retrofit retrofit;

    private NetWorkManage(){

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5000,TimeUnit.MILLISECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static final class Holder{
        private static NetWorkManage INSTANCE = new NetWorkManage();
    }

    public static NetWorkManage getInstance(){
        return Holder.INSTANCE;
    }

    public <T> T createService(Class<T> tClass){
        return retrofit.create(tClass);
    }

}
