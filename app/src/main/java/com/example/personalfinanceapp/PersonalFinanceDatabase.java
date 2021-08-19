package com.example.personalfinanceapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PersonalFinanceDatabase extends SQLiteOpenHelper {

    public static final String FINANCE_TABLE = "FINANCE_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ASSETS_401k = "ASSETS_401k";
    public static final String COLUMN_ASSETS_ROTH_IRA = "ASSETS_ROTH_IRA";
    public static final String COLUMN_ASSETS_HSA = "ASSETS_HSA";
    public static final String COLUMN_ASSETS_SAVINGS = "ASSETS_SAVINGS";
    public static final String COLUMN_ASSETS_INVENTORY_TOTAL = "ASSETS_INVENTORY_TOTAL";

    public PersonalFinanceDatabase(@Nullable Context context) {
        super(context, "finance.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + FINANCE_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ASSETS_401k + " INT, " + COLUMN_ASSETS_ROTH_IRA + " INT, " +
                COLUMN_ASSETS_HSA + " INT, " + COLUMN_ASSETS_SAVINGS + " INT, " +
                COLUMN_ASSETS_INVENTORY_TOTAL + " INT" + ")";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + FINANCE_TABLE);
        onCreate(db);

    }
