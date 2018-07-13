package org.driving.school.biz.user;

import org.driving.school.dal.model.SchoolUser;
import com.github.pagehelper.Page;

public interface SchoolUserBiz {
	int deleteByPrimaryKey(Integer userId);

    int insert(SchoolUser record);

    int insertSelective(SchoolUser record);

    SchoolUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SchoolUser record);

    int updateByPrimaryKey(SchoolUser record);
    
    Page<SchoolUser> querySchoolUserInfoList(int pageNum,int pageSize,SchoolUser record);
    
    SchoolUser querySchoolInfo(String userName);
    
}
