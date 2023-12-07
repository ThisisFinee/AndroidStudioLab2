package com.example.androidlab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void clickEditButton(View view) {
        //EditText EdText =findViewById(R.id.nameFileText);
        //String FileName =EdText.getText().toString();
        Intent intent = new Intent(this, RecycleViewerList.class);
        intent.putExtra("Status", 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);

    }


    public void clickCreateButton(View view) {
        //EditText EdText = findViewById(R.id.nameFileText);
        //String FileName = EdText.getText().toString();
        Intent intent = new Intent(this, RecycleViewerList.class);
        intent.putExtra("Status", 1);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);
    }
}