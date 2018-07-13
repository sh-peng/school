package org.driving.school.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.driving.school.common.utils.Constants;
import org.driving.school.common.utils.SessionUtil;
import org.driving.school.dal.model.SchoolUser;
import org.driving.school.service.user.SchoolUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;

/**
 * @author pengcheng.yang
 * @date 2018-07-06
 *
 */
@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private SchoolUserService schoolUserService;
	
	@RequestMapping("/queryUserInfoList")
	public String queryUserInfoList(Model model,Integer pageNum,Integer pageSize,SchoolUser record ,HttpServletRequest request ,HttpServletResponse response) {
		SchoolUser user = (SchoolUser) SessionUtil.getSessionUtil(request, response, Constants.USER_SESSION);
		Page<SchoolUser> schoolUser = schoolUserService.querySchoolUserInfoList(pageNum == null?1:pageNum,pageSize == null?10:pageSize,record);
		logger.info("{}:进行数据查询--queryUserInfoList",user.getUserName());
		model.addAttribute("schoolUserList", schoolUser.toPageInfo());
		return "/user/user_info";
	}
	@RequestMapping("/queryStudentInfoListAjax")
	public String queryStudentInfoListAjax(Model model,Integer pageNum,Integer pageSize,SchoolUser record ,HttpServletRequest request ,HttpServletResponse response) {
		SchoolUser user = (SchoolUser) SessionUtil.getSessionUtil(request, response, Constants.USER_SESSION);
		Page<SchoolUser> schoolUser = schoolUserService.querySchoolUserInfoList(pageNum == null?1:pageNum,pageSize == null?10:pageSize,record);
		logger.info("{}:进行数据查询--queryStudentInfoListAjax",user.getUserName());
		model.addAttribute("schoolUserList", schoolUser.toPageInfo());
		return "/user/user_info_list";
	}
	
	@RequestMapping("/querStudentInfoByUserId")
	public String querStudentInfoByUserId(Model model,Integer userId) {
		SchoolUser schoolUser = schoolUserService.querySchoolUserInfoByUserId(userId);
		model.addAttribute("schoolUser", schoolUser);
		return "";
	}

}
