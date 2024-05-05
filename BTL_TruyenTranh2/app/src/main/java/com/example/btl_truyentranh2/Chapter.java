package com.example.btl_truyentranh2;

public class Chapter {
    private String id;
    private String nameChapter;
    private String url;

    public Chapter() {
    }

    public Chapter(String id, String nameChapter, String url) {
        this.id = id;
        this.nameChapter = nameChapter;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameChapter() {
        return nameChapter;
    }

    public void setNameChapter(String nameChapter) {
        this.nameChapter = nameChapter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
