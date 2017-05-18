package com.niit.chatzonebe.dao;

import java.util.List;

import com.niit.chatzonebe.model.Blog;

public interface BlogDAO {
	public List<Blog> list();
	
	public boolean save(Blog blog);
	
	public boolean update(Blog blog);
	
	public Blog get(int blogid);
	
	public boolean delete(Blog blog);
	
	public Blog getBlogById(int blogid);
	
	public boolean delete(int blogid);
	
	public boolean update(int blogid);
	
	

}
