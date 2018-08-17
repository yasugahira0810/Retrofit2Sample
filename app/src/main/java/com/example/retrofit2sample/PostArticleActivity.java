package com.example.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class PostArticleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_article);

        Intent intent = getIntent();
        String responseArticle = intent.getStringExtra("responseArticle");

        TextView response = (TextView)findViewById(R.id.textView);
        response.setText(responseArticle);
    }
}
