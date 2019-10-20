package com.example.hw433.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("avatar_url")
    public String avatar_url;
}
