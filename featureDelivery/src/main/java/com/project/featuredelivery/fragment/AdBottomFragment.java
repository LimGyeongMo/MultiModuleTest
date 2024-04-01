package com.project.featuredelivery.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.project.core.BaseBottomSheetDialogFragment;
import com.project.featuredelivery.databinding.TestFragmentBsdfBinding;
import com.project.ui.R;

public class AdBottomFragment extends BaseBottomSheetDialogFragment {

    private TestFragmentBsdfBinding binding;
    private BottomSheetBehavior behavior;
    private CallBackListener callBackListener;
    
    public AdBottomFragment(CallBackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }


    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getActivity(), com.project.featuredelivery.R.layout.test_fragment_bsdf, null);
        dialog.setContentView(view);

        behavior = BottomSheetBehavior.from((View) view.getParent());
        behavior.setSkipCollapsed(true);
        behavior.setFitToContents(true);
        behavior.setDraggable(true);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // 상태 변경 이벤트 처리
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    Log.d("onStateChanged:", "STATE_COLLAPSED");
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    Log.d("onStateChanged:"," STATE_HIDDEN");
                } else if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    Log.d("onStateChanged:"," STATE_DRAGGING");
                } else if (newState == BottomSheetBehavior.STATE_SETTLING) {
                    Log.d("onStateChanged:"," STATE_SETTLING");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(com.project.featuredelivery.R.layout.test_fragment_bsdf, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding = TestFragmentBsdfBinding.bind(getView());

        initLayout();
        initData();
    }

    private void initLayout() {
        binding.ok.setOnClickListener(view -> {
            callBackListener.ok();
            dismiss();
        });

        binding.close.setOnClickListener(view -> {
            callBackListener.cancel();
            dismiss();
        });
    }

    private void initData() {
        
    }

    public interface CallBackListener {
        void cancel();

        void ok();
    } 
}
