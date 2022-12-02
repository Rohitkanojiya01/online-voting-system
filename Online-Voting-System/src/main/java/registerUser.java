

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class registerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public registerUser() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter out = response.getWriter()){
			
			String name = request.getParameter("name");
			String voter_card_number = request.getParameter("voterNumber");
			String email = request.getParameter("email");
			String addr = request.getParameter("addr");
			String pnumber = request.getParameter("pnumber");
			String dob = request.getParameter("dob");
			
			DBmanager db = new DBmanager();
			java.sql.Connection conn = db.getConnection();
			
			PreparedStatement preparedStatement = conn.prepareStatement("insert into voters(name,pnumber,email,voter_card_number,addr,dob) value('"+name+"','"+pnumber+"','"+email+"','"+voter_card_number+"','"+addr+"','"+dob+"')");
			preparedStatement.executeUpdate();
			out.println("Registration success");
			
			
		}
		catch(SQLException ex){
			
			System.out.println(ex.getMessage());
		}
		
	}

}
