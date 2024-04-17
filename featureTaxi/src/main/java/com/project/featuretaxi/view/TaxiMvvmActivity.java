package com.project.featuretaxi.view;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.project.core.BaseActivity;
import com.project.featuretaxi.R;

import com.project.featuretaxi.databinding.TaxiActivityMvvmBinding;
import com.project.featuretaxi.model.Database;
import com.project.featuretaxi.viewModel.Observable;
import com.project.featuretaxi.viewModel.ViewModel;

public class TaxiMvvmActivity extends BaseActivity {
    public TaxiActivityMvvmBinding binding;
    public ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.taxi_activity_mvvm);

        viewModel =new ViewModel(Database.getInstance());
        binding.setViewModel(viewModel);

        bindAction();
        bindState();
    }

    private void bindAction() {
        binding.okBtnview.setOnClickListener(view -> {
                viewModel.getUser();
        });
    }

    private void bindState() {
        viewModel.winnerObservable
                .bind(value -> binding.userTextview.setText(value.toString()));
    }
}