package me.lgblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lgblog.pojo.LgLinks;
import me.lgblog.service.LgLinksService;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class LgLinksController {

	private Logger logger = LoggerFactory.getLogger(LgLinksController.class);
	
	@Autowired
	private LgLinksService lgLinksService;
	
	@RequestMapping("/manage/toAddLink")
	public String toAddLink(Model model) {
		return "manage/addLink";
	}
	
	@RequestMapping("/manage/addLink")
	@ResponseBody
	public String addLink(Model model,@RequestBody LgLinks lgLink,HttpServletRequest request,HttpServletResponse response) {
		logger.info("添加链接",lgLink.getUserLink());
		System.out.println(lgLink.getUserLink());
		JSONObject json = new JSONObject();
		try {
			lgLinksService.addLink(lgLink);
			json.put("result", "ok");
			return json.toString();
		} catch(Exception e) {
			logger.info("添加链接失败",e);
		}
		json.put("result", "error");
		return json.toString();
	}
	
	@RequestMapping("/manage/toModifyLink/{id}")
	public String toModify(Model model, @PathVariable("id")Integer id) {
		LgLinks lgLinks = lgLinksService.getALink(id);
		model.addAttribute("lgLinks", lgLinks);
		return "manage/modifyLink";
	}
	
	@RequestMapping(value="/manage/modifyLink",method=RequestMethod.POST)
	@ResponseBody
	public String modify(@RequestBody LgLinks lgLinks,HttpServletRequest request, HttpServletResponse response) {
		logger.info("修改链接开始");
		JSONObject json = new JSONObject();
		try{
			if (lgLinks.getUserLink() != null && !lgLinks.getUserLink().equals("")) {
				lgLinksService.updateLink(lgLinks);
				json.put("result", "ok");
				return json.toString();
			}
		} catch (Exception e) {
			logger.info("修改链接失败",e);
		}
		json.put("result", "error");
		return json.toString();
	}
	
	@RequestMapping(value="/manage/delLink/{id}")
	public String delLink(@PathVariable("id")Integer id) {
		logger.info("删除该条链接，ID为",id);
		try {
			lgLinksService.deleteLink(id);
		} catch (Exception e) {
			logger.info("删除链接失败",e);
		}
		return "redirect:/manage/allLinks?pageNum=1&pageSize=10";
	}
	
	@RequestMapping(value="/manage/allLinks",method={RequestMethod.GET,RequestMethod.POST})
	public String allLinks(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNumber, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PageHelper.startPage(request);
			List<LgLinks> list = lgLinksService.getAllLinks();
			PageInfo<LgLinks> pageInfo = new PageInfo<LgLinks>(list);
			model.addAttribute("page", pageInfo);
		} catch (Exception e) {
			logger.info("查询链接分页失败",e);
		}
		return "manage/allUserLinks";
	}
}
