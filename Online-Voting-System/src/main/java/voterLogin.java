

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class voterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public voterLogin() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String voternum = request.getParameter("voterNumber");
		
		DBmanager db = new DBmanager();
		java.sql.Connection conn = db.getConnection();
		
		
		try {

			PreparedStatement PreparedStatement = conn.prepareStatement("select voter_card_number from vc_numbers where voter_card_number = '"+voternum+"' ");
			ResultSet rs = PreparedStatement.executeQuery(" select voter_card_number from vc_numbers where voter_card_number = '"+voternum+"' ");
			
			if(rs.next())   // checking if voter cared number has voted or not
	           {

				response.sendRedirect("votercheck.jsp");
	           out.println("You already voted........"+rs.getString("voter_card_number"));
	           }
			else
			{
				
	        	   PreparedStatement preparedStatement2 = conn.prepareStatement("select vid,pnumber from voters where voter_card_number = '"+voternum+"' ");
	               ResultSet rs1 =   preparedStatement2.executeQuery("select vid,pnumber,name from voters where voter_card_number = '"+voternum+"' ");
	               
	               if(rs1.next()) // if voter card number is registered
	               {
	            	   
	                   String name = rs1.getString("name");
	                   response.sendRedirect("userWelcome.jsp?conn="+name);
	                   out.println(name);
	                   
	               }
	               else
	               {
	            	   
	                   out.println("Please enter valid card number");
	               }
	              
	        	   
	           }
	        	   
		}
		catch(SQLException ex){
			
			out.println("database issue");
			
		}
		
//		out.println(voternum);
		
	}

}
