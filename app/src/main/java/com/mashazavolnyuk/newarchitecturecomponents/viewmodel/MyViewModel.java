package com.mashazavolnyuk.newarchitecturecomponents.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.mashazavolnyuk.newarchitecturecomponents.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashka on 23.08.17.
 */

public class MyViewModel extends ViewModel {
    private static final String TAG = "MyViewModel";
    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        Log.d(TAG,"getUsers()");
        if (users == null) {
            users = new MutableLiveData<>();
            List<User> list = loadUsers();
            users.setValue(list);
            return users;
        }
        else
        return users;
    }

    private List<User> loadUsers()  {
        Log.d(TAG,"loadUsers()");
        List<User> userList=new ArrayList<>();
        for(int i=0;i<2000;i++){
           userList.add(new User(String.valueOf(i)));
        }
        return userList;
    }
}
