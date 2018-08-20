package com.example.retrofit2sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.retrofit2sample.model.Article;
import com.example.retrofit2sample.model.Comment;
import com.example.retrofit2sample.model.Tag;
import com.example.retrofit2sample.service.ArticleService;
import com.example.retrofit2sample.service.CommentService;
import com.example.retrofit2sample.service.TagService;
import com.google.gson.Gson;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
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

        // 新規記事投稿
        Button bt_postArticle = (Button) findViewById(R.id.button_post_article);

        bt_postArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                //List list = gson.fromJson("[{\"name\":\"Ruby\"}]", List.class);

                Article postArticle = new Article("Example", false, false,
                        "dev", "Example title", false);

                // https://teratail.com/questions/816
                Log.d("debug0.3", ToStringBuilder.reflectionToString(postArticle, ToStringStyle.DEFAULT_STYLE));

                ArticleService service = retrofit.create(ArticleService.class);

                Call<Article> article = service.PostArticle(postArticle);

                Log.d("debug0.4", ToStringBuilder.reflectionToString(service, ToStringStyle.DEFAULT_STYLE));
                Log.d("debug0.5", ToStringBuilder.reflectionToString(article, ToStringStyle.DEFAULT_STYLE));

                article.enqueue(new Callback<Article>() {
                    @Override
                    public void onResponse(Call<Article> call, Response<Article> response) {
                        if (response.isSuccessful()) {

                            Log.d("debug1", ToStringBuilder.reflectionToString(response, ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug2", ToStringBuilder.reflectionToString(response.errorBody(), ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug3", String.valueOf(response.body()));
                            String responseArticle = String.valueOf(response.body());
                            Intent intent = new Intent();
                            intent.setClassName(getPackageName(), getPackageName() + ".PostArticleActivity");
                            intent.putExtra("responseArticle", responseArticle);
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
                        } else {
                            Log.d("debug113", "FATAL!!!!");
                        }
                    }

                    @Override
                    public void onFailure(Call<Article> call, Throwable t) {
                        Log.d("debug4", t.getMessage());
                    }
                });
            }
        });

        // コメント投稿
        Button bt_postComment = (Button) findViewById(R.id.button_post_comment);

        bt_postComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CommentService service = retrofit.create(CommentService.class);

//                HashMap<String, String> hashMap = new HashMap<>();
//                hashMap.put("body", "This is Test");
//                Gson gson = new Gson();
//                String json = gson.toJson(hashMap);
//                Map<String, String> hashMap = new HashMap<>();
//                hashMap.put("body", "This is test");
//                Log.d("debug0.4", String.valueOf(hashMap));

                Comment cmnt = new Comment("This is test message");
                Call<Comment> comment = service.PostComment(cmnt);

                Log.d("debug0.4", ToStringBuilder.reflectionToString(service, ToStringStyle.DEFAULT_STYLE));
                Log.d("debug0.5", ToStringBuilder.reflectionToString(comment, ToStringStyle.DEFAULT_STYLE));

                comment.enqueue(new Callback<Comment>() {
                    @Override
                    public void onResponse(Call<Comment> call, Response<Comment> response) {
                        if(response.isSuccessful()) {

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

                        } else {
                            Log.d("debug113", "FATAL!!!!");
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
}