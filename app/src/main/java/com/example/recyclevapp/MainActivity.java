package com.example.recyclevapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class   MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataSet;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = new ArrayList<DataModel>();
        recyclerView =  findViewById(R.id.resView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for ( int i =0 ; i < myData.nameArray.length ; i++){
            dataSet.add(new DataModel(
                    myData.nameArray[i],
                    myData.versionArray[i],
                    myData.drawableArray[i],
                    myData.id_[i]
            ));
        }

        adapter = new CustomeAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        EditText searchEditText = findViewById(R.id.searchtext);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString()); // סינון לפי הטקסט שהוקלד
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}










