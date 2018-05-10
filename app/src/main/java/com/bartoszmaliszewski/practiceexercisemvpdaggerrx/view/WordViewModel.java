package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.view;

/**
 * Created by bartoszmaliszewski on 11.04.18.
 */



import android.arch.lifecycle.ViewModel;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.WordDataSource;

import io.reactivex.Completable;
import io.reactivex.Flowable;


public class WordViewModel extends ViewModel {

    private final WordDataSource mWordDataSource;

    private Word mWordEntity;

    public WordViewModel(WordDataSource mWordDataSource) {

        this.mWordDataSource = mWordDataSource;

    }

  //  public Flowable<String> getEngWord() {

  //  }

    public Flowable<String> getEngWord() {

        return mWordDataSource.getWord()
                .map(word -> {

                    mWordEntity = word;
                    return word.getEngword();
                });
    }


    public Flowable<String> getPlWord() {

        return mWordDataSource.getWord()
                .map(word -> {

                    mWordEntity = word;
                    return word.getPlword();
                });
    }

   // public Flowable<String> getEngWord() {

   //     return mWordDataSource.insertOrUpdate(mWordEntity);
   // }


    public Completable addWord(String engword, String plword) {

        return Completable.fromAction(()-> {

          Word mWordEntity = new Word(engword, plword);

            System.out.println("mWordEntity" + mWordEntity);

            mWordDataSource.insertOrUpdate(mWordEntity);
        });
    }
}
