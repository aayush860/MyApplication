package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
    Context context;
    String data1[],data2[];
    int image[];
    public Adapter(Context ct, String names[], String description[], int images[]){
        context = ct;
        data1 = names;
        data2 = description;
        image = images;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(context);
        View view = inflator.inflate(R.layout.myrow, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);
        holder.mytext2.setText(data2[position]);
        holder.img.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView mytext1,mytext2;
        ImageView img;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.textView1);
            mytext2 = itemView.findViewById(R.id.textView2);
            img = itemView.findViewById(R.id.myimageView);
        }
    }


}

