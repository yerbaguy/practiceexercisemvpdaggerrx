package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.di;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.view.PracticeExerciseMvpDaggerRxAddWord;

import dagger.Subcomponent;

/**
 * Created by bartoszmaliszewski on 27.04.18.
 */



@Subcomponent(modules = WordModule.class)
public interface WordComponent {

    void inject(PracticeExerciseMvpDaggerRxAddWord practiceExerciseMvpDaggerRxAddWord);
}
