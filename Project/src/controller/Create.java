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

import Bean.Bean2;
import Bean.Bean7;
import dao.DAO;

@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
			if(session.getAttribute("login_db") == null) {
				  response.sendRedirect("/Example/LoginServletDB");
				  return;
			}

		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/Create.jsp");
		rd.forward(request, response);
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
			if(login_id.equals( "")) {
				Error = ("Error");
				}
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
				Error = ("Error");
			}


			int i = 0;
			if(Error.equals("NoError")){
			String source = password;
			Charset charset = StandardCharsets.UTF_8;
			String algorithm = "MD5";
			byte[] bytes = null;
			try {
				bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			} catch (NoSuchAlgorithmException e1) {

				e1.printStackTrace();
			}
			String result = DatatypeConverter.printHexBinary(bytes);
			password = result;
			Bean2 Bean =new Bean2(login_id,password,passwordConf,name,birth_date);


			DAO dao=new DAO();
			try {
			i = dao.insertOne(Bean);
			} catch (NamingException e) {
				e.printStackTrace();
				}
			if(i == 0) {
				Bean7 Bean7 = new Bean7(login_id,name,birth_date);
				request.setAttribute("Bean7",Bean7);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/CreateNG.jsp");
			rd.forward(request, response);
			  return;
			}

			response.sendRedirect("/Example/Read");



			}else {
				Error = ("NoError");
				Bean7 Bean7 = new Bean7(login_id,name,birth_date);
			request.setAttribute("Bean7",Bean7);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/CreateNG.jsp");
			rd.forward(request, response);
			  return;
	}
}
}

