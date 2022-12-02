

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminLogin() {
        super();
        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");
		
		DBmanager db = new DBmanager();
		java.sql.Connection con = db.getConnection();
		
	try{
			
			PreparedStatement preparedStatement = con.prepareStatement("select * from Admin where adminName = '"+adminName+"' and adminPass = '"+password+"'");
			ResultSet rs=((java.sql.Statement) preparedStatement).executeQuery("select * from Admin where adminName = '"+adminName+"' and adminPass = '"+password+"'");
			   
			if(rs.next())
			   {
				   HttpSession session=request.getSession();
				   session.setAttribute("adminName", adminName);
				   response.sendRedirect("adminWelcome.jsp");
			     }
			   else  
			   {
				   out.println("WRONG CREDENTIALS");
			   }
		   }
		   catch (Exception e) {
	             out.println(e.getMessage());
		   }
		
	}

}
