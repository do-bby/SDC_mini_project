package member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import member.MemberDAO;
 
public class MemberIdCheckAction{
    public void execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
 
        String id = request.getParameter("id");
        MemberDAO dao = MemberDAO.getInstance();
        
        boolean result = dao.duplicateIdCheck(id);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
        if(result)    out.println("0"); // 아이디 중복
        else        out.println("1");
        
        out.close();
    }
}
