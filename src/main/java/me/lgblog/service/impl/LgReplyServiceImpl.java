package me.lgblog.service.impl;

import java.util.List;

import me.lgblog.mapper.LgReplyMapper;
import me.lgblog.pojo.LgReply;
import me.lgblog.pojo.LgReplyExample;
import me.lgblog.pojo.LgReplyExample.Criteria;
import me.lgblog.service.LgReplyService;
import me.lgblog.util.ValidateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LgReplyServiceImpl implements LgReplyService{

	@Autowired
	private LgReplyMapper lgReplyMapper;
	
	@Override
	public void addReply(LgReply lgReply) {
		lgReplyMapper.insert(lgReply);
	}

	@Override
	public void deleteReplyById(int id) {
		lgReplyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteReplyByBlogId(int blogId) {
		LgReplyExample example = new LgReplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andLgBlogIdEqualTo(blogId);
		lgReplyMapper.deleteByExample(example);
	}

	@Override
	public List<LgReply> getAllReply() {
		LgReplyExample example = new LgReplyExample();
		List<LgReply> list = lgReplyMapper.selectByExampleWithBLOBs(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

	@Override
	public List<LgReply> getAllReplyByBlogId(int blogId) {
		LgReplyExample example = new LgReplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andLgBlogIdEqualTo(blogId);
		example.setOrderByClause("reply_createTime DESC");
		List<LgReply> list = lgReplyMapper.selectByExampleWithBLOBs(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

	@Override
	public int getCount() {
		LgReplyExample example = new LgReplyExample();
		return lgReplyMapper.countByExample(example);
	}

	@Override
	public int getCountByBlogId(int blogId) {
		LgReplyExample example = new LgReplyExample();
		Criteria criteria = example.createCriteria();
		criteria.andLgBlogIdEqualTo(blogId);
		return lgReplyMapper.countByExample(example);
	}

	@Override
	public LgReply getAReply(int id) {
		LgReplyExample example = new LgReplyExample();
		example.setOrderByClause("reply_createTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<LgReply> list = lgReplyMapper.selectByExampleWithBLOBs(example);
		return ValidateUtil.isValid(list) ? list.get(0) : null;
	}
}
