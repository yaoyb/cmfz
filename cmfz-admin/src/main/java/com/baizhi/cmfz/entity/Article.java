package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 姚亚博 on 2018/7/8.
 */
public class Article {
    private String articleId;
    private String articleName;
    private String articleContent;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")//相应
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//请求
    private Date articleDate;
    private String articlePic;
    private Master master;

    public Article() {
    }

    public Article(String articleId, String articleName, String articleContent, Date articleDate, String articlePic, Master master) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articlePic = articlePic;
        this.master = master;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate='" + articleDate + '\'' +
                ", articlePic='" + articlePic + '\'' +
                ", master=" + master +
                '}';
    }
}
