package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberVO;
import member.MemberLoginDAO;

@WebServlet("/login")//이거 중요함 action 값에 이 값을 넣어줘야 알아서 처리됨
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//로그인정보를 get로 받아 처리하는 부분
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("/MemberLogin.jsp");
			rd.forward(request, response);
	}
	
	//로그인정보를 post로 받아 처리하는 부분
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//초기변수 선언
		MemberLoginDAO dao = new MemberLoginDAO();//멤버로그인 dao 가져옴
		MemberVO vo =new MemberVO(); // 멤버 객체정보 가져옴
		HttpSession session; //세션객체생성
		
		//vo에 넣을 객체값 선언
		String action = request.getParameter("action"); 
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		//vo값 넣어주는부분
		vo.setid(id);
		vo.setpwd(pwd);
		vo.setquestion(question);
		vo.setanswer(answer);
		System.out.println(id);
		System.out.println(question);
		System.out.println(answer);
		
		//action 값으로 기능 구분하도록 만듬
		if(action.equals("login")) {
			boolean result = dao.selectLogin(vo); //dao에서 true, false값으로 받아오게 만들었음.
			
			//로그인기능
			if(result) {
				session = request.getSession(); //세션정보 생성
				session.setAttribute("isLogOn", true);	//세션에 isLogOn이라는 이름으로 true를 저장
				session.setAttribute("login.id", id);	//id와 pw를 세션에 저장.
				session.setAttribute("login.pwd", pwd);
				response.sendRedirect("bootcamp"); //해당 링크(여기선 서블릿의 @WebServlet 값)로 요청함

			} else {
				request.setAttribute("msg", " 아이디 또는 비밀번호를 잘못 입력했습니다. <br> 입력하신 내용을 다시 확인해주세요.");//msg 부분에 이 값을 띄워줌
				RequestDispatcher rd = request.getRequestDispatcher("/MemberLogin.jsp"); //로그인 실패시 이 페이지로 이동
				rd.forward(request, response);
			}
			
		}else if(action.equals("findpwd")) { //action 값이 findpwd 이면
			String findPwd = dao.selectPwd(vo);
			System.out.println(findPwd);
			request.setAttribute("findPwd", findPwd);//찾은 비밀번호를 담아줌
			RequestDispatcher rd = request.getRequestDispatcher("/MemberFindPwd.jsp");
			rd.forward(request, response);
			
		}else if(action.equals("logout")) { //로그아웃
			session = request.getSession(); //세션 가져오기
			session.invalidate(); //세션 파기하기
		}
	}
	
//	//핸들러로 알아서 구분. 위에 get post 안에는 doHandle메서드를 넣어주면됨.
//	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		
//	}
}
