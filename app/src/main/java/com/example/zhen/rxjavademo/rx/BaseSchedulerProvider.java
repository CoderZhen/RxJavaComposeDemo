package com.example.zhen.rxjavademo.rx;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {

    Scheduler io();

    Scheduler ui();

    <T> ObservableTransformer<T, T> applyScheduler();

}
