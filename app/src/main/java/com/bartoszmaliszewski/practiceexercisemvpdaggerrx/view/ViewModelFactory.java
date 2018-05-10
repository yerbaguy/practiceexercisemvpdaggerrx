package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.view;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.WordDataSource;

/**
 * Created by bartoszmaliszewski on 26.04.18.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {


    private final WordDataSource mDataSource;

    public ViewModelFactory(WordDataSource mDataSource) {
        this.mDataSource = mDataSource;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(WordViewModel.class)) {

            return (T) new WordViewModel(mDataSource);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");



       // return null;
    }
}
