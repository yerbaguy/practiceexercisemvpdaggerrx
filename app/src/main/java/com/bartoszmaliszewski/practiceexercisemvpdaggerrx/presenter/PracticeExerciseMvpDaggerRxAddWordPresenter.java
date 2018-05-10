package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.presenter;

import android.view.View;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract.PracticeExerciseMvpDaggerRxAddWordContract;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.model.PracticeExerciseMvpDaggerRxAddWordModel;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.model.PracticeExerciseMvpDaggerRxModel;

/**
 * Created by bartoszmaliszewski on 19.04.18.
 */

public class PracticeExerciseMvpDaggerRxAddWordPresenter implements PracticeExerciseMvpDaggerRxAddWordContract.Presenter {


    private PracticeExerciseMvpDaggerRxAddWordContract.Model addWordModel;

    private PracticeExerciseMvpDaggerRxAddWordContract.View addWordView;


    public PracticeExerciseMvpDaggerRxAddWordPresenter(PracticeExerciseMvpDaggerRxAddWordContract.View view) {

        this.addWordView = view;

        initPresenter();

    }


    void initPresenter() {

        addWordModel = new PracticeExerciseMvpDaggerRxAddWordModel();

        addWordView.initView();

    }


    @Override
    public void onClickAddWord(View view) {

    }
}
