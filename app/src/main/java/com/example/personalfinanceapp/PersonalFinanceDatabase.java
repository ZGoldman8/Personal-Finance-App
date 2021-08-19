package com.example.personalfinanceapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PersonalFinanceDatabase extends SQLiteOpenHelper {

    public static final String ASSET_ALLOCATION_TABLE = "ASSET_ALLOCATION_TABLE";
    public static final String ASSETS_INVENTORY_TABLE = "ASSETS_INVENTORY_TABLE";
    public static final String ASSETS_TABLE = "ASSETS_TABLE";
    public static final String FAVORITES_TABLE = "FAVORITES_TABLE";
    public static final String NET_WORTH_TABLE = "NET_WORTH_TABLE";
    public static final String PORTFOLIO_TABLE = "PORTFOLIO_TABLE";

    public static final String COLUMN_ID = "ID";

    public static final String COLUMN_ASSET_ALLOCATION_DOMESTIC_STOCKS = "ASSET_ALLOCATION_DOMESTIC_STOCKS";
    public static final String COLUMN_ASSET_ALLOCATION_DOMESTIC_BONDS = "ASSET_ALLOCATION_DOMESTIC_BONDS";
    public static final String COLUMN_ASSET_ALLOCATION_INTERNATIONAL_STOCKS = "ASSET_ALLOCATION_INTERNATIONAL_STOCKS";
    public static final String COLUMN_ASSET_ALLOCATION_INTERNATIONAL_BONDS = "ASSET_ALLOCATION_INTERNATIONAL_BONDS";

    public static final String COLUMN_ASSETS_401k = "ASSETS_401k";
    public static final String COLUMN_ASSETS_HSA = "ASSETS_HSA";
    public static final String COLUMN_ASSETS_INVENTORY_NAME = "ASSETS_INVENTORY_NAME";
    public static final String COLUMN_ASSETS_INVENTORY_TOTAL = "ASSETS_INVENTORY_TOTAL";
    public static final String COLUMN_ASSETS_INVENTORY_VALUE = "ASSETS_INVENTORY_VALUE";
    public static final String COLUMN_ASSETS_ROTH_IRA = "ASSETS_ROTH_IRA";
    public static final String COLUMN_ASSETS_SAVINGS = "ASSETS_SAVINGS";
    public static final String COLUMN_ASSETS_CREDIT_CARD_ONE = "ASSETS_CREDIT_CARD_ONE";
    public static final String COLUMN_ASSETS_CREDIT_CARD_TWO = "ASSETS_CREDIT_CARD_TWO";
    public static final String COLUMN_ASSETS_LOANS = "ASSETS_LOANS";
    public static final String COLUMN_ASSETS_MORTGAGE = "ASSETS_MORTGAGE";

    public static final String COLUMN_FAVORITES_STOCK_SYMBOL = "FAVORITES_STOCK_SYMBOL";

    public static final String COLUMN_NET_WORTH_TOTAL = "NET_WORTH_TOTAL";
    public static final String COLUMN_NET_WORTH_YEAR = "NET_WORTH_YEAR";

    public static final String COLUMN_PORTFOLIO_DOMESTIC_BONDS_CURRENT = "PORTFOLIO_DOMESTIC_BONDS_CURRENT";
    public static final String COLUMN_PORTFOLIO_DOMESTIC_BONDS_TARGET = "PORTFOLIO_DOMESTIC_BONDS_TARGET";
    public static final String COLUMN_PORTFOLIO_DOMESTIC_STOCKS_CURRENT = "PORTFOLIO_DOMESTIC_STOCKS_CURRENT";
    public static final String COLUMN_PORTFOLIO_DOMESTIC_STOCKS_TARGET = "PORTFOLIO_DOMESTIC_STOCKS_TARGET";
    public static final String COLUMN_PORTFOLIO_INTERNATIONAL_BONDS_CURRENT = "PORTFOLIO_INTERNATIONAL_BONDS_CURRENT";
    public static final String COLUMN_PORTFOLIO_INTERNATIONAL_BONDS_TARGET = "PORTFOLIO_INTERNATIONAL_BONDS_TARGET";
    public static final String COLUMN_PORTFOLIO_INTERNATIONAL_STOCKS_CURRENT = "PORTFOLIO_INTERNATIONAL_STOCKS_CURRENT";
    public static final String COLUMN_PORTFOLIO_INTERNATIONAL_STOCKS_TARGET = "PORTFOLIO_INTERNATIONAL_STOCKS_TARGET";

    public PersonalFinanceDatabase(@Nullable Context context) {
        super(context, "finance_database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createAssetAllocationTableStatement = "CREATE TABLE " + ASSET_ALLOCATION_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ASSET_ALLOCATION_DOMESTIC_STOCKS + " INT, " +
                COLUMN_ASSET_ALLOCATION_DOMESTIC_BONDS + " INT, " +
                COLUMN_ASSET_ALLOCATION_INTERNATIONAL_STOCKS + " INT, " +
                COLUMN_ASSET_ALLOCATION_INTERNATIONAL_BONDS + " INT" +
                ")";

        String createAssetsTableStatement = "CREATE TABLE " + ASSETS_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ASSETS_401k + " INT, " +
                COLUMN_ASSETS_ROTH_IRA + " INT, " +
                COLUMN_ASSETS_HSA + " INT, " +
                COLUMN_ASSETS_SAVINGS + " INT, " +
                COLUMN_ASSETS_INVENTORY_TOTAL + " INT," +
                COLUMN_ASSETS_CREDIT_CARD_ONE + " INT, " +
                COLUMN_ASSETS_CREDIT_CARD_TWO + " INT, " +
                COLUMN_ASSETS_LOANS + " INT, " +
                COLUMN_ASSETS_MORTGAGE + "INT" +
                ")";

        String createAssetsInventoryTableStatement = "CREATE TABLE " + ASSETS_INVENTORY_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ASSETS_INVENTORY_NAME + " STRING, " +
                COLUMN_ASSETS_INVENTORY_VALUE + " INT" +
                ")";

        String createFavoritesTableStatement = "CREATE TABLE " + FAVORITES_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FAVORITES_STOCK_SYMBOL + " STRING" +
                ")";

        String createNetWorthTableStatement = "CREATE TABLE " + NET_WORTH_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NET_WORTH_YEAR + " INT, " +
                COLUMN_NET_WORTH_TOTAL + " INT" +
            ")";

        String createPortfolioTableStatement = "CREATE TABLE " + PORTFOLIO_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PORTFOLIO_DOMESTIC_BONDS_CURRENT + " INT, " +
                COLUMN_PORTFOLIO_DOMESTIC_BONDS_TARGET + " INT, " +
                COLUMN_PORTFOLIO_DOMESTIC_STOCKS_CURRENT + " INT, " +
                COLUMN_PORTFOLIO_DOMESTIC_STOCKS_TARGET + " INT, " +
                COLUMN_PORTFOLIO_INTERNATIONAL_BONDS_CURRENT + " INT," +
                COLUMN_PORTFOLIO_INTERNATIONAL_BONDS_TARGET + " INT, " +
                COLUMN_PORTFOLIO_INTERNATIONAL_STOCKS_CURRENT + " INT, " +
                COLUMN_PORTFOLIO_INTERNATIONAL_STOCKS_TARGET + " INT" +
                ")";

        db.execSQL(createAssetAllocationTableStatement);
        db.execSQL(createAssetsTableStatement);
        db.execSQL(createAssetsInventoryTableStatement);
        db.execSQL(createFavoritesTableStatement);
        db.execSQL(createNetWorthTableStatement);
        db.execSQL(createPortfolioTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ASSETS_TABLE);
        onCreate(db);
    }
}
