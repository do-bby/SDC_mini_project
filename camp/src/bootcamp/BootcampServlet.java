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
    private BootcampDAO bDao;
    private MemberDAO mDao;
    
    public void init() {
    	bDao = new BootcampDAO();
    	mDao = new MemberDAO();
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO 객체 생성
		
		//Main 화면에선 항상 list라는 이름으로 모든 부트캠프 리스트를 반환
		HttpSession session = request.getSession(false);
		request.setAttribute("list", bDao.listAll());
		if(session!=null) {
			// session에 저장된 로그인 정보 받아오기 
		
			boolean loginCheck = (boolean)session.getAttribute("isLogOn");
			String login_id = (String)session.getAttribute("login.id");
			
			
			// login 되어있으면 로그인 한 회원의 정보가 담긴 세션 객체를 반환,  Main 화면으로 forward 해준다. 
			if(loginCheck) {
				session.setAttribute("loginVO", mDao.getMember(login_id));
		
			}
			RequestDispatcher rd = request.getRequestDispatcher("BootMainYebin.jsp");
			rd.forward(request, response);

		}else {
			RequestDispatcher rd = request.getRequestDispatcher("BootMainYebin.jsp");
			rd.forward(request, response);
		}
	}

/*
 *  private String b_name;	// 부트캠프 이름
	private String a_name;	// 학원이름
	private String rogo;	// 학원로고
	private String realimg;	// 실제 학원이미지
	private String site; // 사이트 링크
	private int m_id; // 회원 id
	
 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
	
		
		
		 
	}
		
}
