package me.lgblog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lgblog.pojo.LgBlog;
import me.lgblog.pojo.LgReply;
import me.lgblog.service.LgBlogService;
import me.lgblog.service.LgReplyService;
import me.lgblog.util.IPAddressUtil;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class LgReplyController {

	private Logger logger = LoggerFactory.getLogger(LgReplyController.class);
	
	@Autowired
	private LgReplyService lgReplyService;
	
	@Autowired
	private LgBlogService lgBlogService;
	
	@RequestMapping("/reply/send")
	@ResponseBody
	public String sendReply(@RequestBody LgReply lgReply, HttpServletRequest request, HttpServletResponse response){
		String ip = IPAddressUtil.getIpAddress(request);
		System.out.println("他的ip地址为：" + ip);
		logger.info("他想联系我",ip);
		JSONObject json = new JSONObject();
		String result = "ok";
		try {
			lgReply.setReplyCreatetime(new Date());
			if (lgReply.getReplyWebsite() == null || lgReply.getReplyWebsite().equals("")) {
				lgReply.setReplyWebsite("");
			}
			lgReply.setReplyIp(ip);
			LgBlog lgBlog = lgBlogService.getLgBlogById(lgReply.getLgBlogId());
			int replyCount = lgBlog.getBlogReplyCount();
			lgBlog.setBlogReplyCount(replyCount+1);
			lgBlogService.updateLgBlog(lgBlog);
			lgReplyService.addReply(lgReply);
			json.put("result", result);
			json.put("blogId", lgReply.getLgBlogId());
			return json.toString();
		} catch (Exception e) {
			logger.info("联系失败，怀疑有非法字符");
			json.put("result", "error");
		}
		return json.toString();
	}
	
	@RequestMapping("/manage/allReply")
	public String getAllReply(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNumber, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize) {
		logger.info("分页查询评论信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try{
			PageHelper.startPage(pageNumber,pageSize);
			List<LgReply> lgReplyList = lgReplyService.getAllReply();
			PageInfo<LgReply> pageInfo = new PageInfo<LgReply>(lgReplyList);
			model.addAttribute("page", pageInfo);
		} catch(Exception e) {
			logger.info("分页查询评论失败");
			model.addAttribute("err", "查询数据失败");
		}
		return "manage/allReply";
	}
	
	@RequestMapping("/manage/viewReply/{id}")
	public String viewReply(Model model, @PathVariable("id")Integer id) {
		LgReply lgReply = lgReplyService.getAReply(id);
		model.addAttribute("lgReply", lgReply);
		return "manage/viewReply";
	}
	
	@RequestMapping("/manage/delReply/{id}")
	public String delReply(Model model, @PathVariable("id")Integer id) {
		lgReplyService.deleteReplyById(id);
		return "redirect:/manage/allReply?pageNum=1&pageSize=10";
	}
}
