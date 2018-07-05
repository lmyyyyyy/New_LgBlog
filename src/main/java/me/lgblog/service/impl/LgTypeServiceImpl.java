package me.lgblog.service.impl;

import java.util.List;

import me.lgblog.mapper.JedisClient;
import me.lgblog.mapper.LgTypeMapper;
import me.lgblog.pojo.LgType;
import me.lgblog.pojo.LgTypeExample;
import me.lgblog.service.LgTypeService;
import me.lgblog.util.PageResult;
import me.lgblog.util.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;


@Service
public class LgTypeServiceImpl implements LgTypeService{

	@Autowired
	private LgTypeMapper lgTypeMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public void addType(LgType lgType) {
		lgTypeMapper.insert(lgType);
	}

	@Override
	public PageResult<LgType> allType(Integer page, Integer rows) {
		page = page == null ? 1 : page;
		rows = rows == null ? 10 : rows;
		PageHelper.startPage(page, rows);
		LgTypeExample example = new LgTypeExample();
		List<LgType> list = lgTypeMapper.selectByExample(example);
		return PageUtil.toPageResult(list);
	}
	
	public List<LgType> getAllType(Integer page, Integer rows) {
		LgTypeExample example = new LgTypeExample();
		List<LgType> list = lgTypeMapper.selectByExample(example);
		return list;
	}
	public List<LgType> getAllType() {
		LgTypeExample example = new LgTypeExample();
		List<LgType> list = lgTypeMapper.selectByExample(example);
		return list;
	}

	@Override
	public void modify(LgType lgType) {
	}

	@Override
	public void delType(int id) {
		lgTypeMapper.deleteByPrimaryKey(id);
	}

}
