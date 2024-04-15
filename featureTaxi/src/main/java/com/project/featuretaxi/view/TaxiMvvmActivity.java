package com.project.featuretaxi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

    void bindAction() {
        binding.okBtnview.setOnClickListener(view -> {
            try {
                viewModel.getUser();
                Log.d("okBtnview ok", binding.okBtnview.toString());
            } catch ( Exception e){
                Log.d("okBtnview fail", e.toString());
            }
        });
    }

    void bindState() {
        viewModel.winnerObservable
                .bind(value -> binding.userTextview.setText(value.toString()));
    }
}