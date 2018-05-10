package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.presenter;

import android.view.View;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract.PracticeExerciseMvpDaggerRxContract;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.model.PracticeExerciseMvpDaggerRxAddWordModel;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.model.PracticeExerciseMvpDaggerRxModel;

/**
 * Created by bartoszmaliszewski on 05.04.18.
 */

public class PracticeExerciseMvpDaggerRxPresenter implements PracticeExerciseMvpDaggerRxContract.Presenter {


   // private View mView;
    private PracticeExerciseMvpDaggerRxContract.Model mModel;


    private PracticeExerciseMvpDaggerRxContract.View mView;


    public PracticeExerciseMvpDaggerRxPresenter(PracticeExerciseMvpDaggerRxContract.View view) {

        this.mView = view;
        initPresenter();

    }

    private void initPresenter() {

        mModel = new PracticeExerciseMvpDaggerRxModel();
       // mModel = new PracticeExerciseMvpDaggerRxAddWordModel();
        mView.initView();
    }



    @Override
    public void onClickPullTheWord(android.view.View view) {

        String data = mModel.getData();
        mView.setViewData(data);

    }

    @Override
    public void onClickSupport(View view) {

    }

    @Override
    public void onClickSubmit(View view) {

    }
}
