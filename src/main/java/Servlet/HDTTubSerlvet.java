package Servlet;


import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.AnLa.NET.Email;
import com.AnLa.NET.RandomORG;

import DAO.FavoriteDAO;

//import com.AnLa.NET.Email;

import DAO.HistoryDAO;
import DAO.ReportDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import DAO.ViewDAO;
import Utils.*;
import filter.XCookie;
import modal.Favorite;
import modal.History;
import modal.Users;
import modal.Video;
import modal.Views;

/**
 * Servlet implementation class HDTTubSerlvet
 */
@WebServlet({ "/HDTTube/index", "/HDTTube/signout", "/HDTTube/signin", "/HDTTube/signup", "/HDTTube/home/*",
		"/HDTTube/video=/*", "/HDTTube/edit/*", "/HDTTube/edit/updateuser/*", "/HDTTube/edit/deleteuser/*",
		"/HDTTube/videomanager/*", "/HDTTube/reports", "/HDTTube/videomanager/create/*",
		"/HDTTube/videomanager/update/*", "/HDTTube/videomanager/delete/*", "/HDTTube/history",
		"/HDTTube/changepassword" })
public class HDTTubSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Video> listVD = new ArrayList<>();
	private static Email SMTP = new Email("dangthehuh2903@gmail.com", "");

	@Override
	public void destroy() {
		jdbcHelper.shutDown();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	VideoDAO vdDAO = new VideoDAO();
//    	Video vd= new Video();
//    	req.setCharacterEncoding("UTF-8");
//    	resp.setCharacterEncoding("UTF-8");
//    	req.setAttribute("item", vdDAO.findAll());
//    	req.getRequestDispatcher("/JSPfile/user/LayoutUser.jsp").forward(req, resp);
		String uri = req.getRequestURI();
		Users us = (Users) req.getSession().getAttribute("user");
		if (uri.contains("index")) {
			System.out.println("index");
			this.doIndex(req, resp);
		} else if (uri.contains("signin")) {
			System.out.println("sign in console");
			this.doSignIn(req, resp);
		} else if (uri.contains("signup")) {
			req.setAttribute("view", "/JSPfile/login/layoutSignUp.jsp");
			this.doSignUp(req, resp);
		} else if (uri.contains("home")) {
			if (us != null) {
				this.doHome(req, resp);
			}
//				req.getRequestDispatcher("../JSPfile/user/LayoutUser.jsp").forward(req, resp);	
		} else if (uri.contains("video=")) {
			this.doVideoIndex(req, resp);
		} else if (uri.contains("edit")) {
			this.doEdit(req, resp);
		} else if (uri.contains("videomanager")) {
			this.doVideoManager(req, resp);
		} else if (uri.contains("signout")) {
			this.doSignOut(req, resp);
		} else if (uri.contains("history")) {
			this.doHistory(req, resp);
		} else if (uri.contains("changepassword")) {
			 this.doChangePassWord(req, resp);
		} else if(uri.contains("reports")) {
			this.doReport(req,resp);
		}
//		req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, resp);
	}

	private void doReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String id ="";
		
		String TabReport = req.getParameter("TabReport");
		if(TabReport==null) TabReport = "1";
		req.setAttribute("TabReport", TabReport);
			
		if(TabReport.equals("1")) {
			req.setAttribute("RpVdLike", VideoDAO.findAll());
		}else if(TabReport.equals("2")) {
			id=req.getParameter("videoId");
			req.setAttribute("fvrt", FavoriteDAO.findByIVideo(id));
		}else if(TabReport.equals("3")) {
			id=req.getParameter("videoId");
			req.setAttribute("videoId", id);
			System.out.println(id);
			req.setAttribute("report", ReportDAO.findListReport(id));	
		}
		
		req.setAttribute("titleVideo", VideoDAO.findAll());
		req.setAttribute("view", "/JSPfile/admin/report.jsp");
		req.getRequestDispatcher("/JSPfile/admin/LayoutAdmin.jsp").forward(req, resp);
	}

	private void doChangePassWord(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {			
		Users us = (Users) req.getSession().getAttribute("user");
		String OTP = (String) req.getSession().getAttribute("OTPUser");
		if(OTP == null) {
			OTP = RandomORG.getInteger(111111, 999999, 10);
			req.getSession().setAttribute("OTPUser", OTP);
			String mail = us.getEmail();
			SMTP.setEmail("OTP verify", OTP);
			System.out.println(OTP);
			new Thread() { @Override public void run() {
				try{ SMTP.sendEmailTo(mail); System.out.println("gui mail toi " + mail); }
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("loi gui mail");
	            	req.setAttribute("content", "Hông thể gửi email về tài khoản, vui lòng thử lại sau !");
	            }
	        }}.start();
		}
		
		
		String method = req.getMethod();
		if (method.equals("POST")) {
			String confirm = req.getParameter("confirmnewpass");
			String newpass = req.getParameter("newpass");
			System.out.println(newpass);
			if(newpass.equals(confirm)) {
				us.setPassword(newpass);
				try {
					us=UserDAO.update(us);		
					req.setAttribute("message", "Change password success");
				}catch(Exception e) {
					req.setAttribute("message", "Change password fail");
				}
			}else {
				req.setAttribute("message", "Confirm password doesn't match new password");
			}
		}
		req.setAttribute("view", "/JSPfile/login/layoutChangePass.jsp");
		req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, resp);
	}


	private void doHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users us = (Users) req.getSession().getAttribute("user");
		List<History> h =  HistoryDAO.findAllByIdUser(us.getId());
		req.setAttribute("ArrayLichSu",h);		
		req.setAttribute("tab1", "/JSPfile/user/tab2.jsp");
		req.getRequestDispatcher("/JSPfile/user/LayoutUser.jsp").forward(req, resp);
	}

	private void doSignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		req.getSession().removeAttribute("user");
		XCookie.remove("cookieUS");
		req.getSession().setAttribute("OTPUser",null);
		req.setAttribute("view", "/JSPfile/login/layoutSignIn.jsp");
		req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, resp);
	}

	private void doVideoManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String method = req.getMethod();
		String idVideo = uri.substring(uri.lastIndexOf("/") + 1);
		Video video = new Video();
		req.getSession().setAttribute("video", video);
//		System.out.println(idVideo);
		if (method.equals("POST")) {
			try {
				BeanUtils.populate(video, req.getParameterMap());
				if (uri.contains("create")) {
					// System.out.println(video.getId());
					if (video.getId().isEmpty()) {
						req.setAttribute("message", "insert fail");
					} else {
						this.doInsertVideo(req, resp, video);
					}
				} else if (uri.contains("update")) {
					this.doUpdateVideo(req, resp);
				} else if (uri.contains("delete")) {
					this.doDeleteVideo(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Video vdForm = new Video();
//		System.out.println(VideoDAO.findAll().get(2).getView().size());
//		req.getSession().setAttribute("video", vdForm);
		req.setAttribute("form", VideoDAO.findVideo(idVideo));
		req.setAttribute("vd", VideoDAO.findAll());
		req.setAttribute("sizeVideo", VideoDAO.findAll().size());
		req.setAttribute("view", "/JSPfile/admin/videomanager.jsp");
		req.getRequestDispatcher("/JSPfile/admin/LayoutAdmin.jsp").forward(req, resp);
	}

	private void doDeleteVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video vd = (Video) req.getSession().getAttribute("video");
		if (vd.getId() == null || vd.getId().isEmpty()) {
			req.setAttribute("message", "Somethings were swrong");
		} else {
			VideoDAO.delete(vd.getId());
		}
	}

	private void doUpdateVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("update func");
		Video vd = (Video) req.getSession().getAttribute("video");
		System.out.println(vd.getId());
		if (vd.getId().isEmpty() || vd.getId() == null) {
			req.setAttribute("message", "Somethings were swrong");
		} else {
			try {
				BeanUtils.populate(vd, req.getParameterMap());
				String poster = "https://i3.ytimg.com/vi/" + vd.getId() + "/maxresdefault.jpg";
				vd.setPoster(poster);
				VideoDAO.update(vd);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		req.setAttribute("view", "/JSPfile/admin/videomanager.jsp");
//		req.getRequestDispatcher("/JSPfile/admin/LayoutAdmin.jsp").forward(req, resp);
	}

	private void doInsertVideo(HttpServletRequest req, HttpServletResponse resp, Video video)
			throws ServletException, IOException {
		String poster = "https://i3.ytimg.com/vi/" + video.getId() + "/maxresdefault.jpg";
		video.setPoster(poster);
		VideoDAO.create(video);
	}

	private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		String idUser = "";
//		Users us = (Users)req.getSession().getAttribute("user");
		UserDAO udao = new UserDAO();
		Users us = new Users();
		us = UserDAO.findUser(id);

//		if(!us.getRole()) {
//			req.setAttribute("alert", "You not admin");
//		}else {
		if (method.equals("POST")) {
			if (uri.contains("updateuser")) {
//					this.doUpdateUser(req,resp);
				System.out.println("update user");
				String uriU = req.getRequestURI();
				idUser = uriU.substring(uriU.lastIndexOf("/") + 1);
				try {
					BeanUtils.populate(us, req.getParameterMap());
					UserDAO.update(us);
				} catch (IllegalAccessException | InvocationTargetException e) {
					System.out.println("loi update");
					e.printStackTrace();
				}
			} else if (uri.contains("deleteuser")) {
				String uriU = req.getRequestURI();
				idUser = uriU.substring(uriU.lastIndexOf("/") + 1);
				try {
					BeanUtils.populate(us, req.getParameterMap());
					UserDAO.delete(us.getId());
				} catch (IllegalAccessException | InvocationTargetException e) {
					System.out.println("loi update");
					e.printStackTrace();
				}
				req.setAttribute("item", UserDAO.findAll());
				req.setAttribute("view", "/JSPfile/admin/usermanager.jsp");
				req.getRequestDispatcher("/JSPfile/admin/LayoutAdmin.jsp").forward(req, resp);
			}
		}
		req.setAttribute("us", us);
		req.setAttribute("item", UserDAO.findAll());
		req.setAttribute("usSize", UserDAO.findAll().size());
		req.setAttribute("view", "/JSPfile/admin/usermanager.jsp");
		req.getRequestDispatcher("/JSPfile/admin/LayoutAdmin.jsp").forward(req, resp);
	}

	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equals("POST")) {
			try {
				Users us = new Users();
				UserDAO dao = new UserDAO();
				BeanUtils.populate(us, req.getParameterMap());
				dao.create(us);
				req.setAttribute("message", "Signup Success");
				System.out.println("them thanh cong");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("them that bai");
				req.setAttribute("message", "Signup Fail");
			}
		}
		req.setAttribute("view", "/JSPfile/login/layoutSignUp.jsp");
		req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, resp);

	}

	private void doVideoIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String method = req.getMethod();
		String index = uri.substring(uri.lastIndexOf("/") + 1);
		Video vd = VideoDAO.findVideo(index);
		Users us = (Users) req.getSession().getAttribute("user");
		History h = new History();
		h.setUser(us);
		h.setVideo(vd);
		History lichSuXem = HistoryDAO.create(h);
		Views v = new Views();
		v.setUser(us);
		v.setVideo(vd);
		ViewDAO.create(v);
		
		if(method.equals("POST")) {
			Favorite f = new Favorite();
			f.setUser(us);
			f.setVideo(vd);
			FavoriteDAO.create(f);
			
		}
		req.setAttribute("numberLike", FavoriteDAO.findByIVideo(vd.getId()));
		req.setAttribute("ArrayLichSu", HistoryDAO.findAllByIdUser(us.getId()));
//		req.setAttribute("lichSuXem", lichSuXem);
		req.setAttribute("vd", vd);
		req.setAttribute("item", VideoDAO.findAll());
		req.getRequestDispatcher("/JSPfile/video/layoutvideo.jsp").forward(req, resp);
	}

	private void doHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexPage = req.getParameter("indexPage");
		if (indexPage == null) {
			indexPage = "1";
		}

		int index = Integer.parseInt(indexPage);
		req.getSession().getAttribute("user");
		int count = (int) VideoDAO.getCountVideo();
		int endPage = count / 6;
		if (count % 6 != 0) {
			endPage++;
		}

		List<Video> list = VideoDAO.findPage(index, 6);
		req.setAttribute("endPage", endPage);
		req.setAttribute("item", list);
		req.setAttribute("tab1", "/JSPfile/user/tab1.jsp");
		req.getRequestDispatcher("/JSPfile/user/LayoutUser.jsp").forward(req, resp);
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("username");
		String pass = req.getParameter("password");
		String method = req.getMethod();
		if (method.equals("POST")) {
			try {
				Users us = UserDAO.findUser(id, pass);
				if (us.getPassword().equals(pass)) {
					System.out.println("success");
					req.getSession().setAttribute("user", us);

					XCookie.add("cookieUS", us.getId() + "|" + hashPass.doHash(us.getPassword()),
							req.getParameter("chkCookie") != null ? 2 : 0);

//					req.getRequestDispatcher("../JSPfile/user/layoutUser.jsp").forward(req, resp);
					resp.sendRedirect("home");
					System.out.println("send redirect");
					return;
				} else {
					System.out.println("error password");
					req.setAttribute("view", "/JSPfile/login/layoutSignIn.jsp");
					req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				req.setAttribute("message", "fail to sign in");
				System.out.println("fail to sign in");
				e.printStackTrace();
			}
		}
		req.setAttribute("view", "/JSPfile/login/layoutSignIn.jsp");
		req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, resp);
	}

	private void doIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String method = req.getMethod();
//		Users us = (Users) req.getSession().getAttribute("user");
		req.setAttribute("view", "/JSPfile/login/layoutSignIn.jsp");
		req.getRequestDispatcher("/JSPfile/login/layoutIndex.jsp").forward(req, resp);
	}

}
