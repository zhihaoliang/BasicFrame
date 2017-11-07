package com.zhihaoliang.basicframe.http;

import com.zhihaoliang.basicframe.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by haoliang on 2017/10/26.
 * email:zhihaoliang07@163.com
 *
 * @author zhihaoliang
 */
public class ApiService {
    public static String BASE_URL;
    public static String WEB_URL;

    static {
        switch (Config.STATE) {
            case Config.ST_PRODUCT:
                BASE_URL = "http://bms.uc56.com/bms25-main/gateway/";
                WEB_URL = "http://bms.uc56.com/";
                break;
            case Config.ST_DEBUG:
                // BASE_URL = "http://113.106.93.46/uce-bms-main/gateway/";
                //BASE_URL = "http://113.106.93.37/uce-bms-main/gateway/";
                BASE_URL = "http://t1-bms.uc56.com/uce-bms-main/gateway/";
                WEB_URL = "http://t1-bms.uc56.com/";
                // BASE_URL = "http://153.35.117.132/uce-bms-main/gateway/";
                // BASE_URL = "http://10.201.2.41:8112/uce-bms-main/gateway/";
                break;
        }
    }

    public static synchronized ApiService ApiTypeService() {
        OkHttpClient httpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
        ApiService mApiTypeService = retrofit.create(ApiService.class);
        return mApiTypeService;
    }

    public static synchronized ApiService ApiStringService() {
        OkHttpClient httpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
        ApiService mApiTypeService = retrofit.create(ApiService.class);
        return mApiTypeService;
    }

    public static synchronized ApiService ApiXMLService() {
        OkHttpClient httpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
        ApiService mApiTypeService = retrofit.create(ApiService.class);
        return mApiTypeService;
    }

}
