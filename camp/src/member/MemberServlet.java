package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//mnum은 자동생성돼서 어떻게 처리해야 할지 고민중
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String nname = request.getParameter("nname");
		
		MemberVO vo =new MemberVO();
		vo.setid(id);
		vo.setpwd(pwd);
		vo.setname(name);
		vo.setemail(email);
		vo.setpnum(pnum);
		vo.setnname(nname);
		
		request.setAttribute("member",vo);
		request.getRequestDispatcher("/member/MemberView").forward(request,response);
		
		
		
	}

}
