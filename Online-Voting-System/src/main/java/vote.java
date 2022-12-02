

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public vote() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String voter_card_number = request.getParameter("voterNumber");
		String party = request.getParameter("party");
		
		DBmanager db = new DBmanager();
		java.sql.Connection con = db.getConnection();
		
		try {
			
			PreparedStatement preparedstatement1 = con.prepareStatement("insert into vc_numbers(voter_card_number)value('"+voter_card_number+"') ");
			PreparedStatement preparedstatement2 = con.prepareStatement("insert into vote(voter_card_number,party)values ('"+voter_card_number+"','"+party+"')");
			
			preparedstatement1.executeUpdate();
        	preparedstatement2.executeUpdate();
        	
        	 response.sendRedirect("index.jsp");
			
		}
		catch(SQLException ex) {
			
			out.println(ex.getMessage());
			
		}
		
		
	}

}
