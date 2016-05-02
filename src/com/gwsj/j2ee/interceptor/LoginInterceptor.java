package com.gwsj.j2ee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gwsj.j2ee.Constant.Constant;

public class LoginInterceptor implements HandlerInterceptor {

	private static final String[] IGNORE_URIS = { "/LibrarySystemForGWSJ/",
			"/LibrarySystemForGWSJ/register", "/LibrarySystemForGWSJ/index",
			"/LibrarySystemForGWSJ/index.html",
			"/LibrarySystemForGWSJ/login.jsp", "/LibrarySystemForGWSJ/login",
			"/css/", "/images/", "/js/", "/lib/" };

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String cxtPath = request.getContextPath();
		String url = request.getRequestURI();
		for (String param : IGNORE_URIS) {
			if (StringUtils.contains(param, url)) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			String session = (String) request.getSession().getAttribute(
					Constant.SESSION_USER);
			if (StringUtils.isEmpty(session)) {
				if ("XMLHttpRequest".equalsIgnoreCase(request
						.getHeader("x-requested-with"))) {
					response.setStatus(5000);
					return true;
				} else {
					response.sendRedirect(cxtPath + "/index.html");
				}
			} else {
				flag = true;
			}

		}
		return flag;

	}

}
