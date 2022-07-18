package com.example.programmingquotes;

import com.google.gson.annotations.SerializedName;

public class ProgrammingQuotes {

    @SerializedName("author")
    private String author;

    @SerializedName("en")
    private String en;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
