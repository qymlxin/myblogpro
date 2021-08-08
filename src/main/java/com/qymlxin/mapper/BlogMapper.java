package com.qymlxin.mapper;

import com.qymlxin.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BlogMapper {
    public Blog queryBlogById(int id);
    public List<Blog> queryBlogByUserId(@Param("userid") int userId);
    public List<Blog> queryBlogByTitle(String title);
    public List<Blog> queryAllBlog();
    public List<Blog> queryByDesc(@Param("keyword") String keyword);
    public int addBlog(Blog blog);
    public int updateBlog(Blog blog);
    public int deleteBlog(int id);
}
