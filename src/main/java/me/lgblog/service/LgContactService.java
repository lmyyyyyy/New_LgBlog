package me.lgblog.service;

import java.util.List;

import me.lgblog.pojo.LgContact;

public interface LgContactService {
	
		void addContact(LgContact lgContact);
		void delContact(int id);
		
		LgContact getALgContact(int id);
		List<LgContact> getAllLgContact();
}
