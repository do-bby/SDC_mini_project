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
		request.getRequestDispatcher("/camp/WebContent/MemberDesign.html").forward(request,response);
		//요청된 리소스 [/camp/WebContent/MemberDesign.html]은(는) 가용하지 않습니다.에러 나는 중
		
		
	}

}
