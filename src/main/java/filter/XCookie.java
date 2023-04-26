package filter;

import javax.servlet.http.Cookie;

public class XCookie {
	public static void add(String name , String value , int hours) {
		Cookie cookie = new Cookie(name,value);
		cookie.setMaxAge(hours*60*60);
		cookie.setPath("/");
		RRshare.response().addCookie(cookie);
	}
	
	public static String get (String name , String defautValue) {
		Cookie[] cookies = RRshare.request().getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equalsIgnoreCase(name)) {
					return c.getValue();
				}
			}
		}
		return defautValue;
	}
	
	public static void remove(String name) {
		Cookie[] cookies = RRshare.request().getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equalsIgnoreCase(name)) {
					add(name, null, 0);
				}
			}
		}
	}
}
