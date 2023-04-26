package console;

import java.io.IOException;

import DAO.HistoryDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import Utils.*;
import filter.XCookie;
import modal.Users;
import modal.Video;

public class NewFile {

	public static void main(String[] args) {
//		try {
//			Users us = UserDAO.findUser("admin", "123");
//			if (us.getPassword().equals("123")) {
//				System.out.println("send redirect");
//				return;
//			} else {
//				System.out.println("error password");
//			}
//		} catch (Exception e) {
//			System.out.println("fail to sign in");
//			e.printStackTrace();
//		}
		
		System.out.println(VideoDAO.findAllid().size());
		
	}

}
