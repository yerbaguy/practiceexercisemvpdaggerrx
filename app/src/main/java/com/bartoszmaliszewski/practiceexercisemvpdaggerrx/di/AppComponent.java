package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    WordComponent getWordComponent(WordModule wordModule);
}
