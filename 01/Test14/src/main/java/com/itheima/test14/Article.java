package com.itheima.test14;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long authorId;
    private String title;
    private String content;
    private ArticleStaus status;
    private LocalDateTime createdAt;
    private Integer views;

    public Article(Long id, Long authorId, String title, String content, LocalDateTime createdAt, Integer views) {

        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.status=status;
        this.views = views;

    }
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ArticleStaus  getStatus() {
        return status;
    }

    public void setStatus(ArticleStaus  status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", views=" + views +
                '}';
    }
}
