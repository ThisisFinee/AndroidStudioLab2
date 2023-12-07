package com.example.androidlab2java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class RecycleViewerList extends AppCompatActivity {

    ArrayList<String> purchases = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_viewer_list);

    }

    protected void OnStart(Bundle savedInstanceState) {
        super.onStart();
        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        int status = arguments.getInt("Status");
        if (status == 0) {
            purchases.clear();
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            TextAdapter adapter = new TextAdapter(this, purchases);
            recyclerView.setAdapter(adapter);
        }
    }


    public void clickAddButton(View view) {
        EditText EdText =findViewById(R.id.textNameProduct);
        String purchase = EdText.getText().toString();
        if (!purchase.equals("")){
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            TextAdapter adapter = (TextAdapter) recyclerView.getAdapter();
            adapter.setItems(purchase);
        }
    }

    public void clickBackButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);
    }

    public void clickDeleteButton(View view) {
        EditText EdText =findViewById(R.id.textNameProduct);
        String purchase = EdText.getText().toString();
        if (!purchase.equals("")) {
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            TextAdapter adapter = (TextAdapter) recyclerView.getAdapter();
            adapter.deleteItem(purchase);
        }
    }
}