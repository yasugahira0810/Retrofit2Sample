package com.example.retrofit2sample.service;

import com.example.retrofit2sample.model.Article;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ArticleService {
    @Headers({
            "Authorization: Bearer 819efde23ffc52dea9a2706d86ffd82ed34b707a",
            "Content-Type: application/json"
    })
    @POST("/api/v2/items")
    Call<Article> PostArticle(@Body Article article);
}
