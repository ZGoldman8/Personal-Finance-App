package com.example.personalfinanceapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AssetsInventoryActivity extends AppCompatActivity {
    int numberOfFieldsInList = 1;
    FloatingActionButton addAssetsInventoryItem;
    FloatingActionButton removeAssetsInventoryItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag1_assets_inventory_layout);
        addAssetsInventoryItem = (FloatingActionButton) findViewById(R.id.buttonAddAssetsInventoryItem);
        removeAssetsInventoryItem = (FloatingActionButton) findViewById(R.id.buttonRemoveAssetsInventoryItem);
        removeAssetsInventoryItem.setVisibility(View.INVISIBLE);

        addAssetsInventoryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAssetsInventoryItem();
                showOrHideRemoveButton();
            }
        });

        removeAssetsInventoryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAssetsInventoryItem();
                showOrHideRemoveButton();
            }
        });
    };

    public void showOrHideRemoveButton() {
        if (numberOfFieldsInList > 1) {
            removeAssetsInventoryItem.setVisibility(View.VISIBLE);
        } else {
            removeAssetsInventoryItem.setVisibility(View.INVISIBLE);
        }
    }

    public void addAssetsInventoryItem() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutAssetsInventoryList);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText et1 = new EditText(this);
        EditText et2 = new EditText(this);
        et1.setLayoutParams(p);
        et2.setLayoutParams(p);
        et1.setHint(R.string.asset_name);
        et2.setHint(R.string.asset_price);
        et1.setId(numberOfFieldsInList + 1);
        et2.setId(numberOfFieldsInList + 2);
        ll.addView(et1);
        ll.addView(et2);
        numberOfFieldsInList = numberOfFieldsInList + 2;
    }

    public void removeAssetsInventoryItem() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutAssetsInventoryList);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText et1 = (EditText) findViewById(numberOfFieldsInList - 1);
        EditText et2 = (EditText) findViewById(numberOfFieldsInList);
        ll.removeView(et1);
        ll.removeView(et2);
        numberOfFieldsInList = numberOfFieldsInList - 2;
    }
}