<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.sql.ResultSet"%>
   <%@ page import="com.perfios.dao.TransactionStatements" %>
   <%@ page import="java.sql.Date" %>
   <%@ page import="com.perfios.dao.NameDao" %>
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
 text-align: center;
    font-size:85px;
    background-color:black;
    color:white;
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

.advertisements{
margin-left:10%;
margin-top:5%;
display:block;
justify-content:right;
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


    text-align:left;
	width:100%;
	height:500px;
	margin-left:200px;
	
	margin-top:5%;
	background-color:white;
	box-shadow: 5px 5px 10px 2px rgba(0,0,0,.8);
	 overflow-y: auto; 
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

table{
 border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

</style>
<body>
<div class="header">
Hindusthan Bank
</div>

<div class="container">
<div class="buttons">
<a href="credit.jsp">
<button class="menu" type="submit">CREDIT</button>
</a>

<a href="withdraw.jsp">
<button class="menu" type="submit">DEBIT</button>
</a>

<a href="tranfer.jsp">
<button class="menu" type="submit">TRANSFER</button>
</a>

<a href="statements.jsp">
<button class="menu" type="submit">STATEMENTS</button>
</a>

<a href="functionality.jsp">
<button class="menu" type="submit">PROFILE</button>
</a>

<a href="creditcard.jsp">
<button class="menu" type="submit">CREDIT CARD</button>
</a>
</div>
<div class="forms">

<table  >
<thead>
<tr>
<th>Date</th>
<th>To</th>
<th>Amount</th>
<th>Transfer Type</th>


</tr>
</thead>
<%

String username=(String)session.getAttribute("username");

Date from_date = Date.valueOf(request.getParameter("from_date"));
Date to_date = Date.valueOf(request.getParameter("to_date"));

try {
TransactionStatements ts=new TransactionStatements();
NameDao nd=new NameDao();
ResultSet rs=ts.getBetweenStatements(username,from_date,to_date);
while(rs.next()) {

	
	if(rs.getString(1).equals(username)){
		
		
		ResultSet rs1=ts.getAllTransactionStatements(username);
		
		while(rs1.next()){
	
		String name=nd.getName(rs1.getLong(1));
		if(name.equals(nd.getName(username))){
			name="self";
		}
		if(rs1.getString(3).equalsIgnoreCase("debit")){
%>

<tr style="background-color:pink">
<td><%=rs1.getString(4) %></td>
<td><%=name %></td>
<td><%=rs1.getDouble(2) %></td>
<td><%=rs1.getString(3) %></td>
</tr>

<%
		}
		else{
			
			
		


%>
<tr style="background-color:green">
<td><%=rs1.getString(4) %></td>
<td><%=name %></td>
<td><%=rs1.getDouble(2) %></td>
<td><%=rs1.getString(3) %></td>
</tr>

<%} %>

<% 
		}
}


}
}
catch(Exception e) {
	e.printStackTrace();
}
%>
</table>

</div>
<div class="advertisements">
<div class="col">
<h2>Inverstments</h2>
<p>We pjkdnjdbjhcdkjnckjdjasdksmn khsd9rkwdkln shdshodsdowudowjd shshdsdoiodidhidhw</p>
</div>
<div class="col">
<h2>Loans</h2>
<p>gsgdushdks shdisfyisn shdshdisdow shdisdsjdosjdosdj hdisydsydishdjdj</p>
</div>


<div class="col">
<h2>Stocks</h2>
<p>hjhdsdsd shdsutushj kdgsiutddshd shisydsydiwdiwd shshdisudiwud</p>
</div>
</div>
</div>

</body>
</html>