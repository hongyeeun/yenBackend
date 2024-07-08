package com.yen.member.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yen.member.model.service.MemberService;
import com.yen.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // 뭔소리야 이해안감.. ㅠ
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			
			Member member = new Member(memberId, memberPw);
			MemberService mService = new MemberService();
			member = mService.checkLogin(member);
			if(member != null) {
				// 로그인 성공 -> 메인으로 이동
			// 로그인 정보 저장할때는 session 이용한다.
			HttpSession session = request.getSession();
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberPw", member.getMemberPw());
			response.sendRedirect("/");	// /index.jsp 나 똑같다. 
			
		} else {
			//  에러메시지를 띄운다.
			// msg 에 '존재하지 않는 정보입니다' 저장 .. 저장하고 전달!
			request.setAttribute("msg", "존재하지 않는 정보입니다.");
			// 사용자의 요청을 errorPage.jsp에 전달한다
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
	}
}