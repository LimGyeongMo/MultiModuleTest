package com.project.featurescroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.core.BaseRecyclerViewAdapter;
import com.project.featurescroll.databinding.DrNowListBinding;


public class DrNowAdapter extends BaseRecyclerViewAdapter<textItem, DrNowAdapter.ViewHolder> {

    public DrNowAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        textItem item = getItem(position);

       holder.binding.title.setText(String.valueOf(item.getTextNum()));
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.dr_now_list, parent, false));
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private DrNowListBinding binding;

        ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getLayoutPosition());
        }
    }
}
