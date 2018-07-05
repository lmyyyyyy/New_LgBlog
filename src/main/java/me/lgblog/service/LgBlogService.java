package me.lgblog.service;

import java.util.List;

import me.lgblog.pojo.LgBlog;


public interface LgBlogService {
	int addLgBlog(LgBlog lgBlog);
	void updateLgBlog(LgBlog lgBLog);
	void deleteLgBlog(int id);
	
	List<LgBlog> getAllLgBlog();
	List<LgBlog> getAllLgBlog(int pageNumber, int pageSize);
	List<LgBlog> getAllLgBlogByType(String type);
	List<LgBlog> getAllLgBlogBySearch(String str);
	int getLgBlogCount();
	LgBlog getLgBlogById(int id);
	int getLgBlogClickCount();
	int getLgBlogUpvote();
	
}
