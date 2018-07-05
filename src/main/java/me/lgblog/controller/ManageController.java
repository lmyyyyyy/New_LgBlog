package me.lgblog.controller;

import java.util.Map;

import me.lgblog.service.LgBlogService;
import me.lgblog.service.LgReplyService;
import me.lgblog.service.LgTypeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController extends BaseController{
	
	private Logger logger = LoggerFactory.getLogger(ManageController.class);
	@Autowired
	private LgBlogService lgBlogService;
	@Autowired
	private LgTypeService lgTypeService;
	@Autowired
	private LgReplyService lgReplyService;
	
	@RequestMapping("/manage")
	public String toManage() {
		return "manage/manage";
	}
	
	@RequestMapping("/manage/hom")
	public String toHome(Map<String,Object> map,ModelMap modelMap) {
		int blogCount = lgBlogService.getLgBlogCount();
		int clickCount = lgBlogService.getLgBlogClickCount();
		int upvoteCount = lgBlogService.getLgBlogUpvote();
		int replyCount  = lgReplyService.getCount();
		map.put("blogCount", blogCount);
		modelMap.addAttribute("clickCount", clickCount);
		modelMap.addAttribute("upvoteCount", upvoteCount);
		modelMap.addAttribute("replyCount", replyCount);
		return "manage/mhome";
	}
}
