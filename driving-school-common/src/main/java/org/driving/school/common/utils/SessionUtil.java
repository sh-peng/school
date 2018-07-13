package org.driving.school.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc 获取session信息
 * @author yangpengcheng
 * @date 2018-07-13
 *
 */
public class SessionUtil {
	
	public static Object getSessionUtil(HttpServletRequest request, HttpServletResponse response,String key){
		Object obj = request.getSession().getAttribute(key);
		if (obj != null) {
			return obj;
		}
		return null;
	}
	
	public static void setSessionUtil(HttpServletRequest request, HttpServletResponse response,String key,Object value){
		request.getSession().setAttribute(key, value);
	}
	
	public static boolean removeSessionUtil(HttpServletRequest request, HttpServletResponse response,String key){
		request.getSession().removeAttribute(key);
		Object obj = request.getSession().getAttribute(key);
		if (obj != null) {
			return false;
		}
		return true;
	}
}
