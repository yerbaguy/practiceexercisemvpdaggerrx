package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

@android.arch.persistence.room.Dao
public interface WordDao {

   // @Query("SELECT COUNT(*) FROM Word")
   // int countWord();
   // Flowable<Word> countWord();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWord(Word word);
}
