package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

public interface WordDataSource {

  //  int countWord();

   // Flowable<Word> countWord();

 //   Flowable<Word> getEngWord();

 //   Flowable<Word> getPlWord();

    Flowable<Word> getWord();

    void insertOrUpdate(Word wordEntity);
}
