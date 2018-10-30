package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import Bean.Bean3;
import dao.DAO;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
			if(session.getAttribute("login_db") == null) {
				  response.sendRedirect("/Example/LoginServletDB");
				  return;
			}
		String s_id=request.getParameter("id");
		if(s_id == null){
			response.sendRedirect("/Example/Read");
		}else{
			DAO dao=new DAO();
			Bean3 Bean = null;
			try {
				Bean = dao.findOne(Integer.parseInt(s_id));
			} catch (NumberFormatException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			request.setAttribute("Bean",Bean);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/update.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("submit");
		  if ("戻る".equals(btn)) {
			  response.sendRedirect("/Example/Read");
			  return;
		  }
		  String Error = null;
			Error = ("NoError");
		String login_id=request.getParameter("login_id");
		String password=request.getParameter("password");
		String passwordConf = request.getParameter("passwordConf");
		String name=request.getParameter("name");
		String birth_date=request.getParameter("birth_date");
		String id=request.getParameter("id");

		if(password.equals( "")){
			Error = ("Error");
		}
		if(passwordConf.equals( "")) {
			Error =("Error");
		}
		if(name.equals( "")) {
			Error =("Error");
		}
		if(birth_date.equals( "")) {
			Error = ("Error");
		}
		if(!(password.equals(passwordConf))) {
			Error = ("PassError");
		}
		if(Error.equals("Error")){
			Bean3 Bean =new Bean3(Integer.parseInt(id),login_id,password,name,birth_date);
			DAO dao=new DAO();
			try {
				dao.updateOne2(Bean);
			} catch (NamingException e) {

				e.printStackTrace();
			}

			response.sendRedirect("/Example/Read");
			 return;



		}
		if(Error.equals("NoError")){
		String source = password;
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		password = result;

		Bean3 Bean =new Bean3(Integer.parseInt(id),login_id,password,name,birth_date);
		DAO dao=new DAO();
		try {
			dao.updateOne(Bean);
		} catch (NamingException e) {

			e.printStackTrace();
		}

		response.sendRedirect("/Example/Read");
		 return;
		}else {
			Error = ("NoError");
			Bean3 Bean = new Bean3(Integer.parseInt(id),login_id,password,name,birth_date);
		request.setAttribute("Bean",Bean);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/updateNG.jsp");
		rd.forward(request, response);
		  return;
}
		}

	}

