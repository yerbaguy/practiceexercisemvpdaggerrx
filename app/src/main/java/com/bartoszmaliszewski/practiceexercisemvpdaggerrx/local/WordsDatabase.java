package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local;


import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bartoszmaliszewski on 10.04.18.
 */



@Database(entities = Word.class, version = 1)
public abstract class WordsDatabase extends RoomDatabase {

  //  private static volatile WordsDatabase INSTANCE;





    public static WordsDatabase mInstance;

    public static final String DATABASE_NAME = "Word";

    public abstract WordDao wordDao();

    public static WordsDatabase getInstance(Context context) {

        if (mInstance == null) {

 //           synchronized (WordsDatabase.class) {

 //               if (INSTANCE == null) {

                    mInstance = Room.databaseBuilder(context, WordsDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
 //                           WordsDatabase.class, "Word.db")
                            .build();
        }
 //           }
 //       }

        return mInstance;
    }
}
