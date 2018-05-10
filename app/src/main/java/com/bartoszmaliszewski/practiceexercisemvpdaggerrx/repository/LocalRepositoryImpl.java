package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.repository;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordDao;

import java.util.concurrent.Executor;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */

public class LocalRepositoryImpl implements LocalRepository {

    private WordDao wordDao;
    private Executor executor;


    public LocalRepositoryImpl(WordDao wordDao, Executor executor) {

       wordDao = wordDao;
       executor = executor;

    }

    public void addWord(Word wordEntity) {

        executor.execute(() -> {

            wordDao.insertWord(wordEntity);
        });

    }


    @Override
    public void insertWord(Word wordEntity) {

    }
}
