package com.example.zhen.rxjavademo.rx;

import com.example.zhen.rxjavademo.entity.BaseEntity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class FlatmapFunction<T> implements Function<BaseEntity<T>, ObservableSource<T>> {

    @Override
    public ObservableSource<T> apply(BaseEntity<T> entity) throws Exception {
        if (entity.getCode() == 200) {
            return Observable.just(entity.getData());
        } else {
            return Observable.error(new Throwable("错误"));
        }
    }
}
