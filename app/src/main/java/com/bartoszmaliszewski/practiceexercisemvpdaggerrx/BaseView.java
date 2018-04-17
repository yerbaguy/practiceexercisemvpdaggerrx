package com.bartoszmaliszewski.practiceexercisemvpdaggerrx;

/**
 * Created by bartoszmaliszewski on 05.04.18.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

}
