package com.project.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.core.BaseRecyclerViewAdapter;
import com.project.ui.databinding.TestItemTapScrollBinding;

public class testItemAdapter extends BaseRecyclerViewAdapter<testItem, testItemAdapter.ViewHolder> {

    public testItemAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        testItem item = getItem(position);

        if(position%2 == 0) {
            holder.binding.clInfo.setBackgroundTintList(ColorStateList.valueOf(context.getColor(R.color.color_01CAFF)));
        } else {
            holder.binding.clInfo.setBackgroundTintList(ColorStateList.valueOf(context.getColor(R.color.color_0D4D82)));
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item_tap_scroll, parent, false));
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TestItemTapScrollBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getLayoutPosition());
        }
    }
}
