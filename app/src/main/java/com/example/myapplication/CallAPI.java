package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class CallAPI extends AsyncTask<String, String, String> {

    String timeString;
    String impressionString;

    public CallAPI(String time, String impression){
        timeString = time;
        impressionString = impression;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("time", timeString) // A sample POST field
                .add("impression", impressionString) // Another sample POST field
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.10.12:8000/upload/") // The URL to send the data to
                .post(formBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}