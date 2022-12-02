<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Admin!</title>
<link rel="stylesheet" type="text/css" href="style.css"> 
 <%
   
    String a[] = new String[100];
 
 Class.forName("com.mysql.cj.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineVotingDB","root","root-password");
	
	PreparedStatement preparedStatement = con.prepareStatement("select party,count(party) as c from vote group by party");
	ResultSet rs=((java.sql.Statement) preparedStatement).executeQuery("select party,count(party) as c from vote group by party");
	
    int i=0;
    while(rs.next()){
        a[i] = rs.getString("c");
        i++;
    }
    %>
</head>
<%@ include file="adminNavBar.jsp"%> 
<body>

<div class="checkTable">
<table >
<tr>
<th>
Parties
</th>
<th>
Names
</th>
<th>
Votes
</th>
</tr>

<tr>
<td>
<img src="images/Aap.jpg" alt="AAP">
</td>
<td>Aam Aadmi Party</td>
<td><%=a[0]%></td>
</tr>

<tr>
<td>
<img src="images/bjp.jpg" alt="BJP">
</td>
<td>BJP</td>
<td><%=a[1]%></td>
</tr>

<tr>
<td>
<img src="images/bsp.jpg" alt="BSP">
</td>
<td>BSP</td>
<td><%=a[2]%></td>
</tr>

<tr>
<td>
<img src="images/congress.png" alt="Congress">
</td>
<td>Congress</td>
<td><%=a[3]%></td>
</tr>

<tr>
<td>
<img src="data:image/jpeg;base64,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" alt="CPI">
</td>
<td>CPI</td>
<td><%=a[4]%></td>
</tr>

</table>
</div>
</body>
</html>