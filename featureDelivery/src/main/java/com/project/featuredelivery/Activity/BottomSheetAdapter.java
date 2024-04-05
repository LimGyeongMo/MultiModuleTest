package com.project.featuredelivery.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.core.BaseRecyclerViewAdapter;
import com.project.featuredelivery.R;
import com.project.featuredelivery.databinding.DeliveryListTestBinding;

public class BottomSheetAdapter extends BaseRecyclerViewAdapter<DTO, BottomSheetAdapter.ViewHolder> {

    public BottomSheetAdapter(Context context){super(context);}
    @Override
    public void onBindView(ViewHolder holder, int position) {
        DTO item = getItem(position);

        if (item.getTextNum()%2 == 0) {
            holder.binding.good.setBackgroundColor(context.getColor(com.project.ui.R.color.card_color1));
        } else {
            holder.binding.good.setBackgroundColor(context.getColor(com.project.ui.R.color.card_color2));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_list_test, parent, false));
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private DeliveryListTestBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getLayoutPosition());
        }
    }
}
