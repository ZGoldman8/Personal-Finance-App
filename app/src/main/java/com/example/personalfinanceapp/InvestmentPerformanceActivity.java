package com.example.personalfinanceapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.AlphaVantageException;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;

import static com.example.personalfinanceapp.BuildConfig.AlphaVantageKey;

public class InvestmentPerformanceActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Config cfg = Config.builder()
                .key(AlphaVantageKey)
                .timeOut(10)
                .build();

        AlphaVantage.api().init(cfg);

        AlphaVantage.api()
                .timeSeries()
                .daily()
                .forSymbol("LGND")
                .outputSize(OutputSize.FULL)
                .onSuccess(e->handleSuccess(e))
                .onFailure(e->handleFailure(e))
                .fetch();
    }

    private void handleFailure(AlphaVantageException e) {
        Toast.makeText(this, "Failed to retrieve stock data", Toast.LENGTH_LONG).show();
    }

    private void handleSuccess(Object e) {
        Toast.makeText(this, "Stock data retrieved successfully", Toast.LENGTH_LONG).show();
        System.out.println(e);
    }

}
