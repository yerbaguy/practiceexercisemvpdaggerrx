package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.view;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.R;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.contract.PracticeExerciseMvpDaggerRxAddWordContract;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.database.IWordDataSource;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.database.WordRepository;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.Word;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordDataSource;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordsDatabase;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.DatabaseCallback;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.DatabaseHelper;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.LocalCacheManager;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.presenter.PracticeExerciseMvpDaggerRxAddWordPresenter;
import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.viewmodel.WordViewModelFactory;

import org.json.JSONException;
import org.json.JSONObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
//import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import rx.functions.Action1;
//import rx.Subscriber;
//import rx.Subscription;
//import rx.functions.Action1;

import javax.inject.Inject;
import javax.inject.Named;

import java.lang.Integer;

//import android.arch.lifecycle.ViewModelProviders;


import static com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.DatabaseHelper.engword;
import static com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence.DatabaseHelper.plword;

import com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local.WordDao;


public class PracticeExerciseMvpDaggerRxAddWord extends AppCompatActivity implements PracticeExerciseMvpDaggerRxAddWordContract.View, DatabaseCallback {


    TextView textViewPracticeExercise, textViewEngWord, textViewPlWord;
    EditText editTextEngWord, editTextPlWord;
    Button btnAddWords;

    @Inject @Named("practiceexercisemvpdaggerrxaddword")
    CompositeDisposable compositeDisposable;

    @Inject
    WordViewModelFactory wordViewModelFactory;

    private static final String TAG = PracticeExerciseMvpDaggerRxAddWord.class.getSimpleName();

    private WordViewModel wordViewModel;

    private LocalCacheManager localCacheManager;

    private PracticeExerciseMvpDaggerRxAddWordPresenter addWordPresenter;

   // private final CompositeDisposable mDisposable = new CompositeDisposable();

 //   private CompositeDisposable compositeDisposable;

    private ViewModelFactory mViewModelFactory;

    private WordViewModel mViewModel;

    private WordRepository wordRepository;

    private WordDao wordDao;


    private int countRows = 1;

    DatabaseHelper db;

    List<Word> wordList = new ArrayList<>();
    List<Word> words = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    private WordViewModel mWordViewModel;


    int[] count = new int[1];


//    final Observable<Integer> serverDownloadObservable = Observable.create(emitter -> {
//
//
//
//        Integer val = wordRepository.getNumberOfRows();
//        emitter.onNext(val);
//        emitter.onComplete();
//    });


  //  Observable<Boolean> addWord = Observable.create(emitter -> {
  //      emitter.onNext(databaseHelper.addWord(editTextEngWord, editTextPlWord));
  //      emitter.onComplete();
  //  });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_exercise_mvp_dagger_rx_add_word);

        compositeDisposable = new CompositeDisposable();

        //      textViewPracticeExercise = (TextView) findViewById(R.id.textViewPracticeExercise);
        //      editTextEngWord = (EditText) findViewById(R.id.editTextEngWord);
        //      editTextPlWord = (EditText) findViewById(R.id.editTextPlWord);
        //      btnAddWords = (Button) findViewById(R.id.btnAddWords);

        //      textViewEngWord = (TextView) findViewById(R.id.textViewEngWord);
        //      textViewPlWord = (TextView) findViewById(R.id.textViewPlWord);

        addWordPresenter = new PracticeExerciseMvpDaggerRxAddWordPresenter(this);

        WordsDatabase wordsDatabase = WordsDatabase.getInstance(this);
        wordRepository = WordRepository.getInstance(WordDataSource.getmInstance(wordsDatabase.wordDao()));

      //  wordRepository = WordRepository.getInstance(WordDataSource.getmInstance(wordsDatabase.wordDao()), wordDao);


      //  mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);





//        serverDownloadObservable.
//                observeOn(AndroidSchedulers.mainThread()).
//
//                subscribeOn(Schedulers.newThread()).
//
//                subscribe(integer -> {
//
//                    System.out.println(integer);
//                  //  updateTheUserInterface(integer); // this methods updates the ui
//                  //  view.setEnabled(true); // enables it again
//                });








        btnAddWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String engword = editTextEngWord.getText().toString();
                String plword = editTextPlWord.getText().toString();


                Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(ObservableEmitter<Object> e) throws Exception {

                        Word word = new Word(engword, plword);

                        word.setEngword(engword);

                        word.setPlword(plword);



                        wordRepository.insertWord(word);
                        e.onComplete();



                      //  editTextEngWord.setText("");
                      //  editTextPlWord.setText("");
                    }
                })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer<Object>() {
                            @Override
                            public void accept(Object t) throws Exception {

                                Toast.makeText(PracticeExerciseMvpDaggerRxAddWord.this, "Word added", Toast.LENGTH_SHORT).show();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                Toast.makeText(PracticeExerciseMvpDaggerRxAddWord.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                editTextEngWord.setText("");
                editTextPlWord.setText("");
            }


        });


      //  mViewModelFactory = Injection.provideViewModelFactory(this);
       // mViewModel = ViewModelProviders






     //   btnAddWords.setOnClickListener(new View.OnClickListener() {
     //       @Override
     //       public void onClick(View view) {

                // saveWord();
     //       }

     //   });


      //  btnAddWords.setOnClickListener(v -> {
      //      Disposable subscribe = serverDownloadObservable.
      //              observeOn(AndroidSchedulers.mainThread()).
      //              subscribeOn(Schedulers.io()).subscribe(String -> {

      //                  System.out.println("lkjasdf");

      //      });

      //      mDisposable.add(subscribe);
      //  });




  //      btnAddWords.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View view) {



  //              String engWord = editTextEngWord.getText().toString();
  //              String plWord = editTextPlWord.getText().toString();
  //              if (engWord.matches("") && plWord.matches("")) {
  //                  Toast.makeText(getApplicationContext(), "You should type in both polish and english words", Toast.LENGTH_LONG).show();
  //              } else {
                   // textViewEngWord.setText(engWord);
                   // textViewPlWord.setText(plWord);
  //                  JSONObject postDataParams = new JSONObject();
  //                  try {
  //                      postDataParams.put("engWord", engWord);
  //                      postDataParams.put("plWord", plWord);
  //                      Log.e("params", postDataParams.toString());
  //                  } catch (JSONException e) {
  //                      e.printStackTrace();
  //                  }
                    //  new SendJsonDataToServer().execute(postDataParams.toString());

  //                  textViewEngWord.setText(engWord);
  //                  textViewPlWord.setText(plWord);

  //                  System.out.println(engWord);
  //                  System.out.println(plWord);
                   // db.addWord(engWord, plWord);

  //                  mDisposable.add(wordViewModel.addWord(engWord, plWord)
  //                          .subscribeOn(Schedulers.io())
  //                          .observeOn(AndroidSchedulers.mainThread())
  //                          .subscribe(() -> btnAddWords.setEnabled(true),
  //                                  throwable -> Log.e(TAG, "Unable to add word", throwable)));


  //                  editTextEngWord.setText("");
  //                  editTextPlWord.setText("");
  //              }
  //          }


           // }
  //      });






        textViewPracticeExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                practiceExercice();
            }
        });

       // int countRows = 1;
       // countRows = wordRepository.getNumberOfRows();

       // System.out.println(wordRepository.getWord());

        getTheWord(); //here

       // getTheNumberOfRows();

       // getCountRows(words);

      //  getWordCount();

       // System.out.println("getCountRows" + getCountRows(countRows));

      //  getWordCount();

        countRows(count); // here
    }



    public void saveWord() {

        DatabaseCallback databaseCallback = null;

        String engw = editTextEngWord.getText().toString();
        String plw = editTextPlWord.getText().toString();

        System.out.println(engw);
        System.out.println(plw);

      //  btnAddWords.setEnabled(false);

      //  mDisposable.add(wordViewModel.addWord(engw, plw)

      //          .subscribeOn(Schedulers.io())
      //          .observeOn(AndroidSchedulers.mainThread())
      //          .subscribe(() -> btnAddWords.setEnabled(true),
      //                  throwable -> Log.e(TAG, "Unable to insert word", throwable))
              //  throwable -> Log.e("kjasd", "Unable to insert word", Throwable)))

      //  );

      //  localCacheManager.addWord(databaseCallback, editTextEngWord, editTextPlWord);

        if(!TextUtils.isEmpty(editTextEngWord.getText().toString()) && !TextUtils.isEmpty(editTextPlWord.getText().toString()) ) {

            LocalCacheManager.getInstance(this).addWord(databaseCallback, editTextEngWord.getText().toString(), editTextPlWord.getText().toString());

            editTextEngWord.setText("");
            editTextPlWord.setText("");

        }


    }


    public void practiceExercice() {

        Intent practiceExercise = new Intent(getApplicationContext(), PracticeExerciseMvpDaggerRx.class);
        startActivity(practiceExercise);
    }


    @Override
    public void initView() {

        textViewPracticeExercise = (TextView) findViewById(R.id.textViewPracticeExercise);
        editTextEngWord = (EditText) findViewById(R.id.editTextEngWord);
        editTextPlWord = (EditText) findViewById(R.id.editTextPlWord);
        btnAddWords = (Button) findViewById(R.id.btnAddWords);

        textViewEngWord = (TextView) findViewById(R.id.textViewEngWord);
        textViewPlWord = (TextView) findViewById(R.id.textViewPlWord);

    }

    @Override
    public void setViewData(String data) {

    }

    @Override
    public void onWordsLoaded(List<Word> wordEntities) {

        Log.d("room", "onDataLoaded");

    }

    @Override
    public void onWordDeleted() {

        Log.d("room", "onDataDeleted");

    }

    @Override
    public void onWordAdded() {

        Log.d("room", "onWordAdded");
    }

    @Override
    public void onDataNotAvailable() {

        Log.d("room", "onDataNotAvailable");
    }

    @Override
    public void onWordUpdated() {

        Log.d("room", "onDataUpdated");

    }


    private void getTheWord() {


        Word word = new Word();

        int[] count = new int[1];


//        System.out.println(wordRepository.getWord());
//
//        List<Word> words = new ArrayList<>();
//
//        for (Word word : words) {
//
//            System.out.println("Engword" + word.getEngword() + "plword" + word.getPlword() );
//        }




        Disposable disposable = wordRepository.getWord()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Word>>() {
                    @Override
                    public void accept(List<Word> words) throws Exception {

                        //    System.out.println(words);

                        int[] count = new int[1];

                       // count = new int[words.size()];

                        for (int i = 0; i < count.length; i++) {

                            count[i] = words.size();
                        }


                        countRows(count);



                       // int countWord = words.size();


                        System.out.println("count" + count[0]);
                        System.out.println("words size" + words.size());

                      //  getCountRows(countWord);
                      //  getCountRows(countWord);
                     //   getCountRows(words);


                        for (Word word : words) {

                            System.out.println("engword" + word.getEngword() + "plword" + word.getPlword());
                        }

                   //  System.out.println(words);
                   //     onGetTheWord(words);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(PracticeExerciseMvpDaggerRxAddWord.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        compositeDisposable.add(disposable);


//        Observable<Integer> getInfo = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//
//
//                try {
//
//
//                    Integer info = wordRepository.getNumberOfRows();
//                    emitter.onNext(info);
//                    emitter.onComplete();
//
//
//                } catch ( Exception e) {
//
//                    emitter.onError(e);
//
//                }
//            }
//        });
//
//        getInfo
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        System.out.println(integer);
//                    }
//                });
//
//





    }


    private void getTheNumberOfRows() {
   // public int getTheNumberOfRows() {



      //  System.out.println(wordRepository.getNumberOfRows());


        Disposable disposable = wordRepository.getWord()
      //  Disposable disposable = wordRepository.getNumberOfRows()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Word>>() {
                    @Override
                    public void accept(List<Word> words) throws Exception {
                        //    System.out.println(words);

                     int countRows[] = new int[1];
                     int count;

                      //   for (Word word : words) {

                      //      System.out.println("engword" + word.getEngword() + "plword" + word.getPlword());
                      //  }

                         count = words.size();


                   //   getCountRows();
                        System.out.println(countRows);

                        //  System.out.println(words);
                        //     onGetTheWord(words);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(PracticeExerciseMvpDaggerRxAddWord.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        compositeDisposable.add(disposable);



    }


   // public List<Word> getWordCount() {
  //  public void getWordCount() {
    public int getWordCount() {

       // ArrayList<Word> words = new ArrayList<>();


                //  wordRepository.getAll();
               return wordDao.getNumberOfRows();

       // List<Word> words = wordRepository.getTheWord();

       // int countRows = wordRepository.getTheWord();

      //  System.out.println(countRows);


      //  return wordRepository.getTheWord();

    }


    public int countRows(int[] count) {

      //  return wordRepository.getNumberOfRows();


        System.out.println("count" + count[0]);

        int[]anotherCount = new int[1];

        anotherCount = count;

        System.out.println("countRows" + count[0]);

        return anotherCount[0];

       // return wordRepository.numberOfRows();
    }

  //  public int getCountRows(int countRows) {
//    public int getCountRows(List<Word> words) {
//
//       countRows = wordRepository.getNumberOfRows();
//
//
//       // TypedArrayUtils.toPri
//
//      //  countRows = (int) words.size();
//
//        return countRows;
//    }



    private void onGetTheWord(List<Word> words) {

        wordList.clear();
        wordList.addAll(words);
     //   arrayAdapter.notifyDataSetChanged();
    }
}
