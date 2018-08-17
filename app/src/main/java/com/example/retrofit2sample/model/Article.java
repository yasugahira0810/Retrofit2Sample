package com.example.retrofit2sample.model;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Article {
    String body;
    Boolean coediting;
    Boolean gist;
    String group_url_name;
    String tags;
    String title;
    Boolean tweet;

    public Article(String body, Boolean coediting, Boolean gist, String group_url_name,
                   String title, Boolean tweet) {

        Gson gson = new Gson();

        this.body = body;
        this.coediting = coediting;
        this.gist = gist;
        this.group_url_name = group_url_name;
        TagName tagName1 = new TagName("Ruby");
        List<TagName> tagNameList = new ArrayList<>();
        tagNameList.add(tagName1);
        this.tags = gson.toJson(tagNameList);
        Log.d("debug0.1", String.valueOf(tagNameList));
        Log.d("debug0.2", this.tags);
        this.title = title;
        this.tweet = tweet;
    }
}
