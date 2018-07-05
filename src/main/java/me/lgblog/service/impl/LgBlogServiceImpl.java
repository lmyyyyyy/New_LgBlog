package me.lgblog.service.impl;

import java.util.List;

import me.lgblog.mapper.LgBlogMapper;
import me.lgblog.pojo.LgBlog;
import me.lgblog.pojo.LgBlogExample;
import me.lgblog.pojo.LgBlogExample.Criteria;
import me.lgblog.service.LgBlogService;
import me.lgblog.util.ValidateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LgBlogServiceImpl implements LgBlogService{

	@Autowired
	private LgBlogMapper lgBlogMapper;
	
	@Override
	public int addLgBlog(LgBlog lgBlog) {
		return lgBlogMapper.insert(lgBlog);
	}

	@Override
	public void updateLgBlog(LgBlog lgBLog) {
		/*LgBlogExample example = new LgBlogExample();
		lgBlogMapper.updateByExampleWithBLOBs(lgBLog, example);*/
		lgBlogMapper.updateByPrimaryKeyWithBLOBs(lgBLog);
	}

	@Override
	public void deleteLgBlog(int id) {
		lgBlogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<LgBlog> getAllLgBlog() {
		LgBlogExample example = new LgBlogExample();
		example.setOrderByClause("blog_createTime DESC");
		List<LgBlog> list = lgBlogMapper.selectByExample(example);
		return ValidateUtil.isValid(list)?list:null;
	}

	@Override
	public List<LgBlog> getAllLgBlog(int pageNumber, int pageSize) {
		return null;
	}

	@Override
	public int getLgBlogCount() {
		LgBlogExample example = new LgBlogExample();
		return lgBlogMapper.countByExample(example);
	}

	@Override
	public LgBlog getLgBlogById(int id) {
		LgBlogExample example = new LgBlogExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		LgBlog lgBlog = (LgBlog) lgBlogMapper.selectByExampleWithBLOBs(example).get(0);
		return lgBlog;
	}

	@Override
	public List<LgBlog> getAllLgBlogByType(String type) {
		LgBlogExample example = new LgBlogExample();
		example.setOrderByClause("blog_createTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andBlogTypeEqualTo(type);
		List<LgBlog> list = lgBlogMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

	@Override
	public int getLgBlogClickCount() {
		int count = 0;
		LgBlogExample example = new LgBlogExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogClickCountNotEqualTo(0);
		List<LgBlog> list = lgBlogMapper.selectByExample(example);
		for (int i=0; i<list.size(); i++) {
			LgBlog lgBlog = list.get(i);
			count += lgBlog.getBlogClickCount();
		}
		return count;
	}

	@Override
	public int getLgBlogUpvote() {
		int count = 0;
		LgBlogExample example = new LgBlogExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogUpvoteCountNotEqualTo(0);
		List<LgBlog> list = lgBlogMapper.selectByExample(example);
		for (int i=0; i<list.size(); i++) {
			LgBlog lgBlog = list.get(i);
			count += lgBlog.getBlogUpvoteCount();
		}
		return count;
	}

	@Override
	public List<LgBlog> getAllLgBlogBySearch(String str) {
		LgBlogExample example = new LgBlogExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogDescLike("%"+str+"%");
		List<LgBlog> list = lgBlogMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

}
