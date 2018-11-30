package com.example.zhen.rxjavademo.net.service;

import com.example.zhen.rxjavademo.entity.BaseEntity;
import com.example.zhen.rxjavademo.entity.UserInfo;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("login?key=00d91e8e0cca2b76f515926a36db68f5")
    Observable<BaseEntity<UserInfo>> getInfo(@FieldMap Map<String, String> map);

}
