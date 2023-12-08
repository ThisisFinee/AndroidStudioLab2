package com.example.androidlab2java;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> purchases = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle arguments = getIntent().getExtras();
        if (arguments!=null){
            purchases = arguments.getStringArrayList("Purchases");
        }

    }


    public void clickEditButton(View view) {
        //EditText EdText =findViewById(R.id.nameFileText);
        //String FileName =EdText.getText().toString();
        Intent intent = new Intent(this, RecycleViewerList.class);
        intent.putExtra("Status", 0);
        intent.putExtra("Purchases", purchases);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);

    }


    public void clickCreateButton(View view) {
        //EditText EdText = findViewById(R.id.nameFileText);
        //String FileName = EdText.getText().toString();
        Intent intent = new Intent(this, RecycleViewerList.class);
        intent.putExtra("Status", 1);
        purchases.clear();
        intent.putExtra("Purchases", purchases);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);
    }
}