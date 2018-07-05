package me.lgblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lgblog.pojo.LgBlog;
import me.lgblog.pojo.LgRecommend;
import me.lgblog.service.LgBlogService;
import me.lgblog.service.LgRecommendService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class LgRecommendController {

	private Logger logger = LoggerFactory.getLogger(LgRecommendController.class);
	
	@Autowired
	private LgRecommendService lgRecommendService;
	
	@Autowired
	private LgBlogService lgBlogService;
	
	@RequestMapping("/manage/recommend/{id}")
	public String addRecommend(Model model, @PathVariable("id")Integer id) {
		logger.info("推荐文章编号为",id);
		try{
			LgRecommend recommend = lgRecommendService.getARecommend(id);
			if (recommend == null) {
				LgBlog lgBlog = lgBlogService.getLgBlogById(id);
				LgRecommend lgRecommend = new LgRecommend();
				lgRecommend.setBlogId(id);
				lgRecommend.setBlogTitle(lgBlog.getBlogTitle());
				lgRecommendService.addRecommend(lgRecommend);
			}else {
				return "redirect:/manage/allArticle?pageNum=1&pageSize=10";
			}
		}catch (Exception e) {
			logger.info("推荐文章失败");
		}
		return "redirect:/manage/allArticle?pageNum=1&pageSize=10";
	}
	
	@RequestMapping("/manage/delRecommend/{id}")
	public String delRecommend(Model model, @PathVariable("id")Integer id){
		logger.info("删除该文章推荐:",id);
		try {
			lgRecommendService.delRecommend(id);
		}catch (Exception e) {
			logger.info("删除推荐文章失败",e);
		}
		return "redirect:/manage/allRecommend?pageNum=1&pageSize=10";
	}
	
	@RequestMapping(value="/manage/allRecommend")
	public String allRecommend(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNumber, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize) {
		logger.info("分页查询推荐列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try{
			PageHelper.startPage(request);
			List<LgRecommend> lgRecommendList = lgRecommendService.getAllRecommend();
			PageInfo<LgRecommend> pageInfo = new PageInfo<LgRecommend>(lgRecommendList);
			model.addAttribute("page", pageInfo);
			return "manage/allRecommend";
		} catch(Exception e) {
			logger.info("分页查询推荐信息失败",e);
			model.addAttribute("err", "查询数据失败");
		}
		return "manage/allRecommend";
	}
}
