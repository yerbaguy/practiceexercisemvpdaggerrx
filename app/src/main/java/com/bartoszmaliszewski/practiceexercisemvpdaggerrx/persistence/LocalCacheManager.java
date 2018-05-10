package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bartoszmaliszewski on 22.04.18.
 */

public class LocalCacheManager {

    private static final String DB_NAME = "Word";
    private Context context;
    private static LocalCacheManager _instance;
    private AppDatabase db;

    public static LocalCacheManager getInstance(Context context) {

        if (_instance == null) {

            _instance = new LocalCacheManager(context);
        }

        return _instance;

    }

    public LocalCacheManager(Context context) {

        this.context = context;

        db = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();

    }

    public void addWord(final DatabaseCallback databaseCallback, final String engword, final String plword) {


        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                Word wordEntity = new Word("lkjads", "lkjasd");
                db.wordDao().insertWord(wordEntity);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

                databaseCallback.onWordAdded();
            }

            @Override
            public void onError(Throwable e) {

                databaseCallback.onDataNotAvailable();
            }
        });
    }
}
