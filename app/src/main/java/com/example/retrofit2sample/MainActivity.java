package com.example.retrofit2sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.retrofit2sample.model.Tag;
import com.example.retrofit2sample.service.TagService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> followTags = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_showTags = (Button) findViewById(R.id.button_show_tags);





        // 同期処理のexecuteではダメだった。一旦事例の多いenqueueで実装してみる
//                try {
//                    Response<List<Tag>> response = tags.execute();
//                    List<Tag> listTag = response.body();
//                        int s = listTag.size();
//                        for(int i = 0; i < s; i++){
//                            Log.d("debug3", listTag.get(i).getId());
//                        }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

        bt_showTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://qiita.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                TagService service = retrofit.create(TagService.class);

                Call<List<Tag>> tags = service.ListTags();

                tags.enqueue(new Callback<List<Tag>>() {
                    @Override
                    public void onResponse(Call<List<Tag>> call, Response<List<Tag>> response) {
                        List<Tag> listTag = response.body();
                        int s = listTag.size();
                        for (int i = 0; i < s; i++) {
                            Log.d("debug3", listTag.get(i).getId());
                            followTags.add(listTag.get(i).getId());
                        }

                        Intent intent = new Intent();
                        intent.setClassName(getPackageName(), getPackageName() + ".ShowTagsActivity");

                        intent.putStringArrayListExtra("followTags", followTags);

                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Tag>> call, Throwable t) {
                        Log.d("debug4", t.getMessage());
                    }

                });

            }
        });

        Button bt_postArticle = (Button) findViewById(R.id.button_post_article);

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
