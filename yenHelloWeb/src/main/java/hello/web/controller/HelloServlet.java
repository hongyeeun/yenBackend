package hello.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	method가 post이므로 doPost메소드를 사용한다. 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String memberId = request.getParameter("member-id");
		 String memberPw = request.getParameter("member-pw");
		 System.out.println("아이디 : " + memberId + ", 비밀번호 :" + memberPw);
		 
		 System.out.println("동작완료");
		 response.sendRedirect("/common/success.html");
		 // 로그인 버튼 누르면 이 페이지로 이동
	}

}
