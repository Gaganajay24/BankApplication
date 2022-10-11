<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<style>
body {font-family: Arial, Helvetica, sans-serif;
background-color:black;
}
.login{
	text-align:left;
	width:30%;
	height:800px;
	margin-right:30px;
	margin-left:800px;
	padding-left:10px;
	margin-top:100px;
	background-color:white;
	
   
}
input[type=text], input[type=password] {
 
  width: 95%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
 


button {
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 70%;
 
  margin-left:50px;
}

button:hover {
  opacity: 0.8;
}

.imgcontainer {
  text-align: center;
  margin:100px 0 100px 50px;
}

img.avatar {
  width: 225%;
  border-radius: 150%;
}
.container{
display:flex;
justify-content: center;
}


</style>
<body>
<script type = "text/javascript" >
    function preventBack() { window.history.forward(); }
    setTimeout("preventBack()", 0);
    window.onunload = function () { null };
</script>
<form action="Register" >
<div class="container">
<div class="imgcontainer">
 <img src="login3.jpg" alt="Avatar" class="avatar">
</div>
<div class="login">


<br><br><br><br>
<label for="name" >Name</label><br>
<input type="text" name=name ><br><br>
<label for="email">Email</label><br>
<input type="text" name=email><br><br>
<label for="phonenumber">Phone Number</label>
<input type="text" name=phoneNumber><br><br>
<label for="amount">Amount to be deposited</label>
<input type="text" name=amount><br><br>
<label for="password" >Password</label><br>
<input type="password" name=pwd><br><br>
<label for="reEnter">Re-Enter Password</label>
<input type="password" name=repassword><br><br>
<%
boolean pwdstatus=Boolean.parseBoolean(request.getParameter("pwdstatus"));
		//System.out.println("status is : "+status);
if(pwdstatus==true){
%>
<div style="color:red">Passwords not matching</div>
<%} %>

<%
boolean registerstatus=Boolean.parseBoolean(request.getParameter("registerStatus"));
		//System.out.println("register status is : "+registerstatus);
if(registerstatus==true){
%>
<div style="color:red">Registration failed</div>
<%} %>

 <button type="submit">Register</button><br><br>
 <a href="home.html" style="text-align:left">Home</a>
 <a href="Login.jsp" style="text-align:right">Login</a>
 
</div>
</div>


</form>

</body>
</html>