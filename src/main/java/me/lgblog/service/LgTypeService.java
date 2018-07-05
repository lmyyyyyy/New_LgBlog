package me.lgblog.service;


import java.util.List;

import me.lgblog.pojo.LgType;
import me.lgblog.util.PageResult;

public interface LgTypeService {
	
	void addType(LgType lgType);
	PageResult<LgType> allType(Integer page, Integer rows);
	List<LgType> getAllType(Integer page, Integer rows);
	List<LgType> getAllType();
	void modify(LgType lgType);
	void delType(int id);
}
