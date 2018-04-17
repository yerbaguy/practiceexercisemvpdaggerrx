package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.model;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract.PracticeExerciseMvpDaggerRxContract;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.view.PracticeExerciseMvpDaggerRx;

/**
 * Created by bartoszmaliszewski on 08.04.18.
 */

public class PracticeExerciseMvpDaggerRxModel implements PracticeExerciseMvpDaggerRxContract.Model{
    @Override
    public String getData() {

        return "Some data";

       // return null;
    }
}
