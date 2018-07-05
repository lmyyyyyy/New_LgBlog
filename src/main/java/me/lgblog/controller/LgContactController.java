package me.lgblog.controller;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lgblog.pojo.LgContact;
import me.lgblog.service.LgContactService;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class LgContactController {

	private Logger logger = LoggerFactory.getLogger(LgContactController.class);
	
	@Autowired
	private LgContactService lgContactService;
	
	@RequestMapping("/contact/send")
	@ResponseBody
	public String sendContact(@RequestBody LgContact lgContact, HttpServletRequest request, HttpServletResponse response) {
		String ip = IPAddressUtil.getIpAddress(request);
		System.out.println("他的ip地址为：" + ip);
		logger.info("他想联系我",ip);
		JSONObject json = new JSONObject();
		String result = "ok";
		if (lgContact.getContactName() == null || lgContact.getContactName().equals("")) {
			result = "name is null";
			json.put("result", result);
			return json.toString();
		} 
		if (lgContact.getContactMessage() == null || lgContact.getContactName().equals("")) {
			result = "message is null";
			json.put("result", result);
			return json.toString();
		}
		Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher matcher = emailPattern.matcher(lgContact.getContactEmail());
		if (!matcher.find()) {
			result = "email is error";
			json.put("result", result);
			return json.toString();
		}
		try {
			lgContact.setContactCreatetime(new Date());
			lgContactService.addContact(lgContact);
			json.put("result", result);
			return json.toString();
		} catch (Exception e) {
			logger.info("联系失败，怀疑有非法字符");
			json.put("result", "error");
		}
		return json.toString();
	}
	
	@RequestMapping(value="/manage/allContact",method={RequestMethod.GET,RequestMethod.POST})
	public String getContacts(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(defaultValue="0",required=false)Integer pageNumber, @RequestParam(value="limit",defaultValue="10",required=false)Integer pageSize) {
		logger.info("分页查询邮件信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try{
			PageHelper.startPage(request);
			List<LgContact> lgContactList = lgContactService.getAllLgContact();
			PageInfo<LgContact> pageInfo = new PageInfo<LgContact>(lgContactList);
			model.addAttribute("page", pageInfo);
		} catch(Exception e) {
			logger.info("分页查询邮件失败",e);
			model.addAttribute("err", "查询数据失败");
		}
		return "manage/allContact";
	}
	
	@RequestMapping("/manage/viewContact/{id}")
	public String viewContact(Model model, @PathVariable("id")Integer id) {
		LgContact lgContact = lgContactService.getALgContact(id);
		model.addAttribute("lgContact", lgContact);
		return "manage/viewContact";
	}
	
	@RequestMapping("/manage/delContact/{id}")
	public String delContact(Model model, @PathVariable("id")Integer id) {
		lgContactService.delContact(id);
		return "redirect:/manage/allContact?pageNum=1&pageSize=10";
	}
}
