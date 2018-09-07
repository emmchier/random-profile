package com.example.emmchierchie.randomprofiles.Model.DAO;

import com.example.emmchierchie.randomprofiles.Model.POJO.User;
import com.example.emmchierchie.randomprofiles.Model.POJO.UserContainer;
import com.example.emmchierchie.randomprofiles.Model.ResultListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DAOInternet {

    private Retrofit retrofit;
    private DAOUserService service;

    // peticiones al servidor mediante Retrofit
    public DAOInternet() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory( GsonConverterFactory.create());

        retrofit = builder.client(httpClient.build()).build();
        service = retrofit.create(DAOUserService.class);
    }

    // pido al controller una lista de usuarios y la guardo en un contenedor de usuarios
    public void getAllUsers(final ResultListener<List<User>> controllerListener, int count){
        Call<UserContainer> retrofitListener = service.getUsers(count);
        retrofitListener.enqueue(new Callback<UserContainer>() {
            @Override
            public void onResponse(Call<UserContainer> call, Response<UserContainer> response) {
                UserContainer userContainer = response.body();
                controllerListener.finish(userContainer.getUser());
            }

            @Override
            public void onFailure(Call<UserContainer> call, Throwable t) {
                controllerListener.finish(new ArrayList<User>());
            }
        });
    }
}
