package com.tcl.retrofitdemo.api;

import com.tcl.retrofitdemo.bean.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shengyuan on 16-12-21.
 */

public interface WeatherApi {

    @GET("onebox/weather/query?cityname=深圳")
    Call<WeatherData> getWeather(@Query("key") String key);

}
