package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;
import member.MemberLoginDAO;

@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//로그인정보를 post로 받아 처리하는 부분
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action"); //액션이 로그인인지 체크
		String id = request.getParameter("id"); // 아이디 파라미터 가져옴
		String pwd = request.getParameter("pwd"); // 패스워드 파라미터 가져옴
		
		MemberLoginDAO dao = new MemberLoginDAO();//멤버로그인 dao 가져옴
		MemberVO vo =new MemberVO(); // 멤버 객체정보 가져옴
		vo.setid(id); //id 값 넣어줌
		vo.setpwd(pwd); //pwd 값 넣어줌
		
		if(action.equals("login")) {
			boolean result = dao.selectLogin(vo);
		}
		
		request.setAttribute("member",vo);
		request.getRequestDispatcher("/member/MemberView").forward(request,response);
		
		
		
	}

}
