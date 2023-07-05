package com.example.cardiac_recoder_36_39;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.cardiac_recoder_36_39.Adaptor.CustomAdapter;
import com.example.cardiac_recoder_36_39.model.CardiacModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    public static CustomAdapter customAdapter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        readData();

        recyclerView = findViewById(R.id.recycleview);
        add_button = findViewById(R.id.add_button);
        customAdapter = new CustomAdapter(ListActivity.this,DataList.array);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
        add_button.setOnClickListener(view -> {
            Intent intent  = new Intent(ListActivity.this, AddActivity.class);
            startActivity(intent);
        });

        customAdapter.setCustomClickListener(new CustomAdapter.CustomClickListener() {
            @Override
            public void customOnClick(int position, View v) {
                Intent i = new Intent(ListActivity.this,ViewActivity.class);
                i.putExtra("index",position);
                startActivity(i);
            }

            @Override
            public void customOnLongClick(int position, View v) {

            }

            /**
             * Delete button to delete data
             * from main page list.
             * @param position
             */

            @Override
            public void onDeleteClick(int position) {
                // dataArrayList.remove(position);
                if(position != RecyclerView.NO_POSITION)
                {
                    // DataList.array.remove(position);
                    new DataList().deleteRecord(position);
                    writeData();
                    customAdapter.notifyItemRemoved(position);
                }

            }
        });
    }

    private void writeData() {
        sharedPreferences = getSharedPreferences("Habib",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        String jsonString = gson.toJson(DataList.array);
        editor.putString("Ehsan",jsonString);
        editor.apply();
    }

    private void readData() {
        sharedPreferences = getSharedPreferences("Habib",MODE_PRIVATE);
        gson = new Gson();
        String jsonString = sharedPreferences.getString("Ehsan",null);
        Type type = new TypeToken<ArrayList<CardiacModel>>(){}.getType();
        DataList.array = gson.fromJson(jsonString,type);
        if(DataList.array ==null)
        {
            DataList.array = new ArrayList<>();
        }
    }
}