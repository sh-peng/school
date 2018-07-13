package org.driving.school.user;

import java.util.Date;
import java.util.List;

import org.driving.school.common.utils.MD5Util;
import org.driving.school.dal.model.SchoolUser;
import org.driving.school.service.user.SchoolUserService;
import org.driving.school.test.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
/**
 * @desc 学员信息相关测试工具类
 * @author apple
 *
 */
public class SchoolUserTest  extends AbstractTest{
	
	private Logger logger = LoggerFactory.getLogger(SchoolUserTest.class);
	
	@Autowired
	private SchoolUserService schoolUserService;
	
	@Test
	public void inserSchoolUserInfo() {
		SchoolUser record = new SchoolUser();
		record.setUserName("杨教练");
		record.setEmail("drivingschool-yang@163.com");
		record.setPwd("12345678");
		record.setSex("男");
		record.setCancelFlag("Y");
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
//		logger.info("插入信息日志打印{}",false);
//		boolean result = schoolUserService.insertSchoolUserInfo(record);
//		logger.info("插入信息日志打印{}",result);
//		System.out.println("+++++++========::::"+result);
	}
	
	@Test
	public void querySchoolUserInfoByUserId() {
//		System.out.println(schoolUserService.querySchoolUserINfoByUserId(1));
		/*SchoolUser record = new SchoolUser();
		record.setUserName("杨");
		record.setSex("女");
		Page<SchoolUser> pageInfo = schoolUserService.querySchoolUserInfoList(1, 2, record);
		List<SchoolUser> list = pageInfo.toPageInfo().getList(); 
		for (SchoolUser schoolUser : list) {
			System.out.println(schoolUser);
		}*/
		
		System.out.println(MD5Util.getMD5String("12345678"));
	}
}
