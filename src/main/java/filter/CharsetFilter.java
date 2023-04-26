//package filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//
///**
// * Servlet Filter implementation class CharsetFilter
// */
//@WebFilter("/*")
//public class CharsetFilter extends HttpFilter implements Filter {    
//	@Override
//	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		req.setCharacterEncoding("UTF-8");
//		res.setCharacterEncoding("UTF-8");
//		RRshare.add(req, res);
//		chain.doFilter(req, res);
//		RRshare.remove(req, res);
//	}
//}
