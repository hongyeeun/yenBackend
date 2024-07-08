package com.yen.taste;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TasteServlet
 */
@WebServlet("/TasteServlet")
public class TasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String foods[] = request.getParameterValues("food");

		Map<String, String> colorMap = new HashMap<String, String>();
		colorMap.put("red", "빨강");
		colorMap.put("blue", "파랑");
		colorMap.put("yellow", "노랑");
		colorMap.put("green", "초록");
		
		Map<String, String> animalMap = new HashMap<String, String>();
		animalMap.put("puppy", "강아지");
		animalMap.put("kity", "고양이");
		animalMap.put("elephant", "코끼리");
		animalMap.put("lion", "사자");
				
		Map<String, String> foodMap = new HashMap<String, String>();
		foodMap.put("jjm", "짜장면");
		foodMap.put("jjb", "짬뽕");
		foodMap.put("tsy", "탕수육");
		foodMap.put("mpdb", "마파두부");
		foodMap.put("pbc", "팔보채");
		
		String foodStr = "";
		for(String food : foods) {
			foodStr += foodMap.get(food)+", ";
		}
		
		// jsp 이용해서 출력하는 방법
//		response.sendRedirect("/taste/result.html");
		request.setAttribute("userName", userName);
		request.setAttribute("color", colorMap.get(color));
		request.setAttribute("animal", animalMap.get(animal));
		request.setAttribute("foodStr", foodStr);
		request.getRequestDispatcher("/taste/tasteResult.jsp").forward(request, response);

//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>개인 취향 테스트</title>");
//		out.println("</head><body>");
//		out.println("<h1>개인 취향 테스트 결과</h1>");
//		out.println("<p>이름 : " + name +"<br>");
//		out.println("색깔 : <span style = 'color:"+color+";'>"+color+"</span><br>");
//		out.println("동물 : "+animal+"<br>");
//		out.println("음식 : " + foodStr);
//		out.println("</p>");
	}
	
// 만약 red대신 한글인 색(ex.빨강, 노랑)으로 출력하고싶다면 이렇게
// if문으로 하는 방법
//	if("red".equals(color)) {	
//		color = "<span style = 'color:red;'>빨강</span>";
//	} else if ("blue".equals(color)) {
//		color = "<span style = 'color:blue;'>파랑</span>";
//	} else if ("yellow".equals(color)) {
//		color = "<span style = 'color:yellow;'>노랑</span>";
//	} else if ("green".equals(color)) {
//		color = "<span style = 'color:green;'>초록</span>";
//	}
}
