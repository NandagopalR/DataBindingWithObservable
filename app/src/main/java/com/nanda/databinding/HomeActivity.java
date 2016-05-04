package com.nanda.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nanda.databinding.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityHomeBinding homeBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        homeBinding.btnLogin.setOnClickListener(this);
        homeBinding.btnRecyclerview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnRecyclerview:
                startActivity(new Intent(this, RecyclerviewActivity.class));
                break;
        }
    }
}
