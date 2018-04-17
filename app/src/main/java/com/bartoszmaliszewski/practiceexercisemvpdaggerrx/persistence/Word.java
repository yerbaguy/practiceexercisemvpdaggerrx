package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by bartoszmaliszewski on 09.04.18.
 */

@Entity(tableName = "Word")
public class Word {

   // @PrimaryKey(autoGenerate = true)
    @NonNull
    @PrimaryKey
    @ColumnInfo (name = "wordid")
    private int uid;

    @ColumnInfo(name = "engword")
    private String engword;

    @ColumnInfo(name = "plword")
    private String plword;






    public Word(int uid, String engword, String plword) {

        this.uid = uid;
        this.engword = engword;
        this.plword = plword;

    }


    public int getUid() {

        return uid;
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
