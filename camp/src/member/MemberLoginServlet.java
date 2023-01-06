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
		doHandle(request, response);
	}
	
	//로그인정보를 post로 받아 처리하는 부분
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	//핸들러로 알아서 구분. 위에 get post 안에는 doHandle메서드를 넣어주면됨.
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//액션, 아이디, 패스워드 파라미터 값 가져옴
		String action = request.getParameter("action"); 
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd");
		
		MemberLoginDAO dao = new MemberLoginDAO();//멤버로그인 dao 가져옴
		MemberVO vo =new MemberVO(); // 멤버 객체정보 가져옴
		boolean result = false;
		
		//id 값  pwd 값 넣어줌
		vo.setid(id);
		vo.setpwd(pwd);
		
		if(action.equals("login")) {//액션값이 login 이면
			result = dao.selectLogin(vo); //vo값(지금은 id,pwd값만 있음)넣고 호출
			//로그인기능
			if(result) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogOn", true);	//세션에 isLogOn이라는 이름으로 true를 저장
				session.setAttribute("login.id", id);	//id와 pw를 세션에 저장.
				session.setAttribute("login.pwd", pwd);
				RequestDispatcher rd = request.getRequestDispatcher("/BootReviewApp.jsp");//로그인이 완료되면 이 페이지로 이동
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", " 아이디 또는 비밀번호를 잘못 입력했습니다. <br> 입력하신 내용을 다시 확인해주세요.");//msg 부분에 이 값을 띄워줌
				RequestDispatcher rd = request.getRequestDispatcher("/MemberLogin.jsp"); //로그인 실패시 이 페이지로 이동
				rd.forward(request, response);
			}
		}else if(action.equals("findpwd")) { //action 값이 findpwd 이면
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/BootReviewApp.jsp");
			rd.forward(request, response);
		}
		
		
	}
}
