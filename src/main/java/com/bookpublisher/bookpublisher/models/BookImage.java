package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;

@Entity
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_image_id")
    private long imageId;
    private String imageTitle;
    private String previewImageTitle;

    public BookImage() {
    }

    public BookImage(String imageTitle, String previewImageTitle) {
        this.imageTitle = imageTitle;
        this.previewImageTitle = previewImageTitle;
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

    public String getPreviewImageTitle() {
        return previewImageTitle;
    }

    public void setPreviewImageTitle(String previewImageTitle) {
        this.previewImageTitle = previewImageTitle;
    }

    @Override
    public String toString() {
        return "BookImage{" +
                "imageId=" + imageId +
                ", imageTitle='" + imageTitle + '\'' +
                ", previewImageTitle='" + previewImageTitle + '\'' +
                '}';
    }
}
