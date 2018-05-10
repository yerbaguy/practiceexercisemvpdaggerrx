package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordDao;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordsDatabase;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.repository.LocalRepository;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.repository.LocalRepositoryImpl;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */

@Module
public class WordModule {

    private Context context;

    public WordModule(Context ctx) {

        this.context = ctx;

    }


    @Provides
    public WordDao getWordDAO(WordsDatabase wordsDatabase) {


        return wordsDatabase.wordDao();
    }

    public WordsDatabase getWordDatabase() {

        return Room.databaseBuilder(context.getApplicationContext(),
                WordsDatabase.class, "Word.db")
                .build();

    }

    @Provides
    public LocalRepository getLocalRepo(WordDao wordDao, Executor exec) {

        return new LocalRepositoryImpl(wordDao, exec);
    }

    @Provides @Named("vm")
    public CompositeDisposable getVMCompositeDisposable() {

        return new CompositeDisposable();
    }




}
