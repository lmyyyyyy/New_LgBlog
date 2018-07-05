package me.lgblog.service.impl;

import me.lgblog.mapper.JedisClient;
import me.lgblog.service.JedisService;
import me.lgblog.util.RedisKeyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JedisServiceImpl implements JedisService{
	
	@Autowired
	private JedisClient jedisClient;

	/**
	 * 判断是喜欢还是不喜欢
	 */
	public int getLikeStatus(String ip, String type, int blogId) {
		String likeKey = RedisKeyUtil.getLikeKey(ip, type, blogId);
		if (jedisClient.sismember(likeKey, ip)){
			return 1;
		}
		String disLikeKey = RedisKeyUtil.getDisLikeKey(ip, type, blogId);
		return jedisClient.sismember(disLikeKey, ip) ? -1 : 0;
	}

	/**
	 * 点赞
	 */
	public long like(String ip, String type, int blogId) {
		String likeKey = RedisKeyUtil.getLikeKey(ip, type, blogId);
		jedisClient.sadd(likeKey, ip);
		String disLikeKey = RedisKeyUtil.getDisLikeKey(ip, type, blogId);
		jedisClient.srem(disLikeKey, ip);
		return jedisClient.scard(likeKey);
	}

	/**
	 * 取消赞
	 */
	public long disLike(String ip, String type, int blogId) {
		String disLikeKey = RedisKeyUtil.getDisLikeKey(ip, type, blogId);
		jedisClient.sadd(disLikeKey, ip);
		String likeKey = RedisKeyUtil.getLikeKey(ip, type, blogId);
		jedisClient.srem(likeKey, ip);
		return jedisClient.scard(likeKey);
	}

}
