package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/8.
 */
public interface ArticleDao {
    public List<Article> selectAll(@Param("begin") int begin,@Param("end") int end);

    public int insert(@Param("article")Article article);
}
