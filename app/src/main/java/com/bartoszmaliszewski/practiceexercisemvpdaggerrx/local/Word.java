package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

@Entity(tableName = "Word")
public class Word {

    @NonNull
    @PrimaryKey(autoGenerate = true)
 //   @NonNull
 //   @PrimaryKey
    @ColumnInfo (name = "wordid")
    private int id;

    @ColumnInfo(name = "engword")
    private String engword;

    @ColumnInfo(name = "plword")
    private String plword;


    public Word() {

    }

    @Ignore
    public Word(String engword, String plword) {

       // this.id = id;
        this.engword = engword;
        this.plword = plword;

    }


  //  public Word(int uid, String engword, String plword) {

  //      this.uid = uid;
  //      this.engword = engword;
  //      this.plword = plword;

  //  }


    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    }


    public void setEngword(String engword) {

        this.engword = engword;
    }

    public String getEngword() {

        return this.engword;
    }

    public void setPlword(String plword) {

        this.plword = plword;
    }

    public String getPlword() {

        return this.plword;
    }



}
