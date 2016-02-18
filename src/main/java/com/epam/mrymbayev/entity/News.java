package com.epam.mrymbayev.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NEWS", catalog = "MEIR")
public class News implements Serializable {
    private static final long serialVersionUID = 7885426911990676321L;

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

    public String getDate() {
        return String.format("%tm/%td/%tY", dateOfCreation, dateOfCreation, dateOfCreation);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (!title.equals(news.title)) return false;
        if (!brief.equals(news.brief)) return false;
        if (!dateOfCreation.equals(news.dateOfCreation)) return false;
        return content.equals(news.content);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + brief.hashCode();
        result = 31 * result + dateOfCreation.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", content='" + content + '\'' +
                '}';
    }
}
