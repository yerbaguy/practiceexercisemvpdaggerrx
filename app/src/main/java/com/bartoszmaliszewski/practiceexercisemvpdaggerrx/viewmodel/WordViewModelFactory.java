package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.repository.LocalRepository;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */

public class WordViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    LocalRepository localRepository;

    @Inject @Named("vm")
    CompositeDisposable compositeDisposable;


    @Inject
    public WordViewModelFactory() {


    }




    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return null;
    }
}
