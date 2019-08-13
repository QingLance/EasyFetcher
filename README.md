# EasyFetcher

> A simple http request library base on RxJava.
>
> 基于RxJava的一个简单的Http请求库。

## Feature

 - simple wrapper base on RxJava

## Usage

```java
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

```

Full example can be found [here](https://github.com/QingLance/EasyFetcher/tree/master/app/src/main/java/com/easy/fetcher/demo/).



## API

- todo


# License

MIT@[QingLance](https://github.com/QingLance).
