package org.rainbow.interceptor;

import org.rainbow.pojo.TbAccount;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-02
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("尚未登录，跳转登录页面");
			response.sendRedirect("/login");
		}else {
			return true;
		}
		return false;
	}

}
