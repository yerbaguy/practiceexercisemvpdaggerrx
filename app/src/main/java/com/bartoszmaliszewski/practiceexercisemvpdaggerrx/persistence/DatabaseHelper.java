package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

/**
 * Created by bartoszmaliszewski on 24.04.18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    public static final String TABLE_NAME = "Word";
    public static final String _id = "_id";
    public static final String engword = "engword";
    public static final String plword = "plword";
    private static final String DB_NAME = "sqlitedatabaseexample.db";
    private static final int DB_VERSION = 1;
    public Context context;
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //   String sqlWord = "CREATE TABLE WordColumns(id INTEGER PRIMARY KEY AUTOINCREMENT, engword VARCHAR(200) NOT NULL, plword VARCHA(200) NOT NULL)";
        String sqlWord = "CREATE TABLE Word(_id INTEGER PRIMARY KEY AUTOINCREMENT, engword VARCHAR(200) NOT NULL, plword VARCHA(200) NOT NULL)";
        //  String sqlRandPl = "CREATE TABLE RandPl(id INTEGER PRIMARY KEY AUTOINCREMENT, randPlWord INTEGER)";
        //  String sqlRandPl = "CREATE TABLE RandPl(id INTEGER PRIMARY KEY AUTOINCREMENT, randPlWord TEXT)";
        String sqlRandPl = "CREATE TABLE RandPl(_id INTEGER PRIMARY KEY AUTOINCREMENT, randPlWord VARCHAR(200) NOT NULL)";
        sqLiteDatabase.execSQL(sqlWord);
        sqLiteDatabase.execSQL(sqlRandPl);


    }

    public boolean addWord(String engword, String plword) {

        engword = "kind";
        plword = "rodzaj";
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("engword", engword);
        contentValues.put("plword", plword);
        db.insert("Word", null, contentValues);
        db.close();
        return true;
    }

  //  public Observable<List<Word>> wordsAdded() {
  //      return  wordsAdded;
  //  }


  //  public Completable addWord(String engword, String plword) {

  //      SQLiteDatabase db = getWritableDatabase();

  //      ContentValues contentValues = new ContentValues();
  //      contentValues.put("engword", engword);
  //      contentValues.put("plword", plword);
  //      db.insert("Word". null, contentValues);
  //      db.close();

  //      return Completable.
  //  }

    public int countRows() {
        SQLiteDatabase db = this.getWritableDatabase();
        //  String countQuery = "SELECT COUNT(*) FROM WordColumns";
        // Cursor cursor = db.rawQuery(countQuery, null);
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM Word", null);
        cursor.moveToFirst();
        // int cnt = cursor.getCount();
        //      int count = cursor.getInt(0);
        int count = cursor.getInt(0);
        cursor.close();
        // return cnt;
        return count;
        //     return result;
    }
    public int countRandom() {
        //Random random = new Random();
        int countrows = this.countRows() + 1;
        int min = 1;
        int max = countrows;
        Random random = new Random();
        // int n = random.nextInt(countrows) + 1;
        int n1 = random.nextInt(max - min + 1) + min;
        deleteFromRandPl();
        insertCountRandomIntoRandPl(n1);
        // deleteFromRandPl();
        //updateCountRandomIntoRandPl(n1);
        return n1;
    }
    //public void insertCountRandomIntoRandPl(int n) {
    public boolean insertCountRandomIntoRandPl(int n) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("randPlWord", n);
        long result = db.insert("RandPl", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
        // SQLiteDatabase db = db.openOrCreateDatabase();
        // db.execSQL("CREATE TABLE IF NOT EXISTS RandPl(id INTEGER PRIMARY KEY AUTOINCREMENT,randPlWord INTEGER)");
        // String insertcountrandomintorandpl = "INSERT INTO RandPl(id,randPlWord) VALUES (1," + n + ")";
        // db.execSQL(insertcountrandomintorandpl);
        // db.close();
        //return true;
    }
    public void deleteFromRandPl() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from RandPl");
        db.execSQL("UPDATE sqlite_sequence SET seq = 0");
    }
    //public void updateCountRandomIntoRandPl(int n1) {
    public int updateCountRandomIntoRandPl(int n1) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            // cv.put("randPlWord", "4");
            cv.put("randPlWord", n1);
            // return db.update("RandPl", cv, "id =" + n1, null);
            // return db.update("RandPl", cv, "id = ?", new String[]{"1"});
        } catch (Exception e) {
            //  Log.e("updateCount", "Error");
            e.getMessage();
            e.printStackTrace();
        }
        return db.update("RandPl", cv, "id = ?", new String[]{"1"});
        // db.update("RandPl", cv, "randPlWord = " + n1, null) ;
        //       db.update("RandPl", cv, "id = ?", new String[] { "1"});
        //      String update = "UPDATE RandPl SET randPlWord = 4 WHERE id = 1";
        //      db.execSQL(update);
        //  String updateQuery = "UPDATE RandPl SET randPlWord = " + n1 ;
        //  Cursor cursor = db.rawQuery(updateQuery, null);
        //Cursor cursor = db.rawQuery("update RandPL set randPlWord = " + n1 + ",where id = 1", null);
        //  cursor.moveToFirst();
        //  cursor.close();
        //  db.execSQL("UPDATE RandPl SET randPlWord = " + n1 + " WHERE id = 1");
        // String updatecountrandomintorandpl = "UPDATE RandPl SET randPlWord = " + n + " WHERE id = 1";
//        String updatecountrandomintorandpl = "UPDATE RandPl SET randPlWord = " + n1 + " WHERE id = 1";
        //String updatecountrandomintorandpl = "UPDATE RandPl SET randPlWord = 4 WHERE id = 1";
//        db.execSQL(updatecountrandomintorandpl);
        //  db.close();
    }
    public void anotherUpdate() {
        SQLiteDatabase db = getWritableDatabase();
        String updateString = "UPDATE RandPl SET randPlWord = 4 WHERE id = 1";
        db.execSQL(updateString);
    }
    public int getIdOfPlWord() {
        SQLiteDatabase db = getWritableDatabase();
        int randplword = 1;
        //  Cursor cursor = db.rawQuery("SELECT randPlWord FROM RandPl WHERE id = 1", null);
        Cursor cursor = db.rawQuery("SELECT randPlWord FROM RandPl WHERE _id = 1", null);
        if (cursor.moveToFirst()) {
            randplword = cursor.getInt(cursor.getColumnIndex("randPlWord"));
        }
        return randplword;
    }
    public String findEngWord() {
        SQLiteDatabase db = getReadableDatabase();
        int idofengword = 1;
        String engword = "";
        idofengword = this.getIdOfPlWord();
        //  Cursor cursor = db.rawQuery("SELECT id, engword FROM WordColumns WHERE id = " + idofengword, null);
        Cursor cursor = db.rawQuery("SELECT _id, engword FROM Word WHERE _id = " + idofengword, null);
        if (cursor.moveToFirst()) {
            engword = cursor.getString(cursor.getColumnIndex("engword"));
        }
        return engword;
    }
    public int findIdOfEngWord(String engword) {
        SQLiteDatabase db = getReadableDatabase();
        int idofengword = 1;
        int idofplword = 1;
        System.out.println(engword);
        idofplword = this.getIdOfPlWord();
        //  Cursor cursor = db.rawQuery("SELECT id, engword FROM WordColumns WHERE engword = '" + engword +"'", null);
        Cursor cursor = db.rawQuery("SELECT _id, engword FROM Word WHERE engword = '" + engword +"'", null);
        if (cursor.moveToFirst()) {
            //  idofengword = cursor.getInt(cursor.getColumnIndex("id"));
            idofengword = cursor.getInt(cursor.getColumnIndex("_id"));
            // idofengword = cursor.getInt(1);
        }
        System.out.println(idofengword);
        //   if (idofengword == idofplword) {
        //  System.out.println("OK");
        // Toast.makeText(getAppl, result, Toast.LENGTH_LONG).show();
        // Toast.makeText(context, "OK", Toast.LENGTH_LONG).show();
        //   } else {
        //   System.out.println("NO");
        //   Toast.makeText(context, "NO", Toast.LENGTH_LONG).show();
        //   }
        //  compareEngAndPlWord();
        return idofengword;
    }
    public boolean compareEngAndPlWord() {
        String engword = "";
        int idofengword = 1;
        int idofplword = 1;
        // idofengword = findIdOfEngWord(engword);
        // idofplword = getIdOfPlWord();
        // if (idofengword == idofplword) {
        if (findIdOfEngWord(engword) == getIdOfPlWord()) {
            //  System.out.println("OK");
            return true;
        } else {
            //  System.out.println("NO");
            return false;
        }
    }
    public int getInfoFromRandPl() {
        int ile = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM RandPl", null);
        if (cursor.moveToFirst()) {
            ile = cursor.getInt(1);
        }
        cursor.close();
        db.close();
        return ile;
    }
    public Cursor fetch () {
        Cursor cursor = database.rawQuery("SELECT engword, plword FROM Word", null);
        if (cursor != null ){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public String getPLWord() {
        SQLiteDatabase db = getReadableDatabase();
        int randplword = 1;
        // int randplword;
        int getinfofromrandpl;
        randplword = this.getIdOfPlWord();
        // getinfofromrandpl = this.getInfoFromRandPl();
        //  Integer[] randplword = new Integer[]{1};
        String plwordd = "";
        //  String getplword = "SELECT plword FROM WordColumns WHERE id = '" + randplword + "'";
        //Cursor cursor = db.rawQuery("getplword", null);
        // Cursor cursor = db.rawQuery("SELECT plword FROM WordColumns WHERE id = '" + randplword + "'", null);
        // Cursor cursor = db.rawQuery("SELECT plword FROM WordColumns WHERE id = 1", null); // ok
        //Cursor cursor = db.rawQuery("SELECT plword FROM WordColumns WHERE id =  " + randplword , null );
        Cursor cursor = db.rawQuery("SELECT plword FROM Word WHERE _id =  " + randplword , null );
        if (cursor.moveToFirst()) {
            plwordd = cursor.getString(cursor.getColumnIndex("plword"));
        }
        // String word = "lkajsdf";
        cursor.close();
        //db.close();
        return plwordd;
    }
    //   public List<Word> getAllWords() {
    //       String[] columns = {
    //               WordEntry._ID,
    //               WordEntry.COLUMN_Word_ENGWORD,
    //               WordEntry.COLUMN_Word_PLWORD
    //       };
    //       String sortOrder = WordEntry.COLUMN_Word_ENGWORD + "ASC";
    //       List<Word> wordList = new ArrayList<Word>();
    //       SQLiteDatabase db = this.getReadableDatabase();
    //       Cursor cursor = db.query(WordEntry.TABLE_NAME,
    //               columns,
    //               null,
    //               null,
    //               null,
    //               null,
    //               sortOrder);
    //       if (cursor.moveToFirst()) {
    //           do {
    //               Word word = new Word();
    //               word.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(WordEntry._ID))));
    //               word.setEngWord(cursor.getString(cursor.getColumnIndex(WordEntry.COLUMN_Word_ENGWORD)));
    //               word.setPlWord(cursor.getString(cursor.getColumnIndex(WordEntry.COLUMN_Word_PLWORD)));
    //               wordList.add(word);
    //           } while (cursor.moveToNext());
    //       }
    //       cursor.close();
    //       db.close();
    //       return wordList;
    //   }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sqlWord = "DROP TABLE IF EXISTS Word";
        String sqlRandPl = "DROP TABLE IF EXISTS RandPl";
        sqLiteDatabase.execSQL(sqlWord);
        sqLiteDatabase.execSQL(sqlRandPl);
        onCreate(sqLiteDatabase);

    }
}
