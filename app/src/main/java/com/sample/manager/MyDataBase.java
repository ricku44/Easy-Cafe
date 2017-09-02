package com.sample.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper {


    private static String database_name = "MyDB2";

    private static String table_name = "orderID";
    private static String col1 = "pkey";
    private static String col2 = "course";
    static String col3 = "tableno";
    private static String col4 = "time";

    private static String col5 = "starter1";
    private static String col6 = "starter2";
    private static String col7 = "starter3";
    private static String col8 = "starter4";
    private static String col9 = "starter5";

    private static String col10 = "main1";
    private static String col11 = "main2";
    private static String col12 = "main3";
    private static String col13 = "main4";
    private static String col14 = "main5";

    private static String col15 = "dessert1";
    private static String col16 = "dessert2";
    private static String col17 = "dessert3";
    private static String col18 = "dessert4";
    private static String col19 = "dessert5";

    private static String col20 = "vn";
    static String col21 = "total";





    private String createQuery = "create table "+table_name+ "("    +col1+ " varchar(40) PRIMARY KEY , "
                                                                    +col2+ " varchar(40), "
                                                                    +col3+ " varchar(40), "
                                                                    +col4+ " varchar(40), "
                                                                    +col20+ " varchar(40), "
                                                                    +col5+ " varchar(40), "
                                                                    +col6+ " varchar(40), "
                                                                    +col7+ " varchar(40), "
                                                                    +col8+ " varchar(40), "
                                                                    +col9+ " varchar(40), "
                                                                    +col10+ " varchar(40), "
                                                                    +col11+ " varchar(40), "
                                                                    +col12+ " varchar(40), "
                                                                    +col13+ " varchar(40), "
                                                                    +col14+ " varchar(40), "
                                                                    +col15+ " varchar(40), "
                                                                    +col16+ " varchar(40), "
                                                                    +col17+ " varchar(40), "
                                                                    +col18+ " varchar(40), "
                                                                    +col19+ " varchar(40), "
                                                                    +col21+ " INTEGER );";



    private static String table_name2 = "menuID";

    private static String coll2 = "food";
    static String coll3 = "price";



    private String createQuery1 = "create table "+table_name2+ "(" +coll2+ " varchar(40) PRIMARY KEY , " +coll3+" varchar(40));";


    private static String table_name3 = "itemID";

    private static String colll1 = "item";
    static String colll2 = "food";

    private String createQuery2 = "create table "+table_name3+ "(" +colll1+ " varchar(40) PRIMARY KEY , " +colll2+" varchar(40));";



    private static String table_name4 = "userDetails";
    static String coln2 = "name";
    private static String coln3 = "email";
    static String coln4 = "password";
    static String coln5 = "pno";
    static String coln6 = "gender";
    static String coln7 = "dob";
    static String coln8 = "city";
    private String createQuery3 = "create table "+table_name4+ "("
            +coln2+ " varchar(40), " +coln3+" varchar(40), "+coln4+" varchar(40), "+coln5+
            " varchar(40), "+coln6+" varchar(40), "+coln7+" varchar(40), "+coln8+" varchar(40), PRIMARY KEY ("+coln3+"));";




    MyDataBase(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createQuery);
        sqLiteDatabase.execSQL(createQuery1);
        sqLiteDatabase.execSQL(createQuery2);
        sqLiteDatabase.execSQL(createQuery3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name2);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name3);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name4);
        onCreate(sqLiteDatabase);
    }


    long insertData(String pkey, String course, String tableno, String time, String vn,
                        String starter1, String starter2, String starter3, String starter4, String starter5,
                            String main1, String main2, String main3, String main4, String main5,
                                String dessert1, String dessert2, String dessert3, String dessert4, String dessert5, int total) {




        ContentValues contentValues = new ContentValues();

        contentValues.put(col1,pkey);
        contentValues.put(col2,course);
        contentValues.put(col3,tableno);
        contentValues.put(col4,time);

        contentValues.put(col5,starter1);
        contentValues.put(col6,starter2);
        contentValues.put(col7,starter3);
        contentValues.put(col8,starter4);
        contentValues.put(col9,starter5);

        contentValues.put(col10,main1);
        contentValues.put(col11,main2);
        contentValues.put(col12,main3);
        contentValues.put(col13,main4);
        contentValues.put(col14,main5);

        contentValues.put(col15,dessert1);
        contentValues.put(col16,dessert2);
        contentValues.put(col17,dessert3);
        contentValues.put(col18,dessert4);
        contentValues.put(col19,dessert5);

        contentValues.put(col20,vn);
        contentValues.put(col21,total);

        return getWritableDatabase().insert(table_name,null,contentValues);

    }

    Cursor getprice(String food){

        String[] col = {coll3};
        String sel = coll2+"=?";
        String[] args = {food};
        return getWritableDatabase().query(table_name2,col,sel,args,null,null,null);
    }

    long insertData2(String food, String price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(coll2,food);
        contentValues.put(coll3,price);
        return getWritableDatabase().replace(table_name2, null, contentValues);

    }

    Cursor checkpkey(String pkey){

        String[] col = {col3};
        String sel = col1+"=?";
        String[] args = {pkey};
        return getWritableDatabase().query(table_name,col,sel,args,null,null,null);
    }

    long insertData3(String item, String food) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(colll2,food);
        contentValues.put(colll1,item);
        return getWritableDatabase().replace(table_name3, null, contentValues);

    }

    Cursor getfood(String item){

        String[] col = {colll2};
        String sel = colll1+"=?";
        String[] args = {item};
        return getWritableDatabase().query(table_name3,col,sel,args,null,null,null);
    }

    Cursor getfood2(){

        String[] col = {colll2};
        return getWritableDatabase().query(table_name3,col,null,null,null,null,null);
    }

    Cursor getsales(String course){

        String[] col = {col21};
        String sel = col2+"=?";
        String[] args = {course};
        return getWritableDatabase().query(table_name,col,sel,args,null,null,null);
    }

    long insertData5(String name, String email, String password, String pno, String gender, String dob, String city){

        ContentValues contentValues = new ContentValues();
        contentValues.put(coln2,name);
        contentValues.put(coln3,email);
        contentValues.put(coln4,password);
        contentValues.put(coln5,pno);
        contentValues.put(coln6,gender);
        contentValues.put(coln7,dob);
        contentValues.put(coln8,city);
        return getWritableDatabase().insert(table_name4,null,contentValues);
    }

    Cursor login(String email,String password){

        String[] col = {coln2,coln5,coln6,coln7,coln8};
        String sel = coln3+"=? and "+coln4+"=?";
        String[] args = {email,password};
        return getWritableDatabase().query(table_name4,col,sel,args,null,null,null);
    }

    Cursor login2(String email){

        String[] col = {coln2,coln4,coln5,coln6,coln7,coln8};
        String sel = coln3+"=?";
        String[] args = {email};
        return getWritableDatabase().query(table_name4,col,sel,args,null,null,null);
    }

    void deleteData(String email){

        String a = coln3 +"=?";
        String[] b = {email};
        getWritableDatabase().delete(table_name4,a,b);
    }

    long updateData(String name, String email, String password, String pno, String gender, String dob, String city){

        ContentValues contentValues = new ContentValues();
        contentValues.put(coln2,name);
        contentValues.put(coln3,email);
        contentValues.put(coln4,password);
        contentValues.put(coln5,pno);
        contentValues.put(coln6,gender);
        contentValues.put(coln7,dob);
        contentValues.put(coln8,city);
        String[] e = {email};
        return getWritableDatabase().update(table_name4,contentValues, coln3+" =?", e);
    }

}
