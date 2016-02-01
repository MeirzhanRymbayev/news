package com.epam.mrymbayev.entity;

import java.util.Date;

public class News {
    private long id;
    private String title;
//    private String brief;
//    private Date date;
    private boolean isChecked;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getBrief() {
//        return brief;
//    }
//
//    public void setBrief(String brief) {
//        this.brief = brief;
//    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
