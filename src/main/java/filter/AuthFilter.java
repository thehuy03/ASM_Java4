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

import org.apache.catalina.connector.Response;

import DAO.UserDAO;
import modal.Users;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter({ "/HDTTube/*"})
public class AuthFilter extends HttpFilter implements Filter {

	
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
//		String uri = req.getRequestURI();
//		Users user = (Users)req.getSession().getAttribute("user");
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
//		String error ="";
		RRshare.add(req, res);
		chain.doFilter(req, res);
		RRshare.remove(req, res);
		
//		if(user==null || user.toString().isEmpty()) {
//			System.out.println("filter user null");
//			req.setAttribute("message", "Please sign in with admin account");
//			req.setAttribute("view", "/JSPfile/login/layoutSignIn.jsp");
//			req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, res);
//			error = res.encodeURL("Hãy đăng nhập");
//		}else if(!user.getRole()) {
//			System.out.println("filter user must be admin");
//			req.setAttribute("message", "Please sign in with admin account");
//			error = res.encodeURL("Please sign in with admin account");
//			req.setAttribute("view", "/JSPfile/login/layoutSignIn.jsp");
//			req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, res);
//		}
//		if(!error.isEmpty()) {
//			req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, res);
//		}else {
//			RRshare.add(req, res);
//			chain.doFilter(req, res);
//			RRshare.remove(req, res);
//			
////			chain.doFilter(req, res);
//		}
	}
	
}
