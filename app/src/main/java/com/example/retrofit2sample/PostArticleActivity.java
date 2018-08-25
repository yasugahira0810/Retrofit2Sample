package com.example.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofit2sample.model.ResponseArticle;

import java.util.ArrayList;

public class PostArticleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_article);

        Intent intent = getIntent();
        ResponseArticle responseArticle = (ResponseArticle)intent.getSerializableExtra("responseArticle");

        if ( responseArticle == null) {
            Log.d("DEBUGGGGGGG", "damedaaaa");
        } else {
            Log.d("DEBUGGGGGGG", responseArticle.getUrl());
            TextView response = (TextView) findViewById(R.id.textView2);
            response.setText(responseArticle.getTitle());
        }
    }
}
