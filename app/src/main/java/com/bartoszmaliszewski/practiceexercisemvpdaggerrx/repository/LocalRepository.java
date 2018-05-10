package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.repository;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */

public interface LocalRepository {

    public void insertWord(Word wordEntity);
}
