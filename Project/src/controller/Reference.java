package controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Bean4;
import dao.DAO;

@WebServlet("/Reference")
public class Reference extends HttpServlet {
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
			Bean4 Bean = null;
			try {
				Bean = dao.find(Integer.parseInt(s_id));
			} catch (NumberFormatException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			request.setAttribute("Bean",Bean);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/reference.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		  String btn = request.getParameter("submit");
		  if ("戻る".equals(btn)) {
			  response.sendRedirect("/Example/Read");
		  }
	}


}
