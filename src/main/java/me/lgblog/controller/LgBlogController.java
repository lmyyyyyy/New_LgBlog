package me.lgblog.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lgblog.pojo.LgBlog;
import me.lgblog.pojo.LgRecommend;
import me.lgblog.pojo.LgType;
import me.lgblog.service.LgBlogService;
import me.lgblog.service.LgClickService;
import me.lgblog.service.LgRecommendService;
import me.lgblog.service.LgReplyService;
import me.lgblog.service.LgTypeService;
import me.lgblog.service.LgUpvoteService;
import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
public class LgBlogController extends BaseController{

	private Logger logger = LoggerFactory.getLogger(LgBlogController.class);
	
	@Autowired
	private LgBlogService lgBlogService;
	
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
	
	@RequestMapping(value="/manage/send",method = {  
	        RequestMethod.GET, RequestMethod.POST })
	public String send(Model m,HttpServletRequest request,  
	        HttpServletResponse response) {
		List<LgType> list = lgTypeService.getAllType();
		m.addAttribute("lgTypeList", list);
		return "manage/send";
	}
	
	@RequestMapping("/manage/viewBlog/{id}")
	public String viewBlog(Model model, @PathVariable("id")Integer id) {
		LgBlog lgBlog = lgBlogService.getLgBlogById(id);
		System.out.println("content=" + lgBlog.getBlogContent());
		model.addAttribute("lgBlog", lgBlog);
		return "manage/viewBlog";
	}
	
	@Transactional
	@RequestMapping("/manage/delBlog/{id}")
	public String delBlog(Model model, @PathVariable("id")Integer id) {
		logger.info("开始删除博客",id);
		try {
			LgBlog lgBlog = lgBlogService.getLgBlogById(id);
			String picPath = lgBlog.getBlogPicture();
			String content = lgBlog.getBlogContent();
			Document doc = Jsoup.parse(content);
			Elements elements = doc.getElementsByTag("img");
			List<String> list = new ArrayList<String>();
			for (Element element: elements) {
				String imgSrc = element.attr("src");
				list.add(imgSrc);
				System.out.println(imgSrc);
			}
			File file = null;
			for (String str : list) {
				//C:\\project\\tomcat8\\webapps\\New_LgBlog
				file = new File("E:\\workspace\\New_LgBlog\\src\\main\\webapp" + str);
				if (file.exists()) {
					file.delete();
				}
			}
			file = new File("E:\\workspace\\New_LgBlog\\src\\main\\webapp"+picPath);
			if (file.exists()) {
				file.delete();
			}
			lgUpvoteService.deleteLgUpvoteByBlogId(id);
			lgClickService.delete(id);
			lgRecommendService.delRecommendByBlogId(id);
			lgReplyService.deleteReplyByBlogId(id);
			lgBlogService.deleteLgBlog(id);
		} catch (Exception e) {
			logger.info("删除博客失败",e);
		}
		return "redirect:/manage/allArticle?pageNum=1&pageSize=10";
	}
	
	@RequestMapping(value="/manage/send/article",method=RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	@Transactional
	public String sendArtilce(Model model, @RequestBody LgBlog lgBlog,HttpServletRequest request, HttpServletResponse response) {
		logger.info("发表文章");
		System.out.println("picture：" + lgBlog.getBlogPicture());
		JSONObject json = new JSONObject();
		try{
			lgBlog.setBlogAuthor("刘明宇");
			lgBlog.setBlogCreatetime(new Date());
			lgBlog.setBlogClickCount(0);
			lgBlog.setBlogReplyCount(0);
			lgBlog.setBlogUpvoteCount(0);
			lgBlogService.addLgBlog(lgBlog);
			
			json.put("result", "ok");
			return json.toString();
		} catch (Exception e) {
			logger.error("发表文章失败");
		}
		json.put("result", "error");
		return json.toString();
	}
	
	@RequestMapping(value="/manage/allArticle",method={RequestMethod.GET,RequestMethod.POST})
	public String allArticle(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNumber, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try{
			PageHelper.startPage(request);
			List<LgBlog> lgBlogList = lgBlogService.getAllLgBlog();
			PageInfo<LgBlog> pageInfo = new PageInfo<LgBlog>(lgBlogList);
			model.addAttribute("page", pageInfo);
			return "manage/allArticle";
		} catch(Exception e) {
			logger.info("分页查询类型失败");
			model.addAttribute("err", "查询数据失败");
		}
		return "manage/allArticle";
	}
	
	@RequestMapping("/manage/toModify/{id}")
	public String toModify(Model model, @PathVariable("id")Integer id) {
		List<LgType> list = lgTypeService.getAllType();
		LgBlog lgBlog = lgBlogService.getLgBlogById(id);
		model.addAttribute("lgBlog", lgBlog);
		model.addAttribute("lgTypeList", list);
		return "manage/modifyBlog";
	}
	
	@RequestMapping(value="/manage/allRecommend",method={RequestMethod.GET,RequestMethod.POST})
	public String allRecommend(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNumber, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize) {
		logger.info("分页查询推荐文章信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try{
			PageHelper.startPage(request);
			List<LgRecommend> lgRecommendList = lgRecommendService.getAllRecommend();
			PageInfo<LgRecommend> pageInfo = new PageInfo<LgRecommend>(lgRecommendList);
			model.addAttribute("page", pageInfo);
			return "manage/allRecommend";
		} catch(Exception e) {
			logger.info("分页查询类型失败");
			model.addAttribute("err", "查询数据失败");
		}
		return "manage/allRecommend";
	}
	@Transactional
	@RequestMapping(value="/manage/modify/article",method=RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public String modifyArtilce(Model model, @RequestBody LgBlog lgBlog,HttpServletRequest request, HttpServletResponse response) {
		logger.info("修改文章开始");
		System.out.println("picture：" + lgBlog.getBlogPicture());
		JSONObject json = new JSONObject();
		int blogId = lgBlog.getId();
		try{
			LgRecommend lgRecommend = lgRecommendService.getARecommend(blogId);
			if (lgRecommend != null) {
				if (lgRecommend.getBlogTitle() != lgBlog.getBlogTitle()) {
					lgRecommend.setBlogTitle(lgBlog.getBlogTitle());
					lgRecommendService.updateLgRec(lgRecommend);
				}
			}
			LgBlog blog = new LgBlog();
			blog = lgBlogService.getLgBlogById(blogId);
			lgBlog.setBlogClickCount(blog.getBlogClickCount());
			lgBlog.setBlogReplyCount(blog.getBlogReplyCount());
			lgBlog.setBlogUpvoteCount(blog.getBlogUpvoteCount());
			lgBlog.setBlogAuthor("刘明宇");
			lgBlog.setBlogCreatetime(new Date());
			lgBlogService.updateLgBlog(lgBlog);
			json.put("result", "ok");
			return json.toString();
		} catch (Exception e) {
			logger.error("修改文章失败");
		}
		json.put("result", "error");
		return json.toString();
	}
}
