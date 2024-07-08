package com.yen.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yen.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/remove.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원탈퇴 -> 쿼리문 DELETE FROM MEMBER_TBL WHERE MEMBER_ID = '로그인 한 ID';
		String memberId = request.getParameter("memberId"); 	
		// memberId는 index.jsp 에서 {$ memberId} 이다.
		MemberService mService = new MemberService();
		int result = mService.deleteMember(memberId);
		if(result > 0) {
			// 로그아웃 후 메인으로 이동
			// 1. 세션을 가져온 후
			//HttpSession session = request.getSession();
			// 2. 세션을 파괴하고 (초기화)
			//if(session != null) session.invalidate();
			// 3. 메인으로 페이지 이동
			response.sendRedirect("/member/logout.do");
			// 이미 LogoutServlet.java 에서 했던 것이므로 위의 쿼리문들은 생략하고 url만 작성해주면 된다.
		} else {
			// 실패시 에러페이지로 이동
			request.setAttribute("msg", "회원탈퇴가 완료되지 않았습니다.");
			RequestDispatcher view
			= request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			view.forward(request, response);
		}
	}
}
