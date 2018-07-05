package me.lgblog.service;

import java.util.List;

import me.lgblog.pojo.LgUpvote;

public interface LgUpvoteService {
	boolean validate(int blogId, String ip);
	void addLgUpvote(LgUpvote lgUpvote);
	void deleteLgUpvote(int id);
	void deleteLgUpvoteByBlogId(int blogId);
	
	List<LgUpvote> getAllLgUpvote();
	List<LgUpvote> getAllLgUpvoteByBlogId(int blogId);
}
