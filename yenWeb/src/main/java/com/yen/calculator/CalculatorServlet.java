package com.yen.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getParameter은 string 이므로 int 형으로 변환해줘야한다.
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String operator = request.getParameter("operator");
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = 0;
		
		switch(operator) {
			case "+" : result = num1 + num2; break;
			case "-" : result = num1 - num2; break;
			case "x" : result = num1 * num2; break;
			case "/" : result = num1 / num2; break;
			case "%" : result = num1 % num2; break;
		}
		
		// 내가 한것
//		if("+".equals(math)) {
//			result = num1 + num2;
//		} else if ("-".equals(math)) {
//			result = num1 - num2;
//		} else if ("x".equals(math)) {
//			result = num1 * num2;
//		} else if ("/".equals(math)) {
//			result = num1 / num2;
//		} else if ("%".equals(math)) {
//			result = num1 % num2;
//		}
		
		// 뒤에 오는 object는 모든 형들 다 가능하다.
		request.setAttribute("num1", num1);
		request.setAttribute("operator", operator);
		request.setAttribute("num2", num2);
		request.setAttribute("result", result);

		request.getRequestDispatcher("/calculator/resultCalc.jsp").forward(request, response);
	}
}
