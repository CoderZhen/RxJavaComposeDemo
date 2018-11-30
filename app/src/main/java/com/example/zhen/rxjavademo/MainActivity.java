package com.example.zhen.rxjavademo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zhen.rxjavademo.entity.BaseEntity;
import com.example.zhen.rxjavademo.entity.UserInfo;
import com.example.zhen.rxjavademo.net.retrofit.NetWorkManage;
import com.example.zhen.rxjavademo.net.service.ApiService;
import com.example.zhen.rxjavademo.rx.FlatmapFunction;
import com.example.zhen.rxjavademo.rx.SchedulerProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity-vv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> map = new HashMap<>();
        map.put("phone", "13594347817");
        map.put("passwd", "123456");

        NetWorkManage.getInstance().createService(ApiService.class)
                .getInfo(map)
                .flatMap(new FlatmapFunction<UserInfo>())
                .compose(SchedulerProvider.getInstance().<UserInfo>applyScheduler())
                .subscribe(new Observer<UserInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        Log.d(TAG, "name : " + userInfo.getName());
                        Log.d(TAG, "text : " + userInfo.getText());
                        Log.d(TAG, "phone : " + userInfo.getPhone());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });

    }

}
