package com.nanda.databinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.nanda.databinding.R;
import com.nanda.databinding.databinding.RecyclerviewItemBinding;
import com.nanda.databinding.entity.ItemViewModel;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.DataViewHolder> {

    private final List<ItemViewModel> itemViewModelList;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private AdapterView.OnItemClickListener onItemClickListener;

    public RecyclerviewAdapter(Context context, List<ItemViewModel> itemViewModelList) {
        this.mContext = context;
        this.itemViewModelList = itemViewModelList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(mContext);
        final RecyclerviewItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_item, parent, false);
        return new DataViewHolder(this, binding);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
        ItemViewModel item = itemViewModelList.get(position);
        try {
            holder.setDataBinding(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    private void onItemHolderClick(DataViewHolder holder) {
        if (onItemClickListener != null)
            onItemClickListener.onItemClick(null, holder.binding.getRoot(), holder.getAdapterPosition(), holder.getItemId());
    }

    @Override
    public int getItemCount() {
        return itemViewModelList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecyclerviewItemBinding binding;
        private RecyclerviewAdapter mAdapter;

        public DataViewHolder(RecyclerviewAdapter mAdapter, final RecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.mAdapter = mAdapter;
            this.binding = binding;
            binding.setOnclickListener(this);
        }

        public void setDataBinding(ItemViewModel item) {
            binding.setItemdata(item);
        }


        @Override
        public void onClick(View v) {
            mAdapter.onItemHolderClick(this);
        }
    }

}
