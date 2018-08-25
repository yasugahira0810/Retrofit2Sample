package com.example.retrofit2sample.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseArticle implements Serializable {

    @SerializedName("rendered_body")
    @Expose
    private String renderedBody;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("coediting")
    @Expose
    private Boolean coediting;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("likes_count")
    @Expose
    private Integer likesCount;
    @SerializedName("private")
    @Expose
    private Boolean _private;
    @SerializedName("reactions_count")
    @Expose
    private Integer reactionsCount;
    @SerializedName("tags")
    @Expose
    private List<PostTag> tags = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("page_views_count")
    @Expose
    private Integer pageViewsCount;

    public String getRenderedBody() {
        return renderedBody;
    }

    public void setRenderedBody(String renderedBody) {
        this.renderedBody = renderedBody;
    }

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

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Boolean getPrivate() {
        return _private;
    }

    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    public Integer getReactionsCount() {
        return reactionsCount;
    }

    public void setReactionsCount(Integer reactionsCount) {
        this.reactionsCount = reactionsCount;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPageViewsCount() {
        return pageViewsCount;
    }

    public void setPageViewsCount(Integer pageViewsCount) {
        this.pageViewsCount = pageViewsCount;
    }

}