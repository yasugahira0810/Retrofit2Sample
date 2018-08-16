package com.example.retrofit2sample.service;

import com.example.retrofit2sample.model.Tag;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TagService {
    @Headers({
            "Authorization: Bearer 819efde23ffc52dea9a2706d86ffd82ed34b707a",
            "Content-Type: application/json"
    })
    @GET("/api/v2/users/yasugahira0810/following_tags")
    Call<List<Tag>> ListTags();
}
