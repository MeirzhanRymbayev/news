package com.epam.mrymbayev.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NEWS_SEQ")
    @SequenceGenerator(name = "NEWS_SEQ", sequenceName = "news_seq")
    @Column(name = "ID", unique = true, nullable = false)
    @Type(type = "long")
    private long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "BRIEF", nullable = false)
    private String brief;

    @Column(name = "DATE_OF_CREATION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;


    private boolean isChecked;

    @Column(name = "CONTENT", nullable = false)
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
