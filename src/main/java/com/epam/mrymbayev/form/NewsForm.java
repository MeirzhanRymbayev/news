package com.epam.mrymbayev.form;


import org.apache.struts.validator.ValidatorForm;

public class NewsForm extends ValidatorForm {

    private String title;
    private String dateOfCreation;
    private String brief;
    private String content;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsForm newsForm = (NewsForm) o;

        if (title != null ? !title.equals(newsForm.title) : newsForm.title != null) return false;
        if (dateOfCreation != null ? !dateOfCreation.equals(newsForm.dateOfCreation) : newsForm.dateOfCreation != null)
            return false;
        if (brief != null ? !brief.equals(newsForm.brief) : newsForm.brief != null) return false;
        return content != null ? content.equals(newsForm.content) : newsForm.content == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (dateOfCreation != null ? dateOfCreation.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewsForm{" +
                "title='" + title + '\'' +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
