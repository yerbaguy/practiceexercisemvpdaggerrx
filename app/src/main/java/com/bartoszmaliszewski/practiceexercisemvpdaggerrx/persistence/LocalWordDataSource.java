package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import io.reactivex.Flowable;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

public class LocalWordDataSource implements WordDataSource{

    private final WordDao wordDao;


    public LocalWordDataSource(WordDao wordDao) {

        this.wordDao = wordDao;

    }


 //   @Override
  //  public Flowable<Word> countWord() {
 //   public int countWord() {

 //       return wordDao.countWord();

       // return null;
 //   }

    @Override
    public void insertOrUpdate(Word word) {

        wordDao.insertWord(word);

    }
}
