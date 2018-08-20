package com.example.retrofit2sample.model;


public class Comment {
    String body;

    public Comment(String body) {
        this.body = body;
    }
}

//package com.example.retrofit2sample.model;
//
//import com.example.retrofit2sample.model.User;
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//public class Comment {
//
//    @SerializedName("body")
//    @Expose
//    private String body;
//    @SerializedName("created_at")
//    @Expose
//    private String createdAt;
//    @SerializedName("id")
//    @Expose
//    private String id;
//    @SerializedName("rendered_body")
//    @Expose
//    private String renderedBody;
//    @SerializedName("updated_at")
//    @Expose
//    private String updatedAt;
//    @SerializedName("user")
//    @Expose
//    private User user;
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getRenderedBody() {
//        return renderedBody;
//    }
//
//    public void setRenderedBody(String renderedBody) {
//        this.renderedBody = renderedBody;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//}