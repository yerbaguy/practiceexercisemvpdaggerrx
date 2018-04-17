package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

public interface WordDataSource {

  //  int countWord();

   // Flowable<Word> countWord();

    void insertOrUpdate(Word word);
}
