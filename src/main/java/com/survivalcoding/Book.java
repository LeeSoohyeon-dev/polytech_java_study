package com.survivalcoding;

import java.util.*;

public class Book implements Comparable<Book>, Cloneable {
    private String title;
    private Date publishDate;
    private String comment;

    public Book(String title, Date publishDate, String comment) {
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return Objects.equals(title, book.title) &&
                Objects.equals(publishDate, book.publishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publishDate);
    }

    @Override
    public int compareTo(Book other) {
        if (this.publishDate == null && other.publishDate == null) {
            return 0;
        }
        if (this.publishDate == null) {
            return 1;
        }
        if (other.publishDate == null) {
            return -1;
        }

        return other.publishDate.compareTo(this.publishDate);
    }

    @Override
    public Book clone() {
        try {
            Book cloned = (Book) super.clone();

            if (this.publishDate != null) {
                cloned.publishDate = (Date) this.publishDate.clone();
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }
}