package org.driving.school.biz.user.impl;

import org.driving.school.biz.user.SchoolUserBiz;
import org.driving.school.dal.mapper.SchoolUserMapper;
import org.driving.school.dal.model.SchoolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class SchoolUserBizImpl implements SchoolUserBiz {
	
	@Autowired
	private SchoolUserMapper schoolUserMapper;

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		return schoolUserMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(SchoolUser record) {
		return schoolUserMapper.insert(record);
	}

	@Override
	public int insertSelective(SchoolUser record) {
		return schoolUserMapper.insertSelective(record);
	}

	@Override
	public SchoolUser selectByPrimaryKey(Integer userId) {
		return schoolUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(SchoolUser record) {
		return schoolUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SchoolUser record) {
		return schoolUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public Page<SchoolUser> querySchoolUserInfoList(int pageNum, int pageSize, SchoolUser record) {
		//github分页插件
		PageHelper.startPage(pageNum, pageSize);
		return schoolUserMapper.querySchoolUserInfoList(record);
	}

	@Override
	public SchoolUser querySchoolInfo(String userName) {
		return schoolUserMapper.querySchoolInfo(userName);
	}
	

}
