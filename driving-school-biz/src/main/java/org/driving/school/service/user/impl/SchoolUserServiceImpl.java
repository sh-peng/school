package org.driving.school.service.user.impl;

import org.driving.school.biz.user.SchoolUserBiz;
import org.driving.school.dal.model.SchoolUser;
import org.driving.school.service.user.SchoolUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

/**
 * 
 * @author pengcheng.yang
 *
 */
@Service
public class SchoolUserServiceImpl implements SchoolUserService {
	
	private Logger logger = LoggerFactory.getLogger(SchoolUserServiceImpl.class);
	
	@Autowired
	private SchoolUserBiz schoolUserBiz;
	
	/**
	 * @author pengcheng.yang
	 * @desc 分页查询学员信息
	 * @param record
	 * @return
	 */
	@Override
	public Page<SchoolUser> querySchoolUserInfoList(int pageNum, int pageSize, SchoolUser record) {
		return schoolUserBiz.querySchoolUserInfoList(pageNum, pageSize, record);
	}
	
	/**
	 * @author pengcheng.yang
	 * @desc 根据userId查询用户信息
	 * @param userId
	 * @return
	 */
	@Override
	public SchoolUser querySchoolUserInfoByUserId(Integer userId) {
		return schoolUserBiz.selectByPrimaryKey(userId);
	}
	
	/**
	 * @author yangpengcheng
	 * @desc 新增学员信息
	 * @param record
	 * @return
	 */
	@Override
	public boolean insertSchoolUserInfo(SchoolUser record) {
		logger.info("插入学员信息：{}",record);
		int result = schoolUserBiz.insertSelective(record);
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * @author yangpengcheng
	 * @desc 登录验证用户信息
	 * @param record
	 * @return
	 */
	@Override
	public SchoolUser querySchoolInfo(String userName) {
		return schoolUserBiz.querySchoolInfo(userName);
	}
	
}
