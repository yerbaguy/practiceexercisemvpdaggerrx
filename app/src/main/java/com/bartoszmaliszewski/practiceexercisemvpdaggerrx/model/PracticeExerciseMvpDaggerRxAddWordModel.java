package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.model;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract.PracticeExerciseMvpDaggerRxAddWordContract;

/**
 * Created by bartoszmaliszewski on 19.04.18.
 */

public class PracticeExerciseMvpDaggerRxAddWordModel implements PracticeExerciseMvpDaggerRxAddWordContract.Model {
    @Override
    public String getData() {

        return "Some data";

        // return null;

    }
}
