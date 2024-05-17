package com.project.featurebus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.core.BaseRecyclerViewAdapter;
import com.project.featurebus.databinding.BusListChatBinding;

public class BusEditAdapter extends BaseRecyclerViewAdapter<BusChat, BusEditAdapter.ViewHolder> {

    public BusEditAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        BusChat item = getItem(position);

        holder.binding.tvChat.setText(item.getDetail());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_list_chat, parent, false));
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public BusListChatBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getLayoutPosition());
        }
    }

}
