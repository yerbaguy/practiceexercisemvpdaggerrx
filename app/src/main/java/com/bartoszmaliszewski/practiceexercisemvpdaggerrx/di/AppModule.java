package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.di;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */

public class AppModule {


    @Singleton
    @Provides
    public Executor getExecutor() {

        return Executors.newFixedThreadPool(2);
    }


}
