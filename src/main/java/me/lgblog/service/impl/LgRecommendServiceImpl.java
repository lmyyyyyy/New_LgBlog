package me.lgblog.service.impl;

import java.util.List;

import me.lgblog.mapper.LgRecommendMapper;
import me.lgblog.pojo.LgRecommend;
import me.lgblog.pojo.LgRecommendExample;
import me.lgblog.pojo.LgRecommendExample.Criteria;
import me.lgblog.service.LgRecommendService;
import me.lgblog.util.ValidateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LgRecommendServiceImpl implements LgRecommendService{

	@Autowired
	private LgRecommendMapper lgRecommendMapper;
	
	@Override
	public void addRecommend(LgRecommend lgRecommend) {
		lgRecommendMapper.insert(lgRecommend);
	}

	@Override
	public void delRecommend(int id) {
		lgRecommendMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<LgRecommend> getAllRecommend() {
		LgRecommendExample example = new LgRecommendExample();
		List<LgRecommend> list = lgRecommendMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

	@Override
	public LgRecommend getARecommend(int blogId) {
		LgRecommendExample example = new LgRecommendExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogIdEqualTo(blogId);
		List<LgRecommend> list = lgRecommendMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list.get(0) : null;
	}

	@Override
	public void delRecommendByBlogId(Integer blogId) {
		LgRecommendExample example = new LgRecommendExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogIdEqualTo(blogId);
		lgRecommendMapper.deleteByExample(example);
	}

	@Override
	public void updateLgRec(LgRecommend lgRecommend) {
		lgRecommendMapper.updateByPrimaryKey(lgRecommend);
	}

}
