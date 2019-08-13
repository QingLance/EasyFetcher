package com.easy.fetcher.rxjava;

import com.easy.fetcher.biz.Response;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by guoqingliang on 2019/7/30.
 */

public class CustomObserver<T> implements Observer<Response<T>> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Response<T> tResponse) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
