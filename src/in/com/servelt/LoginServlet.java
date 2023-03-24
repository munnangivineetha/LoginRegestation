 package in.com.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.dao.EmpDao;
import in.com.dto.EmpDto;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	/** 7
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String email = request.getParameter("em");
		String pwd = request.getParameter("pwd");
		EmpDto dto = new EmpDto();
		   dto.setEmail(email);
		   dto.setPassword(pwd);
		   
		    
		  
		   boolean login = EmpDao.login(dto);
		   PrintWriter pw = response.getWriter();
		   if(login) {
			   pw.append("<h1> Welcome to our Application</h1>");
		   }else {
			   pw.append("<html>\r\n "+
		   "<h1>Invalid Credentials....Please click here to </h1>\r\n"+
					   "<a href =\"register.html\">Register</a>\r\n"+"</html>");
		   }    
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
