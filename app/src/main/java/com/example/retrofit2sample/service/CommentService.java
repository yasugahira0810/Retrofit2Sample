package com.example.retrofit2sample.service;

import com.example.retrofit2sample.model.Comment;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CommentService {
    @Headers({
            "Authorization: Bearer 819efde23ffc52dea9a2706d86ffd82ed34b707a",
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("/api/v2/items/c23d0d9d01105e9f1b2e/comments")
    //Call<Comment> PostComment(@FieldMap Map<String, String> cmnt);
    Call<Comment> PostComment(@Body Comment comment);
}
