package com.easy.fetcher.demo;


import com.easy.fetcher.biz.Request;
import com.easy.fetcher.biz.Response;
import com.easy.fetcher.rxjava.CustomObservableOnSubscribe;

import io.reactivex.Observable;

/**
 * Created by guoqingliang on 2019/7/29.
 */

public class Api {
    public static Observable<Response<LoginVO>> login(String userName, String password) {
        Request request = new Request.Builder()
                .url("")
                .method("get")
                .body("")
                .build();
        return Observable.create(new CustomObservableOnSubscribe<>(request, LoginVO.class));
    }
}
