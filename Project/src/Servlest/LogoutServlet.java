package Servlest;


	import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

	@WebServlet("/LogoutServletDB")
	public class LogoutServlet extends HttpServlet {

	    private static final long serialVersionUID = 1L;

	    public LogoutServlet() {
	        super();
	    }


	    @Override

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	HttpSession session = request.getSession(true);
	    	 session.invalidate();
	    	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			rd.forward(request, response);

		}








	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        request.setCharacterEncoding("UTF-8");
	        String btn = request.getParameter("submit");

	        HttpSession session = request.getSession();
	        RequestDispatcher rd;

	        if ("ログイン".equals(btn)) {


	            String id = request.getParameter("id");
	            String pass = request.getParameter("pass");
	            String source = pass;
				Charset charset = StandardCharsets.UTF_8;
				String algorithm = "MD5";
				byte[] bytes = null;
				try {
					bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
				} catch (NoSuchAlgorithmException e1) {

					e1.printStackTrace();
				}
				String result = DatatypeConverter.printHexBinary(bytes);
				pass = result;

				LoginDB login = new LoginDB();
	            LoginUserBean bean = login.getUserData(id, pass);


	            if (bean != null) {
	                session.setAttribute("user_db", bean);
	                session.setAttribute("login_db",id);
	                response.sendRedirect("/Example/Read");

	            } else {
	            	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginNG.jsp");
			            dispatcher.forward(request, response);
	            }


	        } else {
	            session.removeAttribute("login_db");
	            session.removeAttribute("user_db");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
	}


