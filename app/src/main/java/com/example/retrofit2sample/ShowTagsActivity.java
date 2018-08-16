package com.example.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowTagsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tags);

        Intent intent = getIntent();
        ArrayList<String> followTags = intent.getStringArrayListExtra("followTags");

        String followTagString = String.valueOf(followTags);

        TextView response = (TextView)findViewById(R.id.textView);
        response.setText(followTagString);
    }
}
