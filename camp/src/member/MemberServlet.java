package member;

import java.io.IOException;
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
		String input = request.getParameter("input");
		
		if(input.equals("idform")) {
	    MemberDAO dao = new MemberDAO();
	    boolean resultid = dao.duplicateIdCheck(input);	    
		if (resultid) {
			request.setAttribute("confirmid", "이미 존재하는 아이디입니다");
		}else {
			request.setAttribute("confirmid", "사용가능한 아이디입니다");						
		  }
		request.getRequestDispatcher("/IdCheckForm.jsp").forward(request, response);;
		}else {
		MemberDAO dao = new MemberDAO();
		boolean resultn = dao.duplicateNicknameCheck(input);
		if (resultn) {
			request.setAttribute("confirmnick", "이미 존재하는 닉네임입니다");
		}else {
			request.setAttribute("confirmnick", "사용가능한 닉네임입니다");						
		}
		request.getRequestDispatcher("/NickCheckForm.jsp").forward(request, response);;
	}

	
		
	    
	}
}


