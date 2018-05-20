package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;

@Entity
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private long imageId;
    private String imageTitle;

    public BookImage() {
    }

    public BookImage(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    @Override
    public String toString() {
        return "BookImage{" +
                "imageId=" + imageId +
                ", imageTitle='" + imageTitle + '\'' +
                '}';
    }
}
