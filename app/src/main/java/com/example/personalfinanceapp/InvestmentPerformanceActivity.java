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
        Pattern p1 = Pattern.compile("open=([\\d\\.]*), high=([\\d\\.]*), low=([\\d\\.])*, close=([\\d\\.])*, adjustedClose=([\\d\\.])*, volume=([\\d]*), dividendAmount=([\\d\\.]*), splitCoefficient=([\\d\\.]*), " +
                        "date=([\\d]{4}-[\\d]{2}-[\\d]{2})");
        Matcher m1 = p1.matcher(e.toString());

        if (!m1.find()) {
            System.out.println("Failed to retrieve stock data");
        } else {
            System.out.println("Open: " + m1.group(1));
            System.out.println("High: " + m1.group(2));
            System.out.println("Low: " + m1.group(3));
            System.out.println("Close: " + m1.group(4));
            System.out.println("Adjusted Close: " + m1.group(5));
            System.out.println("Date: " + m1.group(9));
        }
    }

}
