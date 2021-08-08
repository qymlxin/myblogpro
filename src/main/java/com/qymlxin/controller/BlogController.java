package com.qymlxin.controller;

import com.qymlxin.common.result.Result;
import com.qymlxin.mapper.BlogMapper;
import com.qymlxin.pojo.Blog;
import com.qymlxin.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/queryById/{id}")
    public Object queryById(@PathVariable("id") int id) {
        Blog blog = blogService.queryBlogById(id);
        System.out.println(blog);
        return Result.success(blog);
    }

    @RequestMapping("/queryByUserId/{id}")
    public Object queryByUserId(@PathVariable("id") int id) {
        List<Blog> blogList = blogService.queryBlogByUserId(id);
        return Result.success(blogList);
    }

    @RequestMapping("/search/{keyword}")
    public Object searchBlog(@PathVariable("keyword") String keyword) {
        List<Blog> byTitleList = blogService.queryBlogByTitle(keyword);
        List<Blog> byDescList = blogService.queryByDesc(keyword);
        Set<Blog> allSet = new HashSet<>();
        allSet.addAll(byTitleList);
        allSet.addAll(byDescList);
        return new ArrayList<>(allSet);
    }

    @RequestMapping("/queryAll")
    public Object queryAll() {
        return blogService.queryAllBlog();
    }

    @RequestMapping("/addBlog")
    public Object addBlog(@RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

    @RequestMapping("/updateBlog")
    public Object updateBlog(@RequestBody Blog blog) {
        return blogService.updateBlog(blog);
    }

    @RequestMapping("/deleteBlog/{id}")
    public Object deleteBlog(@PathVariable("id") int id) {
        return blogService.deleteBlog(id);
    }
}