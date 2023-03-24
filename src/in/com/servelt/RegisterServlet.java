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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	/**  b
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("ln");
			String Email = request.getParameter("em");
			String pwd = request.getParameter("pwd");
			String gender = request.getParameter("Gender");

			EmpDto dto = new EmpDto();
			dto.setFname(fname);
			dto.setLname(lname);
			dto.setEmail(Email);
			dto.setPassword(pwd);
			dto.setGender(gender);

			boolean count = EmpDao.register(dto);
			PrintWriter pw = response.getWriter();
			if (count) {
				 pw.append("<html>/r/n "+
						   "<h1>Registration is successful....Please click here to </h1>\r\n"+
									   "<a href =\"index.html\">Login</a>\r\n"+"</html>");
			} else {
				pw.append("Email already exists.. ");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
