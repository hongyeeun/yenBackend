package com.yen.checkbox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckboxServlet
 */
@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckboxServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String place = request.getParameter("place"); 	기존에 쓰던 거
		String [] places = request.getParameterValues("place"); // Stirng 배열이라 values 메소드 쓴다.
		String str = "";
		for(String place : places)	// 여러개 출력
			str += place + ", ";
//			System.out.println(place);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>관광지 선택결과</h1>");
		out.println("<h2>"+str+"</h2>");
//		response.sendRedirect("/checkbox/checkResult.html");
	}

}
