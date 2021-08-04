package com.example.personalfinanceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NetWorthCalculatorActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag1_networth_layout);
        Button buttonCalculateNetWorth = (Button) findViewById(R.id.buttonCalculateNetWorth);

        buttonCalculateNetWorth.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                calculateNetWorth();
            }
        });
    }

    public void calculateNetWorth() {
        TextView textViewCalculateNetWorth = (TextView) findViewById(R.id.textViewCalculateNetWorth);

        EditText et401k = (EditText) findViewById(R.id.editText401k);
        EditText etRothIRA = (EditText) findViewById(R.id.editTextRothIRA);
        EditText etHSA = (EditText) findViewById(R.id.editTextHSA);
        EditText etSavings = (EditText) findViewById(R.id.editTextSavings);
        EditText etAssetsInventory = (EditText) findViewById(R.id.editTextAssetsInventory);
        EditText etCreditCard1 = (EditText) findViewById(R.id.editTextCreditCard1);
        EditText etCreditCard2 = (EditText) findViewById(R.id.editTextCreditCard2);
        EditText etLoans = (EditText) findViewById(R.id.editTextLoans);
        EditText etMortgage = (EditText) findViewById(R.id.editTextMortgage);

        int et401kValue = Integer.parseInt(et401k.getText().toString());
        int etRothIRAValue = Integer.parseInt(etRothIRA.getText().toString());
        int etHSAValue = Integer.parseInt(etHSA.getText().toString());
        int etSavingsValue = Integer.parseInt(etSavings.getText().toString());
        int etAssetsInventoryValue = Integer.parseInt(etAssetsInventory.getText().toString());
        int etCreditCard1Value = Integer.parseInt(etCreditCard1.getText().toString());
        int etCreditCard2Value = Integer.parseInt(etCreditCard2.getText().toString());
        int etLoansValue = Integer.parseInt(etLoans.getText().toString());
        int etMortgageValue = Integer.parseInt(etMortgage.getText().toString());
        int netWorth = (et401kValue + etRothIRAValue + etHSAValue + etSavingsValue + etAssetsInventoryValue) - (etCreditCard1Value + etCreditCard2Value + etLoansValue + etMortgageValue);

        textViewCalculateNetWorth.setText(R.string.net_worth_calculated + netWorth);
    }
}
