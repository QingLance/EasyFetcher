package com.easy.fetcher.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Created by guoqingliang on 2019/7/30.
 */

public class HttpFetcher {
    private Request request;
    private static OkHttpClient client = null;
    public static final int TIME_OUT = 15 * 1000;
    public static final int NET_BUFFER_SIZE = 1024;
    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    static {
        client = new OkHttpClient();
        client.setConnectTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        client.setReadTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
    }

    public HttpFetcher(Request request) {
        this.request = request;
    }

    public <T> Response<T> call(Class<T> tClass) {
        Type type = new ParameterizedTypeImpl(new Type[]{tClass}, Response.class, Response.class);
        Response<T> result = null;
        try {
            com.squareup.okhttp.Response okResponse = client.newCall(convert()).execute();
            String json = toJsonString(okResponse.body());
            result = JSON.parseObject(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String toJsonString(ResponseBody response) throws IOException {
        String responseBody = null;
        if (response == null) {
            return responseBody;
        }
        InputStream is = null;
        try {
            is = response.byteStream();
            byte[] buffer = new byte[NET_BUFFER_SIZE];
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            responseBody = new String(os.toByteArray(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeInputStream(is);
        }
        return responseBody;
    }

    private void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private com.squareup.okhttp.Request convert() {
        if (this.request != null) {
            String url = this.request.getUrl();
            String body = this.request.getBody();
            Map<String, String> header = this.request.getHeader();
            String method = this.request.getMethod();
            if (Request.POST.equals(method)) {
                com.squareup.okhttp.Request okRequest = new com.squareup.okhttp.Request.Builder()
                        .url(url)
                        .post(RequestBody.create(JSON_TYPE, body == null ? "" : body))
                        .build();
                return okRequest;
            }
            if (Request.GET.equals(method)) {
                com.squareup.okhttp.Request okRequest = new com.squareup.okhttp.Request.Builder()
                        .url(url)
                        .get()
                        .build();
                return okRequest;
            }
        }
        return null;
    }
}
