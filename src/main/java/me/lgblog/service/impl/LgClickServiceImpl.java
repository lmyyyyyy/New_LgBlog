package me.lgblog.service.impl;

import java.util.Date;
import java.util.List;

import me.lgblog.mapper.LgClickMapper;
import me.lgblog.pojo.LgClick;
import me.lgblog.pojo.LgClickExample;
import me.lgblog.pojo.LgClickExample.Criteria;
import me.lgblog.service.LgClickService;
import me.lgblog.util.ValidateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LgClickServiceImpl implements LgClickService{

	@Autowired
	private LgClickMapper lgClickMapper;
	
	@Override
	public boolean validate(int blogId, String ip, Date date) {
		LgClickExample example = new LgClickExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo(blogId);
		criteria.andClickIpEqualTo(ip);
		criteria.andClickTimeEqualTo(date);
		List<LgClick> list = lgClickMapper.selectByExample(example);
		return ValidateUtil.isValid(list);
	}

	@Override
	public LgClick getALgClick(int id) {
		return lgClickMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LgClick> getAllClick() {
		LgClickExample example = new LgClickExample();
		List<LgClick> list = lgClickMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

	@Override
	public LgClick getALgClickByBlogId(int blogId) {
		LgClickExample example = new LgClickExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo(blogId);
		return lgClickMapper.selectByExample(example).get(0);
	}

	@Override
	public void delete(int blogId) {
		LgClickExample example = new LgClickExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogidEqualTo(blogId);
		lgClickMapper.deleteByExample(example);
	}

	@Override
	public void addLgClick(LgClick lgClick) {
		lgClickMapper.insert(lgClick);
	}

}
