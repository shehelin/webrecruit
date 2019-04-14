package com.hl.recruit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hl.recruit.entity.UserEntity;
/**
 * 验证是否登录的 过滤器
 * @author soft02
 *
 */
public class AuthorityFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		//获取uri
		String uri = httpRequest.getRequestURI();
		String contentPath = httpRequest.getContextPath();

		boolean flag = uri.equals(contentPath + "/") || uri.contains("index")
				|| uri.contains("register")
				|| uri.contains("doRegister")
				|| uri.contains("login")
				|| uri.contains("/admin")
				|| uri.contains("doLogin")
				|| uri.contains("doAdminLogin")
				|| uri.contains("queryUserById")
				|| (uri.contains("/recruit") && !uri.endsWith("/recruit/my"))
				|| (uri.contains("/employeeJob")&& !(uri.endsWith("/employeeJob/employeeUser")
                        ||uri.endsWith("/employeeJob/employeeCompany")
                        ||uri.contains("/employeeJob/addEmployeeView")))
				|| (uri.contains("/company") && !uri.endsWith("/company/"))
				|| (uri.contains("/resume") && !uri.endsWith("/resume/"))
				|| (uri.contains("/areaDict"))
				|| uri.contains("control.jsp")
				|| (!uri.contains(".jsp") && uri.contains("."));
		if(flag){
			//放行
			chain.doFilter(httpRequest, httpResponse);
		}else{
			UserEntity user = (UserEntity) httpRequest.getSession().getAttribute("user");
			if(null != user){
				//放行
				chain.doFilter(httpRequest, httpResponse);
			}else{
				//没有登录，返回登录
				httpResponse.sendRedirect(contentPath + "/" + "propmt/control.jsp");
			}
			
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
