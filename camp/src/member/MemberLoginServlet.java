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

@WebServlet("/login")
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
	
	//핸들러로 알아서 구분
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
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
		}
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn", true);	//세션에 isLogOn이라는 이름으로 true를 저장
			session.setAttribute("login.id", id);	//id와 pw를 세션에 저장.
			session.setAttribute("login.pwd", pwd);
			
		} else {
			//out.print("<html><body><h1>아이디가 틀립니다.</h1><br><h3><a href='/login'>다시</a></h3></body></html>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
	}
}
