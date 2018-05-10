package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;

import java.util.List;

/**
 * Created by bartoszmaliszewski on 22.04.18.
 */

public interface DatabaseCallback {

    void onWordsLoaded(List<Word> wordEntities);

    void onWordDeleted();

    void onWordAdded();

    void onDataNotAvailable();

    void onWordUpdated();
}
