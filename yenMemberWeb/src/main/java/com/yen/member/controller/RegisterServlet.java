package com.yen.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yen.member.model.service.MemberService;
import com.yen.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
// 원래는 /RegisterServlet 인데 서블릿 처음 만들 때, URL 설정해줌
// 디폴트 값 말고 변경된 것으로 사용하기위해
// 이렇게 url 설정한 것은 무조건 "GET" 방법 !!!! (중요)
@WebServlet("/member/join.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("/WEB-INF/views/member/register.jsp");	이렇게 하면 안된다 (url이 변경되었으므로)
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);	
		// 위와 같이 해야지 동작한다 ->  getReuqest~는 변경 전 jsp로 할 수 있어서 가능함
		// url로 변경할 때는 get web~register.jsp 를  member.joindo로 변경하겟다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form 데이터 전달할 땐 post
		request.setCharacterEncoding("UTF-8");	// request의 encoding을 utf-8로 해서 한글 깨짐 방지 
		try {
			// getParameter안에 name 적어줘야한다
			// 밑은 JDBC로 따지면 inputInfo 메소드임
			String memberId = request.getParameter("member-id");
			String memberPw = request.getParameter("member-pw");
			String memberName = request.getParameter("member-name");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String hobby = request.getParameter("hobby");
			
			// 회원가입 비즈니스 로직
	//		Member member = new Member();
			Member member = new Member(memberId, memberPw, memberName, gender, Integer.parseInt(age), email, phone, address, hobby);
			MemberService mService = new MemberService();	
			int result = mService.insertMember(member);
			
			if(result > 0) {
				// 성공 메시지 출력
				// response 와 request 차이 더 알아보자... 어려웡
				// 1. redirect : 단순히 페이지로 이동하는 것 -> 페이지 그대로 보여줌
				// response.sendRedirect(""); 
				// 2. requestDispatcher : 기능을 추가하여 하는 것
				// request.setAttribute("msg", "성공")
				// request.requetDispatcher("").forward(request, response);
				response.sendRedirect("/index.jsp");	//성공하면 메인페이지로
			} else {
				// 실패 메시지 출력
	//			response.sendRedirect("/common/error/errorPage.jsp");	// 성공하면 에러 페이지로
				// errorPage 를 WEB-INF 아래로 이동 했으니까 request로 해줘야한다.
				request.setAttribute("msg", "실패");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
	}
}
