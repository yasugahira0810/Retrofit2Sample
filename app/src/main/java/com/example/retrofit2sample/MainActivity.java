package com.example.retrofit2sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_showTags = (Button)findViewById(R.id.button_show_tags);

        bt_showTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(getPackageName(), getPackageName() + ".ShowTagsActivity");
                startActivity(intent);
            }
        });

        Button bt_postArticle = (Button)findViewById(R.id.button_post_article);

        bt_postArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(getPackageName(), getPackageName() + ".PostArticleActivity");
                startActivity(intent);
            }
        });

    }
}
