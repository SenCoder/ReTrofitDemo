package com.tcl.retrofitdemo.model;

import android.widget.TextView;

import com.lidroid.xutils.util.LogUtils;
import com.tcl.retrofitdemo.api.GitApi;
import com.tcl.retrofitdemo.api.WeatherApi;
import com.tcl.retrofitdemo.bean.User;
import com.tcl.retrofitdemo.bean.WeatherData;
import com.tcl.retrofitdemo.service.ApiGenerator;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shengyuan on 16-12-21.
 */

public class GitModel {

    private GitApi git;
    private TextView mTextView;

    public GitModel(TextView textView) {

        this.git =  ApiGenerator.createService(GitApi.class);
        mTextView = textView;
    }

    public void getUser(String username) {
        //binding.username.getText().toString()
        Call call = git.getUser(username);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User model = response.body();
                LogUtils.d(Thread.currentThread().getName());
                if (model == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        try {
                            LogUtils.d("responseBody = " + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        LogUtils.d("responseBody  = null");
                    }
                } else {
                    //200
                    LogUtils.d("Github Name :" + model.getName() + "\nWebsite :" + model.getBlog() + "\nCompany Name :" + model.getCompany());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                LogUtils.d("t = " + t.getMessage());
            }

        });
    }

    public void getWeather(String key) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://op.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherData> call = weatherApi.getWeather(key);

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData body = response.body();

                mTextView.setText(body.getResult().getData().getRealtime().getWeather().getTemperature());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                LogUtils.d("t = " + t.getMessage());
            }
        });
    }
}
