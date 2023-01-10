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
		String input = request.getParameter("input");
	
		if(input.equals("memberRegister")) {
			String id = request.getParameter("id");
			System.out.println(id);
			String pwd = request.getParameter("pwd");
			System.out.println(pwd);
			String name = request.getParameter("name");
			System.out.println(name);
			String email = request.getParameter("email");
			System.out.println(email);
			String pnum = request.getParameter("phone");
			System.out.println(pnum);
			String nname = request.getParameter("nick");
			String question = request.getParameter("question");
			String answer = request.getParameter("answer");
			System.out.println("b");
			MemberVO vo =new MemberVO();
			vo.setid(id);
			vo.setpwd(pwd);
			vo.setname(name);
			vo.setemail(email);
			vo.setpnum(pnum);
			vo.setnname(nname);
			vo.setquestion(question);
			vo.setanswer(answer);
		
			MemberDAO mdao = new MemberDAO();
			mdao.insertM(vo);
			System.out.println("d");
			request.setAttribute("member",vo);
			System.out.println("c");
			request.getRequestDispatcher("/MemberDesign.html").forward(request,response);
			
		}else if(input.equals("infoRevise")) {			
			String mid = request.getParameter("mid");
			String mpwd = request.getParameter("mpwd");
			String mname = request.getParameter("mname");
			String memail = request.getParameter("memail");
			String mpnum = request.getParameter("mpnum");
			String mnname = request.getParameter("mnname");
			String mquestion = request.getParameter("question");
			String manswer = request.getParameter("answer");
			
			MemberDAO dao = new MemberDAO();
			int result = dao.infoUpdate(mid,mpwd,mname,memail,mpnum,mnname,mquestion,manswer);
			
			if (result ==0) {
				request.setAttribute("msg", "회원정보 수정이 완료되었습니다.");
				request.getRequestDispatcher("/MemberInfo.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "회원정보 수정에 오류가 발생했습니다.");					
				request.getRequestDispatcher("/MemberInfoRevise.jsp").forward(request, response);
			}
			
		}       
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		String input = request.getParameter("input");
		String idv = request.getParameter("idval");
		String nv = request.getParameter("nickval");
		
		if(input.equals("idform")) {
			MemberDAO dao = new MemberDAO();
			boolean resultid = dao.duplicateIdCheck(idv);	    
			if (resultid) {
				request.setAttribute("confirmid", "이미 존재하는 아이디입니다");
			}else {
				request.setAttribute("confirmid", "사용가능한 아이디입니다");						
			}
			request.getRequestDispatcher("/IdCheckForm.jsp").forward(request, response);;
		} else if(input.equals("nickform")) {
			MemberDAO dao = new MemberDAO();
			boolean resultn = dao.duplicateNicknameCheck(nv);
			if (resultn) {
				request.setAttribute("confirmnick", "이미 존재하는 닉네임입니다");
			}else {
				request.setAttribute("confirmnick", "사용가능한 닉네임입니다");						
			}
			request.getRequestDispatcher("/NickCheckForm.jsp").forward(request, response);;
		
		}
	}
}



