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
	height:500px;
	margin-right:30px;
	margin-left:800px;
	padding-left:10px;
	margin-top:200px;
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

<div class="container">
<div class="imgcontainer">
 <img src="login3.jpg" alt="Avatar" class="avatar">
</div>
<div class="login">

<form action="Login" >
<h2><center>LOGIN</center></h2>
<br><br>
<label for="email" >Email</label><br>
<input type="text" name=user ><br><br>



<label for="password" >Password</label><br>
<input type="password" name=pwd><br><br>

 <button type="submit">Login</button><br><br>
 <a href="home.html" style="text-align:left">Home</a>
 <a href="register.jsp" style="text-align:right">Register</a>
 <%

//String status=(String)session.getAttribute("status");
		//System.out.println("status is : "+status);
boolean flag=Boolean.parseBoolean(request.getParameter("flag"));
if(flag==true){
flag=false;
%>
<div class="errorbox" style="color:red;text-align:center">Login failed Invalid Credentials</div>
<%} %>
</form>
</div>
</div>





</body>
</html>