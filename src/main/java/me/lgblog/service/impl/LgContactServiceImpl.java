package me.lgblog.service.impl;

import java.util.List;

import me.lgblog.mapper.LgContactMapper;
import me.lgblog.pojo.LgContact;
import me.lgblog.pojo.LgContactExample;
import me.lgblog.pojo.LgContactExample.Criteria;
import me.lgblog.service.LgContactService;
import me.lgblog.util.ValidateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LgContactServiceImpl implements LgContactService{

	@Autowired
	private LgContactMapper lgContactMapper;
	
	@Override
	public void addContact(LgContact lgContact) {
		lgContactMapper.insert(lgContact);
	}

	@Override
	public void delContact(int id) {
		lgContactMapper.deleteByPrimaryKey(id);
	}

	@Override
	public LgContact getALgContact(int id) {
		LgContactExample example = new LgContactExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		LgContact lgContact = (LgContact) lgContactMapper.selectByExampleWithBLOBs(example).get(0);
		return lgContact;
	}

	@Override
	public List<LgContact> getAllLgContact() {
		LgContactExample example = new LgContactExample();
		example.setOrderByClause("contact_createTime DESC");
		List<LgContact> list = lgContactMapper.selectByExampleWithBLOBs(example);
		return ValidateUtil.isValid(list) ? list : null;
	}

}
