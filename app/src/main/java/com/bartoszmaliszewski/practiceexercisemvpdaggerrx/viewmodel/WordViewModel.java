package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.repository.LocalRepository;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */

public class WordViewModel extends ViewModel {

    private LocalRepository localRepository;

    private CompositeDisposable compositeDisponsable;

    public WordViewModel(LocalRepository localRepo, CompositeDisposable disposable) {

        localRepository = localRepo;

        compositeDisponsable = disposable;
    }

    public void insertWord(Word word) {

        localRepository.insertWord(word);
    }
}
