package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */


@Scope
@Retention(value = RetentionPolicy.RUNTIME)
public @interface WordScope {
}
