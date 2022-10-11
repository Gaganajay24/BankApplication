<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.perfios.dao.DetailsDao" %>
    <%@ page import="java.sql.ResultSet" %>
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

.container{
display:flex;

}

.buttons{
justify-centent:left;

}
.menu{
text-align:center;
background: #ADD8E6;
padding:10px;
margin-left:10px;
display:block;
width:300px;
font-size:20px;
font-weight:bold;
}



.col{

flex-basis:31%;
background:#FFC0CB;
border-radius:10px;
margin-bottom:5%;
padding:20px 12px;
box-sizing:border-box;
border-style :solid solid none none;
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
  margin: 20px 0 ;
  border: none;
  cursor: pointer;
  width: 20%;
  text-align:center;
  margin-left:330px;
  border-radius: 25px;
  cursor: pointer;
  outline: none;

}

.inplabel{
font-size:20px;
font-weight:bold;
padding: 12px 20px;
}

.label1{
vertical-align:middle;
font-size:20px;
text-align:left;
padding-left:30px;
}

table{
 border-collapse: collapse;
  width: 50%;
  
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

.formImage{
width:500px;
height:500px;

}
.formContent{
width:50%;
text-align:center;
}

</style>


<body>


<div class="header">
Hindusthan Bank
</div>
<ul>
  <li><a class="active" href="#">Profile</a></li>
  <li><a href="credit.jsp">Credit</a></li>
  <li><a href="withdraw.jsp">Debit</a></li>
  <li><a href="transfer.jsp">Transfer</a></li>
   <li><a href="statements.jsp">Statements</a></li>
    <li><a href="creditcard.jsp">Credit Card</a></li>
</ul>
<div class="container">


<%
String userName=(String)session.getAttribute("username");
DetailsDao dd=new DetailsDao();
ResultSet rs=dd.getDetails(userName);

if(rs.next()){

%>

<div class="forms">
<div class="formImage">
<img src="function.png" width="500" height="500">
</div>

<div class="formContent">

<table>
<tr><td class="label1"><h2>PROFILE</h2></td></tr>
<tr><td class="label1">Name</td>
<td><%=rs.getString("name") %></td></tr>
<tr><td class="label1">UserName</td>
<td><%=rs.getString("userName") %></td></tr>
<tr><td class="label1">Account Number</td>
<td><%=rs.getString("account_number") %></td></tr>
<tr><td class="label1">Email</td>
<td><%=rs.getString("email") %></td></tr>
<tr><td class="label1">Phone Number</td>
<td><%=rs.getString("phone_number") %></td></tr>
<tr><td class="label1">Balance</td>
<td><%=rs.getString("amount") %></td></tr>
</table>

</div>
</div>
<%} %>



</body>
</html>