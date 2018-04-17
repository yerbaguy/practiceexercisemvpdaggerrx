package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

@Database( entities = {Word.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WordDao wordDao();


}
