package com.example.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ShowTagsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tags);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        TextView response = (TextView)findViewById(R.id.textView);
        response.setText(message);
    }
}
