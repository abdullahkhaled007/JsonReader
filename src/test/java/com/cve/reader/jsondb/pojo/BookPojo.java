package com.cve.reader.jsondb.pojo;

import java.util.Date;

public class BookPojo {
    private String title;
//    private Boolean inPrint;
    private Date publishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Boolean getInPrint() {
//        return inPrint;
//    }
//
//    public void setInPrint(Boolean inPrint) {
//        this.inPrint = inPrint;
//    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
