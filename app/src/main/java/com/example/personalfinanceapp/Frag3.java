package com.example.personalfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment {
    Button assetsInventory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag3_layout, container, false);
        assetsInventory = view.findViewById(R.id.assetsInventoryButton);

        assetsInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAssetsInventory();
            }
        });
        return view;
    }

    public void openAssetsInventory() {
        Intent intent = new Intent(getActivity(), AssetsInventoryActivity.class);
        startActivity(intent);
    }
}
