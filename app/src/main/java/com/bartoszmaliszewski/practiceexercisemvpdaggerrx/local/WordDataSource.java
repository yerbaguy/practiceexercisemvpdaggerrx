package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local;

import android.database.Cursor;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.database.IWordDataSource;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 28.04.18.
 */

public class WordDataSource implements IWordDataSource {

    private WordDao wordDao;
    private static WordDataSource mInstance;


    public WordDataSource(WordDao wordDao) {

        this.wordDao = wordDao;

    }


    public static WordDataSource getmInstance(WordDao wordDao) {

        if (mInstance == null) {

            mInstance = new WordDataSource(wordDao);
        }

        return mInstance;
    }


    @Override
    public Flowable<List<Word>> getWord() {


       // return mInstance.getWord();
        return wordDao.getWord();

       // return null;
    }

    @Override
    public List<Word> getTheWord() {

        return wordDao.getTheWord();

      //  return null;
    }

    //  @Override
  //  public List<Word> getWord() {

  //      return mInstance.getWord();
  //  }


    @Override
    public void insertWord(Word word) {

        wordDao.insertWord(word);
    }

//    @Override
//    public int getNumbersOfRows() {
//
//
//        return wordDao.getNumberOfRows();

      //  return null;
//    }

    @Override
    public int getNumberOfRows() {

        return mInstance.getNumberOfRows();

      //  return 0;
    }

    @Override
    public Integer numberOfRows() {


        return mInstance.numberOfRows();

      //  return wordDao.numberOfRows();

      //  return null;
    }

    @Override
    public List<Word> getRows() {

        return mInstance.getRows();

       // return null;
    }

    @Override
    public Cursor getAll() {


        return mInstance.getAll();

       // return null;
    }
}
