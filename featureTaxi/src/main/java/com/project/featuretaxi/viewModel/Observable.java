package com.project.featuretaxi.viewModel;

public class Observable<T> {
    private Block block;

    private T value;

    public Observable(T value) {
        this.value = value;
    }

    public interface Block<T> {
        void onNext(T value);
    }

    public void bind(Block block) {
        this.block = block;
    }

    public void onNext(T value) {
        this.value = value;
        block.onNext(value);
    }
}