package com.nanda.databinding.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import com.nanda.databinding.BR;

public class User extends BaseObservable {

    public String username;
    public String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public void reset() {
        setUsername("");
        setPassword("");
    }

    public TextWatcher getUpdatedUsername() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setUsername(s.toString());
            }
        };
    }

    public TextWatcher getUpdatedPassword() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setPassword(s.toString());
            }
        };
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
