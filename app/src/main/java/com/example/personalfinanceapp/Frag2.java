package com.example.personalfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {
    Button viewInvestmentPerformance, rebalancePortfolio;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2_layout, container, false);
        viewInvestmentPerformance = view.findViewById(R.id.buttonViewInvestmentPerformance);
        rebalancePortfolio = view.findViewById(R.id.buttonRebalancePortfolio);

        viewInvestmentPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewInvestmentPerformance();
            }
        });

        rebalancePortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRebalancePortfolio();
            }
        });

        return view;
    }

    public void openViewInvestmentPerformance() {
        Intent intent = new Intent(getActivity(), InvestmentPerformanceActivity.class);
        startActivity(intent);
    }

    public void openRebalancePortfolio() {
        Intent intent = new Intent(getActivity(), RebalancePortfolioActivity.class);
        startActivity(intent);
    }
}