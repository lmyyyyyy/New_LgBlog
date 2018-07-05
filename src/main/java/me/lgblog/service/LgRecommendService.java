package me.lgblog.service;

import java.util.List;

import me.lgblog.pojo.LgRecommend;

public interface LgRecommendService {
	void addRecommend(LgRecommend lgRecommend);
	void delRecommend(int id);
	List<LgRecommend> getAllRecommend();
	LgRecommend getARecommend(int blogId);
	void delRecommendByBlogId(Integer blogId);
	void updateLgRec(LgRecommend lgRecommend);
}
