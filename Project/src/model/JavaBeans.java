package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JavaBeans
 */
@WebServlet("/JavaBeans")
public class JavaBeans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaBeans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストスコープに保存するインスタンス(JavaBeans)の生成
	    Human human = new Human("山田太郎", 20);
	    
	    // HttpSessionインスタンスの取得
	    HttpSession session = request.getSession();

	    

	    // リクエストスコープにインスタンスを保存
	    	session.setAttribute("human", human);

	    // リクエストスコープからインスタンスを取得
	    Human h = (Human)request.getAttribute("human");

	    // JSPへフォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/JaveBeans.jsp");
	        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
