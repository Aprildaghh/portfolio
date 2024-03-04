package com.abdullah.portfolio.Model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="presentation")
public class PresentationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="presentation_date")
    private Date date;

    @Column(name="password")
    private String password;

    @Column(name="video_url")
    private String videoUrl;

    @Column(name="background_color")
    private String backgroundColor;

    @Column(name="background_url")
    private String backgroundUrl;

    public PresentationEntity() {
    }

    public PresentationEntity(int id, Date date, String password) {
        this.id = id;
        this.date = date;
        this.password = password;
    }

    public PresentationEntity(int id, Date date, String password, String videoUrl, String backgroundColor, String backgroundUrl) {
        this.id = id;
        this.date = date;
        this.password = password;
        this.videoUrl = videoUrl;
        this.backgroundColor = backgroundColor;
        this.backgroundUrl = backgroundUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
}
