package me.lgblog.service;

import java.util.Date;
import java.util.List;

import me.lgblog.pojo.LgClick;

public interface LgClickService {
	boolean validate(int blogId, String ip, Date date);
	void addLgClick(LgClick lgClick);
	LgClick getALgClick(int id);
	List<LgClick> getAllClick();
	LgClick getALgClickByBlogId(int blogId);
	void delete(int blogId);
}
