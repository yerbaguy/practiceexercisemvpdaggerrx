package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 28.04.18.
 */

public interface IWordDataSource {

   // void insertWord(Word...words);


 //   @Query("SELECT * FROM Word")
    Flowable<List<Word>> getWord();

    List<Word> getTheWord();


    void insertWord(Word word);

 //   int getNumbersOfRows();


 //   @Query("SELECT COUNT(*) FROM Word")
    int getNumberOfRows();

    Integer numberOfRows();

    List<Word> getRows();

    Cursor getAll();
}
