package com.epam.mrymbayev.model;

import java.util.Date;

public class News {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (isChecked != news.isChecked) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (brief != null ? !brief.equals(news.brief) : news.brief != null) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(news.dateOfCreation) : news.dateOfCreation != null)
            return false;
        return content != null ? content.equals(news.content) : news.content == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (isChecked ? 1 : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", isChecked=" + isChecked +
                ", content='" + content + '\'' +
                '}';
    }
}
