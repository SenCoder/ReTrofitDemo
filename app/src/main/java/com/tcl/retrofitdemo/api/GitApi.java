package com.tcl.retrofitdemo.api;

import com.tcl.retrofitdemo.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shengyuan on 16-12-21.
 */

public interface GitApi {

    /**
     *
     * @param username is for passing values from editText, eg:user=basil2style.
     *
     *  @GET("/users/{username}") is OK
     */
    @GET("/users/{user}")
    public Call<User> getUser(@Path("user") String username);
}
