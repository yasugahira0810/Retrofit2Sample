package com.example.retrofit2sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("facebook_id")
    @Expose
    private String facebookId;
    @SerializedName("followees_count")
    @Expose
    private Integer followeesCount;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("github_login_name")
    @Expose
    private Object githubLoginName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("items_count")
    @Expose
    private Integer itemsCount;
    @SerializedName("linkedin_id")
    @Expose
    private String linkedinId;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("permanent_id")
    @Expose
    private Integer permanentId;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("twitter_screen_name")
    @Expose
    private String twitterScreenName;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public Integer getFolloweesCount() {
        return followeesCount;
    }

    public void setFolloweesCount(Integer followeesCount) {
        this.followeesCount = followeesCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Object getGithubLoginName() {
        return githubLoginName;
    }

    public void setGithubLoginName(Object githubLoginName) {
        this.githubLoginName = githubLoginName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getLinkedinId() {
        return linkedinId;
    }

    public void setLinkedinId(String linkedinId) {
        this.linkedinId = linkedinId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getPermanentId() {
        return permanentId;
    }

    public void setPermanentId(Integer permanentId) {
        this.permanentId = permanentId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

}