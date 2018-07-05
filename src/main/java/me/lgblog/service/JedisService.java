package me.lgblog.service;

public interface JedisService {
	int getLikeStatus(String ip, String type, int blogId);
	long like(String ip, String type, int blogId);
	long disLike(String ip, String type, int blogId);
}
