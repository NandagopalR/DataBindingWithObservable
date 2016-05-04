package com.nanda.databinding.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.nanda.databinding.BR;

public class ItemViewModel extends BaseObservable {

    private String name;
    private int mobile;

    public ItemViewModel(String name, int mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public ItemViewModel() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    public ItemViewModel setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        return this;
    }

    @Bindable
    public int getMobile() {
        return mobile;
    }

    public ItemViewModel setMobile(int mobile) {
        this.mobile = mobile;
        notifyPropertyChanged(BR.mobile);
        return this;
    }
}
