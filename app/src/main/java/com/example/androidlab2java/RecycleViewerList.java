package com.example.androidlab2java;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RecycleViewerList extends AppCompatActivity {

    ArrayList<String> purchases = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_viewer_list);
        RecyclerView recyclerView = findViewById(R.id.Recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        TextAdapter adapter = new TextAdapter(this, purchases);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    protected void onStart() {
        super.onStart();
        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        int status = arguments.getInt("Status");
        if (status == 1) {
            purchases.clear();
//            RecyclerView recyclerView = findViewById(R.id.Recycler);
//            TextAdapter adapter = new TextAdapter(this, purchases);
//            recyclerView.setAdapter(adapter);
        }
        else {
//            Toast.makeText(getApplicationContext(), "AllWorks", Toast.LENGTH_LONG).show();
            purchases = arguments.getStringArrayList("Purchases");
        }
//        Toast.makeText(getApplicationContext(), purchases.toString(), Toast.LENGTH_LONG).show();
        RecyclerView recyclerView = findViewById(R.id.Recycler);
        TextAdapter adapter = new TextAdapter(this, purchases);
        recyclerView.setAdapter(adapter);
    }


    public void clickAddButton(View view) {
        EditText EdText = findViewById(R.id.textNameProduct);
        String purchase = EdText.getText().toString();
        if (!purchase.equals("")) {
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            TextAdapter adapter = (TextAdapter) recyclerView.getAdapter();
            //Toast.makeText(getApplicationContext(), purchase, Toast.LENGTH_LONG).show();
            adapter.setItems(purchase);
        }
    }

    public void clickBackButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Purchases", purchases);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);
    }

    public void clickDeleteButton(View view) {
        EditText EdText = findViewById(R.id.textNameProduct);
        String purchase = EdText.getText().toString();
        if (!purchase.equals("")) {
            RecyclerView recyclerView = findViewById(R.id.Recycler);
            TextAdapter adapter = (TextAdapter) recyclerView.getAdapter();
            adapter.deleteItem(purchase);
        }
    }


    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("PURCHASES", purchases);
    }

}