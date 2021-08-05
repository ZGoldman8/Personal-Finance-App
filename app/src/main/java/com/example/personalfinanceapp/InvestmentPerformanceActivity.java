package com.example.personalfinanceapp;

import android.os.Bundle;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("Failed to retrieve stock data");
    }

    private void handleSuccess(Object e) {
        System.out.println("Stock data retrieved successfully");

        //What I'm going to do here is parse "adjusted close" and get the value after that

        //Match open price
        Pattern p1 = Pattern.compile("open=([\\d\\.]*)");
        Matcher m1 = p1.matcher(e.toString());

        //Match date
        Pattern p2 = Pattern.compile("date=([\\d]{4}-[\\d]{2}-[\\d]{2})");
        Matcher m2 = p2.matcher(e.toString());

        if (!m1.find() || !m2.find()) {
            System.out.println("Failed to retrieve stock data");
        } else {
            System.out.println("Open Price: " + m1.group(1));
            System.out.println("Date: " + m2.group(1));
        }
    }

}
