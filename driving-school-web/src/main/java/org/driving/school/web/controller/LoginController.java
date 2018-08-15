package org.driving.school.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.driving.school.common.utils.Constants;
import org.driving.school.common.utils.MD5Util;
import org.driving.school.common.utils.SessionUtil;
import org.driving.school.dal.model.SchoolUser;
import org.driving.school.service.user.SchoolUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Autowired
	private SchoolUserService schoolUserService;
	
//	@RequestMapping("/")
//	public String loginIndex(){
//		return "/login";
//	}
	
	@RequestMapping("/login")
	public String userLogin(Model model) {
		return "/login";
	}
	
	@RequestMapping("/loginAction")
	@ResponseBody
	public String loginAction(Model model,String userName,String userPwd,HttpServletRequest request, HttpServletResponse response) {
		SchoolUser user = schoolUserService.querySchoolInfo(userName);
		if (user == null) {
			return Constants.NOT_USER_ERROR;
		}else if (!user.getPwd().equals(MD5Util.getMD5String(userPwd))) {
			return Constants.NOT_PWD_ERROR;
		}
		SessionUtil.setSessionUtil(request, response, Constants.USER_SESSION,user);
		return Constants.SUCCESS;
	}
	
	@RequestMapping("/outLoginAction")
	@ResponseBody
	public String outLoginAction(HttpServletRequest request, HttpServletResponse response){
		boolean bool = SessionUtil.removeSessionUtil(request, response, Constants.USER_SESSION);
		if (bool == true) {
			return Constants.SUCCESS;
		}
		return Constants.ERROR;
	}
	
	@RequestMapping("/index")
	public String index(Model model,HttpServletRequest request, HttpServletResponse response) {
		SchoolUser user = (SchoolUser) SessionUtil.getSessionUtil(request, response, Constants.USER_SESSION);
		model.addAttribute("user", user);
		return "/index";
	}
	
	@RequestMapping("/welcome")
	public String menu(){
		return "/welcome";
	}
	
	
}
