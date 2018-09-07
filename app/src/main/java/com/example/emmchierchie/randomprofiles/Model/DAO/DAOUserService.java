package com.example.emmchierchie.randomprofiles.Model.DAO;

import com.example.emmchierchie.randomprofiles.Model.POJO.UserContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DAOUserService {
    @GET("?")
    Call<UserContainer> getUsers(@Query("results") int count);
}
