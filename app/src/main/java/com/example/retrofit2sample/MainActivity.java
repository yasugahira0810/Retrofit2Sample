package com.example.retrofit2sample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofit2sample.model.PostTag;
import com.example.retrofit2sample.model.RequestArticle;
import com.example.retrofit2sample.model.Comment;
import com.example.retrofit2sample.model.ResponseArticle;
import com.example.retrofit2sample.model.Tag;
import com.example.retrofit2sample.service.ArticleService;
import com.example.retrofit2sample.service.CommentService;
import com.example.retrofit2sample.service.TagService;
import com.google.gson.Gson;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // 画面項目定義
    ArrayList<String> followTags = new ArrayList<String>();
    ArrayList<String> followTags2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://qiita.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // フォロータグ表示処理
        Button bt_showTags = (Button) findViewById(R.id.button_show_tags);
        bt_showTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TagService service = retrofit.create(TagService.class);
                TagService service2 = retrofit.create(TagService.class);

                EditText input_id = (EditText) findViewById(R.id.input_id);
                Log.d("debug********", input_id.getText().toString());
                final Call<List<Tag>> tags = service.ListTags(input_id.getText().toString());
                final Call<List<Tag>> tags2 = service2.ListTags("yasugahira0810");

                tags.enqueue(new Callback<List<Tag>>() {
                    @Override
                    public void onResponse(Call<List<Tag>> call, Response<List<Tag>> response) {
                        followTags.clear();
                        final List<Tag> listTag = response.body();
                        int s = listTag.size();
                        for (int i = 0; i < s; i++) {
                            Log.d("debug3", listTag.get(i).getId());
                            followTags.add(listTag.get(i).getId());
                        }

                        final Intent intent = new Intent();
                        intent.setClassName(getPackageName(), getPackageName() + ".ShowTagsActivity");

                        intent.putStringArrayListExtra("followTags", followTags);

                        tags2.enqueue(new Callback<List<Tag>>() {
                            @Override
                            public void onResponse(Call<List<Tag>> call, Response<List<Tag>> response) {
                                followTags2.clear();
                                List<Tag> listTag2 = response.body();
                                int s = listTag2.size();
                                for (int i = 0; i < s; i++) {
                                    Log.d("debug44", listTag2.get(i).getId());
                                    followTags2.add(listTag2.get(i).getId());
                                }

                                intent.putStringArrayListExtra("followTags2", followTags2);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<List<Tag>> call, Throwable t) {
                                Log.d("debug444", t.getMessage());
                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<List<Tag>> call, Throwable t) {
                        Log.d("debug4", t.getMessage());
                    }

                });

            }
        });

        // 新規記事投稿
        Button bt_postArticle = (Button) findViewById(R.id.button_post_article);
        bt_postArticle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(getPackageName(), getPackageName() + ".PostArticleActivity");
                startActivity(intent);
            }

        });

        // 新規コメント投稿
        Button bt_postComment = (Button) findViewById(R.id.button_post_comment);
        bt_postComment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CommentService service = retrofit.create(CommentService.class);

                Comment cmnt = new Comment("This is test message");
                Call<Comment> comment = service.PostComment(cmnt);

                Log.d("debug0.4", ToStringBuilder.reflectionToString(service, ToStringStyle.DEFAULT_STYLE));
                Log.d("debug0.5", ToStringBuilder.reflectionToString(comment, ToStringStyle.DEFAULT_STYLE));

                comment.enqueue(new Callback<Comment>() {
                    @Override
                    public void onResponse(Call<Comment> call, Response<Comment> response) {
                        if (response.isSuccessful()) {

                            Log.d("debug1", ToStringBuilder.reflectionToString(response, ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug2", ToStringBuilder.reflectionToString(response.errorBody(), ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug3", String.valueOf(response.body()));
                            Comment responseComment = response.body();
                            Intent intent = new Intent();
                            intent.setClassName(getPackageName(), getPackageName() + ".PostCommentActivity");
                            intent.putExtra("responseComment", ToStringBuilder.reflectionToString(responseComment, ToStringStyle.DEFAULT_STYLE));
                            startActivity(intent);
                        } else if (response.code() == 400) {
                            try {
                                Log.d("debug110", response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Log.d("debug111", ToStringBuilder.reflectionToString(response, ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug112", ToStringBuilder.reflectionToString(response.errorBody(), ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug113", String.valueOf(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Comment> call, Throwable t) {
                        Log.d("debug4", t.getMessage());
                    }
                });
            }
        });

    }

    // ID保存
    @Override
    protected void onPause() {

        EditText input_id = (EditText) findViewById(R.id.input_id);
        SharedPreferences pref = getSharedPreferences("user_id", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        editor.putString("id", input_id.getText().toString());
        editor.commit();

        super.onPause();
    }

    // ID復元
    @Override
    protected void onResume() {
        super.onResume();

        EditText input_id = (EditText) findViewById(R.id.input_id);
        SharedPreferences pref = getSharedPreferences("user_id", Context.MODE_PRIVATE);
        input_id.setText(pref.getString("id", ""));
    }


}