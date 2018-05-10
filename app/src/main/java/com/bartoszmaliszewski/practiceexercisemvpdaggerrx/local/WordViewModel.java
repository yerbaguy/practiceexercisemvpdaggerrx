package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.database.WordRepository;


/**
 * Created by bartoszmaliszewski on 10.05.18.
 */

public class WordViewModel extends AndroidViewModel {

    private WordRepository repository;


    private int countRows;

    private int rows;

    public WordViewModel(@NonNull Application application) {
        super(application);

      //  repository = new WordRepository(application);

        countRows = repository.getNumberOfRows();

     //   rows = repository.getRowCount();
    }


    public int rowCount() {

        return countRows;
       // return repository.getNumberOfRows();

    }


    public void insert(Word word) {

        repository.insertWord(word);
    }
}
