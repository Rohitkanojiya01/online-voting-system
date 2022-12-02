<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style.css"> 
</head>
<%@ include file="navBar.jsp"%> 
<body>
<div class="form-container" >
<form action="registerUser" method="post">

<label for="name" class="form-elements"><b>Name :</b></label> 
<br>
<input id="name" name="name" class="form-elements form-input" type="text"/>
<br>
<label for="number" class="form-elements"><b>Phone Number :</b></label>
<br>
<input id="number" name="pnumber" class="form-elements form-input" type="number"/>
<br>
<label for="email" class="form-elements"><b>Email :</b></label>
<br>
<input id="email" name="email"  class="form-elements form-input" type="email"/>
<br>
<label for="voternumber" class="form-elements"><b>Voter Card Number :</b></label>
<br>
<input id="voternumber" name="voterNumber" class="form-elements form-input" type="text">
<br>
<label for="address" class="form-elements"><b>Address : </b></label>
<br>
<input id="address" name="addr" class="form-elements form-input" type="text"/>
<br>
<label for="dob" class="form-elements"><b>Date of Birth :</b></label>
<br>
<input id="dob" name="dob" class="form-elements form-input" type="text">
<br>
<button type="Submit" class="form-elements form-button">Register</button>
</form>
</div>
</body>
</html>