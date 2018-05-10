package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;
import android.icu.text.MeasureFormat;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

//@android.arch.persistence.room.Dao

@Dao
public interface WordDao {

   // @Query("SELECT COUNT(*) FROM Word")
   // int countWord();
   // Flowable<Word> countWord();

   // @Insert(onConflict = OnConflictStrategy.REPLACE)




    @Query("SELECT * FROM Word")
    Flowable<List<Word>> getWord();
   // Maybe<List<Word>> getWord();

    @Query("SELECT * FROM Word")
    List<Word> getTheWord();


   // @Query("SELECT COUNT(wordid) as id FROM Word")
    @Query("SELECT COUNT(*) FROM Word")
    int getNumberOfRows();

    @Query("SELECT COUNT(*) FROM Word")
    Integer numberOfRows();

 //   @Query("SELECT COUNT(wordid) FROM Word")
 //   Flowable<Word> getNumbersOfRows();

    @Query("SELECT COUNT(*) FROM Word")
    Flowable<Integer> getRowCount();


    @Insert
    void insertWord(Word word);

    @Query("SELECT COUNT(*) FROM Word")
    Cursor getAll();
}
