package com.example.emmchierchie.randomprofiles.Controller;

import com.example.emmchierchie.randomprofiles.Model.DAO.DAOInternet;
import com.example.emmchierchie.randomprofiles.Model.POJO.User;
import com.example.emmchierchie.randomprofiles.Model.ResultListener;

import java.util.List;

public class UserController {
    public void getUserResults(final ResultListener<List<User>> viewListener){
        ResultListener<List<User>> controllerListener = new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> results) {
                viewListener.finish(results);
            }
        };
        // pido la cantidad de usuarios
        DAOInternet daoInternetService = new DAOInternet();
        daoInternetService.getAllUsers(controllerListener, 50);
    }
}
