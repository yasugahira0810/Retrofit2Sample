package com.example.retrofit2sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PostTag implements Serializable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("versions")
    @Expose
    private List<String> versions = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getVersions() {
        return versions;
    }

    public void setVersions(List<String> versions) {
        this.versions = versions;
    }

    public PostTag(String name, List<String> versions) {
        this.name = name;
        this.versions = versions;
    }

}