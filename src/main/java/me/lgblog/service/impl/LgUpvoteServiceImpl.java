package me.lgblog.service.impl;

import java.util.List;

import me.lgblog.mapper.LgUpvoteMapper;
import me.lgblog.pojo.LgUpvote;
import me.lgblog.pojo.LgUpvoteExample;
import me.lgblog.pojo.LgUpvoteExample.Criteria;
import me.lgblog.service.LgUpvoteService;
import me.lgblog.util.ValidateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LgUpvoteServiceImpl implements LgUpvoteService{

	@Autowired
	private LgUpvoteMapper lgUpvoteMapper;
	
	@Override
	public boolean validate(int blogId, String ip) {
		LgUpvoteExample example = new LgUpvoteExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo(blogId);
		criteria.andUpvoteIpEqualTo(ip);
		List<LgUpvote> list =lgUpvoteMapper.selectByExample(example);
		return ValidateUtil.isValid(list);
	}

	@Override
	public void addLgUpvote(LgUpvote lgUpvote) {
		lgUpvoteMapper.insert(lgUpvote);
	}

	@Override
	public void deleteLgUpvote(int id) {
		lgUpvoteMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteLgUpvoteByBlogId(int blogId) {
		LgUpvoteExample example = new LgUpvoteExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo(blogId);
		lgUpvoteMapper.deleteByExample(example);
	}

	@Override
	public List<LgUpvote> getAllLgUpvote() {
		LgUpvoteExample example = new LgUpvoteExample();
		List<LgUpvote> list = lgUpvoteMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

	@Override
	public List<LgUpvote> getAllLgUpvoteByBlogId(int blogId) {
		LgUpvoteExample example = new LgUpvoteExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo(blogId);
		List<LgUpvote> list = lgUpvoteMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

}
