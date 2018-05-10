package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.database;

import android.app.Application;
import android.database.Cursor;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordDao;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordRoomDatabase;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 28.04.18.
 */

//public class WordRepository implements IWordDataSource {
public class WordRepository implements IWordDataSource {
//public class WordRepository {

   // SQLiteDatabase db;



    private IWordDataSource mLocalDataSource;

    private WordDao wordDao;


    private static WordRepository mInstance;


    public static WordRepository getInstance(IWordDataSource mLocalDataSource) {

        if (mInstance == null) {

            mInstance = new WordRepository(mLocalDataSource);
        }

        return mInstance;
    }


    public WordRepository(IWordDataSource mLocalDataSource) {

        this.mLocalDataSource = mLocalDataSource;
    }


//     public WordRepository(Application application) {
//
//         WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
//         wordDao = db.wordDao();
//     }




//    public static WordRepository getmInstance(WordDao wordDao) {
//
//        if (mInstance == null) {
//
//            mInstance = new WordRepository();
//        }
//
//
//    }



 //   @Override
 //   public void insertWord(Word... words) {

 //       mLocalDataSource.insertWord(words);
 //   }

    @Override
    public Flowable<List<Word>> getWord() {
   // public Maybe<List<Word>> getWord() {



      //  return wordDao.getWord();

        return mLocalDataSource.getWord();

       // return null;
    }


//    @Override
//    public Flowable<Integer> getRowCount() {
//
//         return wordDao.getRowCount();
//    }



    @Override
    public List<Word> getTheWord() {




         return wordDao.getTheWord();

      //  return mLocalDataSource.getTheWord();

       // return null;
    }


    //   @Override
 //   public List<Word> getWord() {

 //       return mLocalDataSource.getWord();
 //   }


    @Override
    public void insertWord(Word word) {

        mLocalDataSource.insertWord(word);
    }

//    @Override
//    public int getNumbersOfRows() {
//
//
//        return mLocalDataSource.getNumbersOfRows();
//       // return null;
//    }

    @Override
    public int getNumberOfRows() {



        return mLocalDataSource.numberOfRows();

       // return wordDao.getNumberOfRows();

      //  return mLocalDataSource.getNumberOfRows();

      //  return 0;
    }

    @Override
    public Integer numberOfRows() {


        return mLocalDataSource.numberOfRows();

      //  return wordDao.numberOfRows();

      //  return null;
    }

    @Override
    public List<Word> getRows() {
        return null;
    }


    @Override
    public Cursor getAll() {



          return mLocalDataSource.getAll();
       // return null;
    }


}
