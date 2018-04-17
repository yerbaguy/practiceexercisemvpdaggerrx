package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by bartoszmaliszewski on 10.04.18.
 */



@Database(entities = {Word.class}, version = 1)
public abstract class WordsDatabase extends RoomDatabase {

    private static volatile WordsDatabase INSTANCE;

    public abstract WordDao wordDao();

    public static WordsDatabase getInstance(Context context) {

        if (INSTANCE == null) {

            synchronized (WordsDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordsDatabase.class, "Word.db")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
