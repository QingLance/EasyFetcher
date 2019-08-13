package com.easy.fetcher.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.easy.fetcher.R;
import com.easy.fetcher.biz.Response;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.clickMe).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Api.login("", "").subscribe(new Observer<Response<LoginVO>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("MainActivity", "onSubscribe");
            }

            @Override
            public void onNext(Response<LoginVO> loginVOResponse) {
                Log.d("MainActivity", "onNext");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
