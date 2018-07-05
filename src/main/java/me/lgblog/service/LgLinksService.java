package me.lgblog.service;

import java.util.List;

import me.lgblog.pojo.LgLinks;

public interface LgLinksService {
	void addLink(LgLinks listLink);
	void deleteLink(int id);
	void updateLink(LgLinks lgLinks);
	
	LgLinks getALink(int id);
	List<LgLinks> getAllLinks();
}
