package com.nanda.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nanda.databinding.databinding.MainActivityBinding;
import com.nanda.databinding.entity.User;
import com.nanda.databinding.utils.MethodUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        user = new User();
        mainActivityBinding.setUser(user);
        mainActivityBinding.login.setOnClickListener(this);
        mainActivityBinding.reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                MethodUtils.makeToast(this, user.getUsername() + " - " + user.getPassword());
                break;
            case R.id.reset:
                user.reset();
                break;
        }
    }
}
