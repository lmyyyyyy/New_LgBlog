package me.lgblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lgblog.pojo.LgType;
import me.lgblog.service.LgTypeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class LgTypeController {

	private Logger logger = LoggerFactory.getLogger(LgTypeController.class);
	
	@Autowired
	private LgTypeService lgTypeService;
	
	@RequestMapping("/manage/toAddType")
	public String toAddType() {
		return "manage/toAddType";
	}
	
	@RequestMapping(value="/manage/allType", method = {RequestMethod.GET,RequestMethod.POST})
	public String allType(HttpServletRequest req, HttpServletResponse response, Model model, @RequestParam(defaultValue="0",required=false)Integer pageNumber, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PageHelper.startPage(req);
			List<LgType> lgTypeList = lgTypeService.getAllType(pageNumber, pageSize);
			PageInfo<LgType> pageInfo = new PageInfo<LgType>(lgTypeList);
			model.addAttribute("page", pageInfo);
			return "manage/allType";
		} catch (Exception e) {
			logger.info("分页查询类型失败");
			model.addAttribute("err", "查询数据失败");
		}
		return "manage/allType";
	}
	
	@RequestMapping(value="manage/addType", method=RequestMethod.POST)
	public ModelAndView addType(LgType lgType) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/manage/allType");
		lgTypeService.addType(lgType);
		return modelAndView;
	}
}
