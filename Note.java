package org.example.Note;

import java.sql.Date;

public class Note {
    private String id;
    private String title;
    private String text;
    private String date;

    public Note(String id, String title, String text, String date) {
        this(title, text, date);
        this.id = id;
    }

    public Note(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Тема № " + id + ", причина: " + title + ", текст: " + text + ", дата: " + date + "]";
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

}