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

}
.header{
 text-align: left;
    font-size:35px;
    background-color:black;
    color:white;
    padding:10px;
    
}




.forms{


    
	width:60%;
	height:500px;
	
	margin-left:350px;
	padding:10px;
	margin-top:8%;
	background-color:white;
	box-shadow: 2px 1px 21px -9px rgba(0,0,0,0.38);
	display:flex;
}

input[type="text"]{

  width: 95%;
  padding: 12px 20px;
  margin: 20px 0px 0px 20px;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

.loginbutton{
background-color: black;
  color: white;
  font-weight:bold;
  font-size:20px;
  padding: 14px 20px;
  
  border: none;
  cursor: pointer;
  width: 30%;
  text-align:center;
  
  border-radius: 25px;
  cursor: pointer;
  outline: none;

}



label1{
font-size:20px;
font-weight:bold;
padding: 12px 25px;

}

.formImage{
width:500px;
height:500px;

}
.formContent{
width:50%;
text-align:center;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: white;
}

li {
  float: left;
}

li a {
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: blue;
}

.active {
  background-color: #04AA6D;
}
</style>
<body>

<div class="header">
Hindusthan Bank
</div>
<ul>
  <li><a  href="functionality.jsp">Profile</a></li>
  <li><a href="credit.jsp">Credit</a></li>
  <li><a class="active" href="withdraw.jsp">Debit</a></li>
  <li><a href="transfer.jsp">Transfer</a></li>
   <li><a href="statements.jsp">Statements</a></li>
    <li><a href="creditcard.jsp">Credit Card</a></li>
</ul>

<div class="forms">
<div class="formImage">
<img src="function.png" width="500" height="500">
</div>
<div class="formContent">
<form action="Withdraw" >
<h1 style="text-align:center">WITHDRAW</h1>
<br><br>
<table>
<tr><td style="font-weight:bold;font-size:20px;padding: 12px 25px">Withdraw Amount</td></tr>
</table>
<input type="text" name="amount" required><br><br>
<br>
<%
boolean withdrawsflag=Boolean.parseBoolean(request.getParameter("withdrawsflag"));
boolean withdrawfflag=Boolean.parseBoolean(request.getParameter("withdrawfflag"));

if(withdrawsflag==true){

%>
<div style="text-align:center;color:green">Withdraw successful!!</div>

<%
}
else if(withdrawfflag==true){
%>
<div style="text-align:center;color:red">Withdraw failed</div>

<%} %>
 <button class="loginbutton" type="submit">WITHDRAW</button>
 
 
</form>
</div>

</div>


</body>
</html>