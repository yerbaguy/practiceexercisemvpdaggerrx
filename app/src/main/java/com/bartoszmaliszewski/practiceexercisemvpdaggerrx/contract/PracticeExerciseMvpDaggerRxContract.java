package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract;

/**
 * Created by bartoszmaliszewski on 05.04.18.
 */

public interface PracticeExerciseMvpDaggerRxContract {

    interface View {

        void initView();

        void setViewData(String data);

    }

    interface Model {

        String getData();
    }

    interface Presenter {

        void onClickPullTheWord(android.view.View view);
        void onClickSupport(android.view.View view);
        void onClickSubmit(android.view.View view);
    }
}
