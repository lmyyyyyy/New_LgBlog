package me.lgblog.service.impl;

import java.util.List;

import me.lgblog.mapper.LgLinksMapper;
import me.lgblog.pojo.LgLinks;
import me.lgblog.pojo.LgLinksExample;
import me.lgblog.service.LgLinksService;
import me.lgblog.util.ValidateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LgLinksServiceImpl implements LgLinksService{

	@Autowired
	private LgLinksMapper lgLinksMapper;
	
	@Override
	public void addLink(LgLinks listLink) {
		lgLinksMapper.insert(listLink);
	}

	@Override
	public void deleteLink(int id) {
		lgLinksMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateLink(LgLinks lgLinks) {
		LgLinksExample example = new LgLinksExample();
		lgLinksMapper.updateByExample(lgLinks, example);
	}

	@Override
	public LgLinks getALink(int id) {
		LgLinks lgLinks = lgLinksMapper.selectByPrimaryKey(id);
		return lgLinks;
	}

	@Override
	public List<LgLinks> getAllLinks() {
		LgLinksExample example = new LgLinksExample();
		example.setOrderByClause("id DESC");
		List<LgLinks> list = lgLinksMapper.selectByExample(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

}
