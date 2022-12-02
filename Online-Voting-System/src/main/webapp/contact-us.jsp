<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact us</title>
<link rel="stylesheet"type="text/css"href="style.css">
</head>
<%@include file="navBar.jsp" %>
<body>

<div class="form-container">
<form action="contact" method="post" >

<label for="name" class="form-elements"> <b>Name :</b></label>
 <br>
 <input id="name" name="name" class="form-elements form-input" type="text" />
 <br>
 <label for="number" class="form-elements"> <b>Phone Number</b></label>
 <br>
 <input id="number" name="number" class="form-elements form-input" type="number" />
 <br>
 <label for="email" class="form-elements"> <b>Email</b></label>
 <br>
 <input id="email" name="email" class="form-elements form-input" type="email" />
 <br>
 <label for="comment" class="form-elements"> <b>Comment</b></label>
 <br>
 <textarea id="comment" name="comment" class="form-elements form-input"></textarea>
 <br>
 <button type="submit" class="form-elements form-button">Submit</button>

</form>
</div>
</body>
</html>