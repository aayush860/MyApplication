package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;


public class MainActivity extends AppCompatActivity {

    //Initilizing Variables
    RecyclerView recyclerView;
    int i=0;
    String names[],description[];
    Long timestampp;
    int images[] = {R.drawable.cat, R.drawable.dog, R.drawable.dolphin, R.drawable.hippo, R.drawable.horse, R.drawable.mermaid, R.drawable.panda, R.drawable.penguin, R.drawable.tiger, R.drawable.unicorn};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        names = getResources().getStringArray(R.array.animals);
        description = getResources().getStringArray(R.array.description);
        timestampp = System.currentTimeMillis()/1000;


        //-----------------------Setting Adapter, linking elements to adapter
        Adapter adp = new Adapter(this, names, description, images);
        recyclerView.setAdapter(adp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final LinearLayoutManager layoutManager = ((LinearLayoutManager)recyclerView.getLayoutManager());



        //------------------------On scroll listner, push data to server while scrolling
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    Long current = System.currentTimeMillis()/1000;                                  //Current Timestamp

                    if ((current-timestampp)>2) {
                        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();        //ID of first visible element
                        int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();          //ID of last visible element
                        String impression = "";

                        //----------------List of elements in Current View
                        for (int i = firstVisiblePosition; i < lastVisiblePosition; i++) {
                            impression += names[i] + ',';
                        }
                        ;

                        //----------------Posting Data
                        new CallAPI(String.valueOf(current - timestampp), impression.substring(0, impression.length() - 1)).execute();
                        timestampp = current;
                        Log.i("Preview","Seconds--> "+String.valueOf(current - timestampp)+"  Impressions---> "+impression);
                    }

                } else {
                    // Do something
                }
            }
        });

    }
}