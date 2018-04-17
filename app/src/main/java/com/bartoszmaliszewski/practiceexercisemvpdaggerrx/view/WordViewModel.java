package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.view;

/**
 * Created by bartoszmaliszewski on 11.04.18.
 */



import android.arch.lifecycle.ViewModel;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.Word;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.WordDataSource;

import io.reactivex.Flowable;


public class WordViewModel extends ViewModel {

    private final WordDataSource mWordDataSource;

    private Word mWord;

    public WordViewModel(WordDataSource mWordDataSource) {

        this.mWordDataSource = mWordDataSource;

    }

  //  public Flowable<String> getEngWord() {

  //  }
}
