package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.R;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract.PracticeExerciseMvpDaggerRxContract;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.presenter.PracticeExerciseMvpDaggerRxPresenter;

public class PracticeExerciseMvpDaggerRx extends AppCompatActivity implements PracticeExerciseMvpDaggerRxContract.View {

    private TextView mTextView;
    private TextView textViewPulledTheWord, textViewSupportWithPulledTheWord, textViewAddWords;
    private EditText editTextEnglishWord;
    private Button mButton;
    private Button btnPullTheWord, btnSupport, btnSubmitEngWord;
    private PracticeExerciseMvpDaggerRxPresenter mPresenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_exercise_mvp_dagger_rx);

        mPresenter = new PracticeExerciseMvpDaggerRxPresenter(this);

        textViewAddWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWord();
            }
        });

    }

    @Override
    public void initView() {

      //  mTextView = (TextView) findViewById(R.id.textView);
        textViewPulledTheWord = (TextView) findViewById(R.id.textViewPulledTheWord);
        textViewSupportWithPulledTheWord = (TextView) findViewById(R.id.textViewSupportWithPulledTheWord);
        textViewAddWords = (TextView) findViewById(R.id.textViewAddWords);
        editTextEnglishWord = (EditText) findViewById(R.id.editTextEnglishWord);
     //   mButton = (Button) findViewById(R.id.button);
        btnPullTheWord = (Button) findViewById(R.id.btnPullTheWord);
        btnSupport = (Button) findViewById(R.id.btnSupport);
        btnSubmitEngWord = (Button) findViewById(R.id.btnSubmitEngWord);

      //  mButton.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {
      //          mPresenter.onClick(view);
      //      }
      //  });

    }

    public void addWord() {

        Intent addWord = new Intent(getApplicationContext(), PracticeExerciseMvpDaggerRxAddWord.class);
        startActivity(addWord);
    }




    @Override
    public void setViewData(String data) {

        mTextView.setText(data);

    }
}
