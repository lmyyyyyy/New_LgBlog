package me.lgblog.controller;



import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lgblog.pojo.LgBlog;
import me.lgblog.pojo.LgClick;
import me.lgblog.pojo.LgLinks;
import me.lgblog.pojo.LgRecommend;
import me.lgblog.pojo.LgReply;
import me.lgblog.pojo.LgType;
import me.lgblog.pojo.LgUpvote;
import me.lgblog.service.JedisService;
import me.lgblog.service.LgBlogService;
import me.lgblog.service.LgClickService;
import me.lgblog.service.LgLinksService;
import me.lgblog.service.LgRecommendService;
import me.lgblog.service.LgReplyService;
import me.lgblog.service.LgTypeService;
import me.lgblog.service.LgUpvoteService;
import me.lgblog.util.IPAddressUtil;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private LgBlogService lgBlogService;
	
	@Autowired
	private LgLinksService lgLinksService;
	
	@Autowired
	private LgTypeService lgTypeService;
	
	@Autowired
	private LgRecommendService lgRecommendService;
	
	@Autowired
	private LgReplyService lgReplyService;
	
	@Autowired
	private LgClickService lgClickService;
	
	@Autowired
	private LgUpvoteService lgUpvoteService;
	
	@Autowired
	private JedisService jedisService;
	
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNum, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize,
			@RequestParam(defaultValue="all",required=false) String blogType,@RequestParam(defaultValue="",required=false) String searchbox) {
		logger.info("分页查询博客信息列表请求入参：pageNum{},pageSize{}", pageNum, pageSize);
		try {
			searchbox = new String(searchbox.trim().getBytes("iso-8859-1"),"utf-8");
			System.out.println(searchbox);
			blogType = new String(blogType.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try{
			PageHelper.startPage(pageNum, pageSize);
			List<LgBlog> lgBlogList = null;
			System.out.println("查询标签"+blogType);
			if (!blogType.equals("all")) {
				lgBlogList = lgBlogService.getAllLgBlogByType(blogType);
			} else if (searchbox.equals("") || searchbox == null ) {
				lgBlogList = lgBlogService.getAllLgBlog();
			} else {
				lgBlogList = lgBlogService.getAllLgBlogBySearch(searchbox);
			}
			PageInfo<LgBlog> pageInfo = new PageInfo<LgBlog>(lgBlogList);
			List<LgLinks> lgLinksList = lgLinksService.getAllLinks();
			List<LgType> lgTypeList = lgTypeService.getAllType();
			List<LgRecommend> lgRecommendList = lgRecommendService.getAllRecommend();
			model.addAttribute("page", pageInfo);
			model.addAttribute("lgLinksList",lgLinksList);
			model.addAttribute("lgTypeList",lgTypeList);
			model.addAttribute("lgRecommendList", lgRecommendList);
			model.addAttribute("blogType", blogType);
		} catch(Exception e) {
			logger.info("分页查询类型失败");
			model.addAttribute("err", "查询数据失败");
		}
		return "index";
	}
	
	@RequestMapping("/home")
	public String toHome(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNum, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize,
			@RequestParam(defaultValue="all",required=false) String blogType,@RequestParam(defaultValue="",required=false) String searchbox) {
		logger.info("分页查询博客信息列表请求入参：pageNum{},pageSize{}", pageNum, pageSize);
		
		try {
			searchbox = new String(searchbox.trim().getBytes("iso-8859-1"),"utf-8");
			blogType = new String(blogType.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try{
			PageHelper.startPage(pageNum, pageSize);
			List<LgBlog> lgBlogList = null;
			System.out.println("查询标签"+blogType);
			if (!blogType.equals("all")) {
				lgBlogList = lgBlogService.getAllLgBlogByType(blogType);
			} else if (searchbox.equals("") || searchbox == null ) {
				lgBlogList = lgBlogService.getAllLgBlog();
			} else {
				lgBlogList = lgBlogService.getAllLgBlogBySearch(searchbox);
			}
			PageInfo<LgBlog> pageInfo = new PageInfo<LgBlog>(lgBlogList);
			List<LgLinks> lgLinksList = lgLinksService.getAllLinks();
			List<LgType> lgTypeList = lgTypeService.getAllType();
			List<LgRecommend> lgRecommendList = lgRecommendService.getAllRecommend();
			model.addAttribute("page", pageInfo);
			model.addAttribute("lgLinksList",lgLinksList);
			model.addAttribute("lgTypeList",lgTypeList);
			model.addAttribute("lgRecommendList", lgRecommendList);
			model.addAttribute("blogType", blogType);
		} catch(Exception e) {
			logger.info("分页查询类型失败");
			model.addAttribute("err", "查询数据失败");
		}
		return "home";
	}
	@RequestMapping("/about")
	public String toAbout() {
		return "about";
	}
	@RequestMapping("/contact")
	public String toContact() {
		return "contact";
	}
	@RequestMapping(value="/single/{id}")
	public String toSingle(@PathVariable Integer id,Model model,HttpServletRequest request, HttpServletResponse response) {
		String ip = IPAddressUtil.getIpAddress(request);
		System.out.println("他的ip地址为：" + ip);
		String isView = "UnView";
		try{
			if (lgUpvoteService.validate(id, ip)) {
				isView = "isViewed";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String stime = sdf.format(new Date());
			Date cTime = null;
			try {
				cTime = sdf.parse(stime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			LgBlog lgBlog = lgBlogService.getLgBlogById(id);
			if (!lgClickService.validate(id, ip, cTime)) {
				int clickCount = lgBlog.getBlogClickCount();
				lgBlog.setBlogClickCount(clickCount+1);
				lgBlogService.updateLgBlog(lgBlog);
				LgClick lgClick = new LgClick();
				lgClick.setBlogid(id);
				lgClick.setClickIp(ip);
				lgClick.setClickTime(new Date());
				lgClickService.addLgClick(lgClick);
			}
			List<LgLinks> lgLinksList = lgLinksService.getAllLinks();
			List<LgType> lgTypeList = lgTypeService.getAllType();
			List<LgRecommend> lgRecommendList = lgRecommendService.getAllRecommend();
			List<LgReply> lgReplyList = lgReplyService.getAllReplyByBlogId(id);
			model.addAttribute("lgBlog",lgBlog);
			model.addAttribute("lgLinksList",lgLinksList);
			model.addAttribute("lgTypeList",lgTypeList);
			model.addAttribute("lgRecommendList", lgRecommendList);
			model.addAttribute("lgReplyList", lgReplyList);
			model.addAttribute("isView", isView);
		} catch (Exception e) {
			logger.info("获取文章失败",e);
		}
		return "single";
	}
	
	
	@Transactional
	@RequestMapping("/single/upvote/{id}")
	@ResponseBody
	public String upvote(@PathVariable Integer id,Model model,HttpServletRequest request, HttpServletResponse response) {
		String ip = IPAddressUtil.getIpAddress(request);
		System.out.println(ip + "赞了我一下 id:"+ id);
		JSONObject json= new JSONObject();
		try {
			if (!lgUpvoteService.validate(id, ip)) {
				LgBlog lgBlog = lgBlogService.getLgBlogById(id);
				int upvoteCount = lgBlog.getBlogUpvoteCount();
				lgBlog.setBlogUpvoteCount(upvoteCount+1);
				LgUpvote lgUpvote = new LgUpvote();
				lgUpvote.setBlogid(id);
				lgUpvote.setUpvoteIp(ip);
				lgUpvote.setUpvoteTime(new Date());
				lgUpvoteService.addLgUpvote(lgUpvote);
				lgBlogService.updateLgBlog(lgBlog);
				json.put("result", "ok");
			} else {
				json.put("result", "not");
			}
		} catch (Exception e) {
			logger.info("点赞失败",e);
			json.put("result", "error");
		}
		return json.toString();
	}
	
	@RequestMapping("/home/upvote")
	@ResponseBody
	@Transactional
	public String homeUpvote(@RequestParam Integer id,Model model,HttpServletRequest request, HttpServletResponse response) {
		String ip = IPAddressUtil.getIpAddress(request);
		System.out.println(ip + "赞了我一下");
		JSONObject json= new JSONObject();
		try {
			if (!lgUpvoteService.validate(id, ip)) {
				LgBlog lgBlog = lgBlogService.getLgBlogById(id);
				int upvoteCount = lgBlog.getBlogUpvoteCount();
				lgBlog.setBlogUpvoteCount(upvoteCount+1);
				LgUpvote lgUpvote = new LgUpvote();
				lgUpvote.setBlogid(id);
				lgUpvote.setUpvoteIp(ip);
				lgUpvote.setUpvoteTime(new Date());
				/*long count = jedisService.like(ip, lgBlog.getBlogType(), id);
				System.out.println(count);*/
				lgUpvoteService.addLgUpvote(lgUpvote);
				lgBlogService.updateLgBlog(lgBlog);
				json.put("upvoteCount", upvoteCount+1);
				json.put("result", "ok");
			} else {
				json.put("result", "not");
			}
		} catch (Exception e) {
			logger.info("点赞失败",e);
			json.put("result", "error");
		}
		return json.toString();
	}
}
