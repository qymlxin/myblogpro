package com.qymlxin.service.impl;

import com.qymlxin.mapper.BlogMapper;
import com.qymlxin.pojo.Blog;
import com.qymlxin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public Blog queryBlogById(int id) {
        return blogMapper.queryBlogById(id);
    }

    @Override
    public List<Blog> queryBlogByUserId(int userId) {
        return blogMapper.queryBlogByUserId(userId);
    }

    @Override
    public List<Blog> queryBlogByTitle(String title) {
        return blogMapper.queryBlogByTitle(title);
    }

    @Override
    public List<Blog> queryAllBlog() {
        return blogMapper.queryAllBlog();
    }

    @Override
    public List<Blog> queryByDesc(String keyword) {
        return blogMapper.queryByDesc(keyword);
    }

    @Override
    public int addBlog(Blog blog) {
        List<Blog> blogList = blogMapper.queryBlogByUserId(blog.getUserId());
        for(Blog item : blogList) {
            if(item.getTitle().equalsIgnoreCase(blog.getTitle()))
                return -1;
        }
        return blogMapper.addBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        Blog oldBlog = blogMapper.queryBlogById(blog.getId());
        Blog newBlog = new Blog();
        newBlog.setId(oldBlog.getId());
        newBlog.setUserId(oldBlog.getUserId());
        newBlog.setStatus(oldBlog.getStatus());
        newBlog.setCreated(oldBlog.getCreated());
        if(blog.getTitle() == null) {
            newBlog.setTitle(oldBlog.getTitle());
        } else {
            newBlog.setTitle(blog.getTitle());
        }

        if(blog.getDescription() == null) {
            newBlog.setDescription(oldBlog.getDescription());
        } else {
            newBlog.setDescription(blog.getDescription());
        }

        if(blog.getContent() == null) {
            newBlog.setContent(oldBlog.getContent());
        } else {
            newBlog.setContent(blog.getContent());
        }

        return 0;
    }

    @Override
    public int deleteBlog(int id) {
        return blogMapper.deleteBlog(id);
    }
}
