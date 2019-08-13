package com.easy.fetcher.rxjava;


import com.easy.fetcher.biz.HttpFetcher;
import com.easy.fetcher.biz.Request;
import com.easy.fetcher.biz.Response;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by guoqingliang on 2019/7/29.
 */

public class CustomObservableOnSubscribe<T> implements ObservableOnSubscribe<Response<T>> {

    private Request request;
    private Class<T> tClass;

    public CustomObservableOnSubscribe(Request request, Class<T> tClass) {
        this.request = request;
        this.tClass = tClass;
    }

    @Override
    public void subscribe(ObservableEmitter<Response<T>> emitter) throws Exception {
        // 1、todo 根据request 发起请求
        HttpFetcher httpFetcher = new HttpFetcher(request);
        Response<T> vo = httpFetcher.call(this.tClass);
        emitter.onNext(vo);
        emitter.onComplete();
    }

}
