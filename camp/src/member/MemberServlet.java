package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int pnum = Integer.parseInt(request.getParameter("phone"));
		String nname = request.getParameter("nick");
		
		MemberVO vo =new MemberVO();
		vo.setid(id);
		vo.setpwd(pwd);
		vo.setname(name);
		vo.setemail(email);
		vo.setpnum(pnum);
		vo.setnname(nname);
		
		MemberDAO mdao = new MemberDAO();
		mdao.insertM(vo);
		
		request.setAttribute("member",vo);
		request.getRequestDispatcher("/MemberDesign.html").forward(request,response);

		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("idinput");
	    MemberDAO dao = new MemberDAO();
	    boolean result = dao.duplicateIdCheck(userid);
	    
	    response.setContentType("text/html;charset=UTF-8");
	    request.setAttribute("idCheck", result);
	    request.setAttribute("userId", userid);
	    
	    RequestDispatcher idcheck = request.getRequestDispatcher("/IdCheckForm.jsp");
	    idcheck.forward(request, response);
	}
}


