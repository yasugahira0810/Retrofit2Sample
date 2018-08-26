package com.example.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit2sample.model.PostTag;
import com.example.retrofit2sample.model.RequestArticle;
import com.example.retrofit2sample.model.ResponseArticle;
import com.example.retrofit2sample.service.ArticleService;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

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

public class PostArticleActivity extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty
    public EditText titleValue;

    @NotEmpty
    public EditText bodyValue;

    Validator validator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_article);

        validator = new Validator(this);
        validator.setValidationListener(this);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://qiita.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 新規記事投稿
        Button bt_postArticle = (Button) findViewById(R.id.button_post_article);

        bt_postArticle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ArticleService service = retrofit.create(ArticleService.class);

                titleValue = (EditText)findViewById(R.id.title_value);
                String title = titleValue.getText().toString();

                bodyValue = (EditText)findViewById(R.id.body_value);
                String body = bodyValue.getText().toString();

                List<String> versions = Arrays.asList("0.0.1", "0.0.2");
                PostTag tagRuby = new PostTag("Ruby", versions);
                PostTag tagPython = new PostTag("Python", versions);
                List<PostTag> listTags = Arrays.asList(tagRuby, tagPython);
                RequestArticle postArticle = new RequestArticle(body, false,
                        false, "dev", true, listTags, title, false);

                Call<ResponseArticle> article = service.PostArticle(postArticle);

                Log.d("debug0.4", ToStringBuilder.reflectionToString(service, ToStringStyle.DEFAULT_STYLE));
                Log.d("debug0.5", ToStringBuilder.reflectionToString(article, ToStringStyle.DEFAULT_STYLE));

                // バリデーション開始
                validator.validate();

                article.enqueue(new Callback<ResponseArticle>() {
                    @Override
                    public void onResponse(Call<ResponseArticle> call, Response<ResponseArticle> response) {
                        if (response.isSuccessful()) {

                            Log.d("debug1", ToStringBuilder.reflectionToString(response, ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug2", ToStringBuilder.reflectionToString(response.errorBody(), ToStringStyle.DEFAULT_STYLE));
                            Log.d("debug3", String.valueOf(response.body()));
                            ResponseArticle responseArticle = response.body();
                            Intent intent = new Intent();
                            intent.setClassName(getPackageName(), getPackageName() + ".PostedArticleActivity");
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
                    public void onFailure(Call<ResponseArticle> call, Throwable t) {
                        Log.d("debug4", t.getMessage());
                    }
                });
            }

        });

        Intent intent = getIntent();
        ResponseArticle responseArticle = (ResponseArticle)intent.getSerializableExtra("responseArticle");

        if ( responseArticle == null) {
            Log.d("DEBUGGGGGGG", "damedaaaa");
        } else {
            Log.d("DEBUGGGGGGG", responseArticle.getUrl());
            TextView response = (TextView) findViewById(R.id.body_value);
            response.setText(responseArticle.getTitle());
        }
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "バリデーションを通過", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            // エラーになったViewを取得する
            View view = error.getView();
            // エラーメッセージを取得する（指定のない場合はデフォルトのメッセージ）
            //String message = error.getCollatedErrorMessage(this);
            String message = "埋めてね";

            // エラーメッセージをEditTextやInputTextViewに表示する
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
