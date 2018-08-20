package com.example.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PostCommentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_comment);

        Intent intent = getIntent();
        String responseComment = intent.getStringExtra("responseComment");

        TextView response = (TextView)findViewById(R.id.textView3);
        response.setText(responseComment);
    }
}
