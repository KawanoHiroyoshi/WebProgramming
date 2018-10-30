package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Bean5;
import Bean.Bean6;
import dao.DAO;

@WebServlet("/Retrieval")
public class Retrieval extends HttpServlet {
	private static final long serialVersionUID = 1L;






	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
			if(session.getAttribute("login_db") == null) {
				  response.sendRedirect("/Example/LoginServletDB");
				  return;
			}
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/Read.jsp");
		rd.forward(request, response);
	}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			List<Bean6> list2 = new ArrayList<Bean6>();
			String login_id=request.getParameter("login_id");
			String name=request.getParameter("name");
			String birth_date=request.getParameter("birth_date1");
			String birth_date2=request.getParameter("birth_date2");
			Bean5 Bean5 =new Bean5(login_id,name,birth_date,birth_date2);
			DAO dao=new DAO();
			try {
			list2 = dao.retrievalOne(Bean5);
			} catch (NamingException e1) {

				e1.printStackTrace();
			}
			request.setAttribute("list2",list2);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/read.jsp");
			rd.forward(request, response);
			}

	}


