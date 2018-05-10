package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract;

/**
 * Created by bartoszmaliszewski on 19.04.18.
 */

public interface PracticeExerciseMvpDaggerRxAddWordContract {

    interface View {

        void initView();

        void setViewData(String data);

    }

    interface Model {

        String getData();

    }

    interface Presenter {

        void onClickAddWord(android.view.View view);

    }
}
