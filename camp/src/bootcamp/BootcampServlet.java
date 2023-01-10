package bootcamp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import member.MemberDAO;


@WebServlet("/bootcamp")
public class BootcampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BootcampServlet() {super();}
    BootcampDAO bDao;
    MemberDAO mDao;
    
    public void init() {
    	bDao = new BootcampDAO();
    	mDao = new MemberDAO();
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Main 화면에선 항상 list라는 이름으로 모든 부트캠프 리스트를 반환
		HttpSession session = request.getSession(false);
		request.setAttribute("list", bDao.listAll());
		RequestDispatcher rd = request.getRequestDispatcher("bootMainYebin2.jsp");
		rd.forward(request, response);

	
		
	}

		
}
