package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String names[],description[];
    int images[]={R.drawable.cat, R.drawable.dog, R.drawable.dolphin, R.drawable.hippo, R.drawable.horse, R.drawable.mermaid, R.drawable.panda, R.drawable.penguin, R.drawable.tiger, R.drawable.unicorn};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        names = getResources().getStringArray(R.array.animals);
        description = getResources().getStringArray(R.array.description);

        Adapter adp = new Adapter(this, names, description, images);
        recyclerView.setAdapter(adp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}