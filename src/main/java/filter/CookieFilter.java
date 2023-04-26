package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Utils.hashPass;
import modal.Users;
import modal.Video;

/**
 * Servlet Filter implementation class CookieFilter
 */
@WebFilter({"/HDTTube/index","/HDTTube/home","/HDTTube/changepassword","/HDTTube/history"})
public class CookieFilter extends HttpFilter implements Filter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Users user = (Users)req.getSession().getAttribute("user");
		System.out.println("filter cookie");
		String error="", cookievalue = XCookie.get("cookieUS", null);
		if(user != null) chain.doFilter(req, res);
		else if(cookievalue != null) {
			int index = cookievalue.indexOf("|");
			String id = cookievalue.substring(0, index),
					ps = cookievalue.substring(index+1);
			Users userCK = UserDAO.findUser(id);
			if(userCK != null && hashPass.doHash(userCK.getPassword()).equals(ps)) {
				req.getSession().setAttribute("user", userCK);
				chain.doFilter(req, res);
			} else res.sendRedirect("signin");
		} else res.sendRedirect("signin");
	}

}
