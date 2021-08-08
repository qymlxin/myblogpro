package com.qymlxin.service;

import com.qymlxin.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogService {
    public Blog queryBlogById(int id);
    public List<Blog> queryBlogByUserId(@Param("userid") int userId);
    public List<Blog> queryBlogByTitle(String title);
    public List<Blog> queryAllBlog();
    public List<Blog> queryByDesc(String keyword);
    public int addBlog(Blog blog);
    public int updateBlog(Blog blog);
    public int deleteBlog(int id);
}
