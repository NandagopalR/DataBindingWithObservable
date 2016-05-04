package com.nanda.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.nanda.databinding.adapter.RecyclerviewAdapter;
import com.nanda.databinding.databinding.ActivityRecyclerviewBinding;
import com.nanda.databinding.entity.ItemViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerviewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ActivityRecyclerviewBinding mRecyclerviewBinding;
    private RecyclerView mRecyclerview;
    private RecyclerviewAdapter mAdapter;
    private List<ItemViewModel> itemViewModelList = new ArrayList<>();
    private Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerviewBinding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        mRecyclerview = mRecyclerviewBinding.recyclerview;
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerviewAdapter(this, setListItems());
        mRecyclerview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    private List<ItemViewModel> setListItems() {
        itemViewModelList.clear();
        for (int i = 0; i < 10; i++) {
            itemViewModelList.add(new ItemViewModel().setName("Name - " + i).setMobile(i + 100));
        }
        return itemViewModelList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();
    }
}
