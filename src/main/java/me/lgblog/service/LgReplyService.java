package me.lgblog.service;

import java.util.List;

import me.lgblog.pojo.LgReply;

public interface LgReplyService {
	void addReply(LgReply lgReply);
	void deleteReplyById(int id);
	void deleteReplyByBlogId(int blogId);

	List<LgReply> getAllReply();
	List<LgReply> getAllReplyByBlogId(int blogId);
	int getCount();
	int getCountByBlogId(int blogId);
	LgReply getAReply(int id);
}
