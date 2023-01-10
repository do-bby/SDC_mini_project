package bootcamp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class CampupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CampupdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String campId = request.getParameter("bnum");
		BootcampDAO2 dao = new BootcampDAO2();
		BootcampVO2 vo = new BootcampVO2();
		vo = dao.listOne(Integer.parseInt(campId));
		
		request.setAttribute("BootcampUpdate", vo);
		RequestDispatcher rd = request.getRequestDispatcher("BootcampUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String campId = request.getParameter("bnum");
		String b_name = request.getParameter("bprogram");
		String a_name = request.getParameter("bacademy");
		String rogo = request.getParameter("rogo");
		String realimg = request.getParameter("realimg");
		String site = request.getParameter("site");
		String m_id = request.getParameter("mnum");
		String address = request.getParameter("address");
		BootcampDAO2 dao = new BootcampDAO2();
		BootcampVO2 vo = new BootcampVO2();
		System.out.println(campId);
		System.out.println(b_name);
		System.out.println(a_name);
		vo.setId(Integer.parseInt(campId));
		vo.setB_name(b_name);
		vo.setA_name(a_name);
		vo.setRogo(rogo);
		vo.setRealimg(realimg);
		vo.setSite(site);
		vo.setM_id(Integer.parseInt(m_id));
		vo.setAddress(address);
		boolean result = dao.update(vo);
		if (result) {			
			request.setAttribute("msg", "성공적으로 수정되었습니다.");			
		} else {
			request.setAttribute("msg", "수정되지 않았습니다.");
		}
		RequestDispatcher rd = request.getRequestDispatcher("BootcampSucess.jsp");
		rd.forward(request, response);
		
		
	}

}

