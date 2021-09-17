package com.simplilearn;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
   
		response.setContentType("text/html;charset=UTF-8");       
        String email = request.getParameter("username");
        String pass = request.getParameter("pass");
        
        if((email != null || pass != null) && email.equals("ashwin") && pass.equals("test"))
        {
        	chain.doFilter(request, response);//sends request to next resource
//        	RequestDispatcher rs = request.getRequestDispatcher("Welcome");
//            rs.forward(request, response);
        }
        else
        {
           RequestDispatcher rs = request.getRequestDispatcher("incorrect.html");
           rs.include(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
