package com.example.retrofit2sample.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestArticle {

    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("coediting")
    @Expose
    private Boolean coediting;
    @SerializedName("gist")
    @Expose
    private Boolean gist;
    @SerializedName("group_url_name")
    @Expose
    private String groupUrlName;
    @SerializedName("private")
    @Expose
    private Boolean _private;
    @SerializedName("tags")
    @Expose
    private List<PostTag> tags = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("tweet")
    @Expose
    private Boolean tweet;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getCoediting() {
        return coediting;
    }

    public void setCoediting(Boolean coediting) {
        this.coediting = coediting;
    }

    public Boolean getGist() {
        return gist;
    }

    public void setGist(Boolean gist) {
        this.gist = gist;
    }

    public String getGroupUrlName() {
        return groupUrlName;
    }

    public void setGroupUrlName(String groupUrlName) {
        this.groupUrlName = groupUrlName;
    }

    public Boolean getPrivate() {
        return _private;
    }

    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    public List<PostTag> getTags() {
        return tags;
    }

    public void setTags(List<PostTag> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getTweet() {
        return tweet;
    }

    public void setTweet(Boolean tweet) {
        this.tweet = tweet;
    }

    public RequestArticle(String body, Boolean coediting, Boolean gist, String groupUrlName, Boolean _private, List<PostTag> tags, String title, Boolean tweet) {
        this.body = body;
        this.coediting = coediting;
        this.gist = gist;
        this.groupUrlName = groupUrlName;
        this._private = _private;
        this.tags = tags;
        this.title = title;
        this.tweet = tweet;
    }
}