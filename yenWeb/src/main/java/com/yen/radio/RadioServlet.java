package com.yen.radio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RadioServlet
 */
@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RadioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gender과 mailCheck 변수는 get을 눌러서 받은 결과값이다. (value값)
		String gender = request.getParameter("gender");	// 괄호 안에는 키 값의 name 적어줌
		String mailCheck = request.getParameter("mail-check");
		response.setContentType("text/html;charset=utf-8");	// response의 type은 html 그리고 한글로
		PrintWriter out = response.getWriter();	// out은 response을 write하는 객체이다.
		out.println("<html><head><title> 라디오 체크 결과 </title>");	// out은 println으로 써줌
		out.println("</head><body>");
		out.println("<h1> 라디오 체크 결과 </h1>");
		out.println("성별 : "+gender+"<br>");
		out.println("메일 수신여부 : "+mailCheck+"<br>");
		out.println("</body></html>");
	}
}
