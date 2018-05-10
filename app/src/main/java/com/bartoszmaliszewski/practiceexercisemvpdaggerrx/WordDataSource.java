package com.bartoszmaliszewski.practiceexercisemvpdaggerrx;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */

public interface WordDataSource {


    Flowable<Word> getWord();

    void insertOrUpdate(Word wordEntity);
}
