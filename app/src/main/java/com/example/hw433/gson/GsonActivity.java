package com.example.hw433.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hw433.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonActivity extends AppCompatActivity {

    private Button bSummonLog;
    private User user;
    private Gson gson;
    private String json;

    private static final String TAG = "GsonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

//        String json = "{\"time_of_year\": \"summer\",\n" +
//                " \"year\": 2019}";

//        Gson gson = new GsonBuilder().create();
//        User user = gson.fromJson(json, User.class);


        bSummonLog = findViewById(R.id.button);

        bSummonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                json = "{\"time_of_year\": \"summer\",\n" +
                        " \"year\": 2019}";
                gson = new GsonBuilder().create();
                user = gson.fromJson(json, User.class);
                Log.d(TAG, "onCreate: " + user.time_of_year);
                Log.d(TAG, "onCreate: " + user.year);
            }
        });
    }
}
