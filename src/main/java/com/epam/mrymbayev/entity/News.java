package com.epam.mrymbayev.entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private long id;
    private String title;
    private String brief;
    private Date dateOfCreation;
    private boolean isChecked;
    private String content;

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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDate () {
        return String.format("%tm/%td/%tY", dateOfCreation, dateOfCreation, dateOfCreation);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public boolean isPersisted(){
        return id !=0L;
    }

    public boolean isNotPersisted(){
        return id == 0L;
    }


}
