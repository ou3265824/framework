package com.example.framework.http.builder;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Administrator on 2016/4/27.
 */
public class HeaderInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request=chain.request().newBuilder()
                .build();
        return chain.proceed(request);
    }



}
