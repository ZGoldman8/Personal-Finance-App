package com.example.personalfinanceapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AssetsInventoryActivity extends AppCompatActivity {
    int numberOfAssetsInList = 1;
    FloatingActionButton addAssetsInventoryItem;
    FloatingActionButton removeAssetsInventoryItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag1_assets_inventory_layout);
        addAssetsInventoryItem = (FloatingActionButton) findViewById(R.id.addAssetsInventoryItemButton);
        removeAssetsInventoryItem = (FloatingActionButton) findViewById(R.id.removeAssetsInventoryItemButton);
        removeAssetsInventoryItem.setVisibility(View.GONE);

        addAssetsInventoryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAssetsInventoryItem();
                showRemoveButton();
            }
        });
    };

    public void showRemoveButton() {
        if (numberOfAssetsInList > 1) {
            removeAssetsInventoryItem.setVisibility(View.VISIBLE);
        } else {
            removeAssetsInventoryItem.setVisibility(View.GONE);
        }
    }

    public void addAssetsInventoryItem() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutAssetsInventoryList);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText et1 = new EditText(this);
        EditText et2 = new EditText(this);
        et1.setLayoutParams(p);
        et2.setLayoutParams(p);
        et1.setHint("Asset Name");
        et2.setHint("Asset Price");
        et1.setId(numberOfAssetsInList + 1);
        et2.setId(numberOfAssetsInList + 1);
        ll.addView(et1);
        ll.addView(et2);
        numberOfAssetsInList++;
    }

    //TODO: Add deleteAssetsInventoryItem

    /*public void deleteAssetsInventoryItem() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutAssetsInventoryList);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText et1 = et1.getId();
        EditText et2 = new EditText(this);
        ll.addView(et1);
        ll.addView(et2);
        numberOfAssetsInList++;
    }*/
}