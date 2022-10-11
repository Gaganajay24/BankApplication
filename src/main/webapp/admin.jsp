<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.perfios.dao.CreditCardDao" %>
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
	padding-left:10px;
	margin-top:5%;
	background-color:white;
	box-shadow: 5px 5px 10px 2px rgba(0,0,0,.8);
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

<script>
var id

	
function myDeleteFunction1(x) {
	
	
	  document.getElementById("table").deleteRow(x);
	  <%
	  CreditCardDao cd1=new CreditCardDao();
	 	cd1.updateStatus(3, "approved");
	  %>
	 
	}
function myDeleteFunction2(x) {
	
	var y = document.getElementById("table").rows[x].cells;
	  document.getElementById("table").deleteRow(x);
	  
	  cd.updateStatus(y[0],"rejected");
	}
	
<script type = "text/javascript" >
function preventBack() { window.history.forward(); }
setTimeout("preventBack()", 0);
window.onunload = function () { null };
</script>
</script>

<div class="header">
Hindusthan Bank
</div>




<%



%>
<div class="container">
<div class="forms">
<table id="table" >
<thead>
<tr>
<th>username</th>
<th>Name</th>
<th>Age</th>
<th>Adhar Card</th>
<th>Pan Card</th>
<th>Accept</th>
<th>Reject</th>


</tr>
</thead>

<%
CreditCardDao cd=new CreditCardDao();
ResultSet rs=cd.getData();
try{
while(rs.next()){

	if(rs.getString("status").equalsIgnoreCase("pending")){
	System.out.println(rs.getString(6)+","+rs.getString(2)+","+rs.getInt(3)+","+rs.getInt(1));
%>

<tr>
<td><%=rs.getString(6) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getInt(3)%></td>
<form action="CreditCardRetrieve">
<input type="hidden" name="id" value="<%=rs.getInt(1) %>">
<td><button>view</button></td>
</form>
<td><a href="getImage.jsp"><button type="submit">view</button></a></td>
<td>
<form action="CreditValues">
<input type="hidden" name="id" value="<%=rs.getInt(1)%>">
<input type="hidden" name="status" value="approved">
<button>accept</button>
</form>
</td>
<td><button onclick="myDeleteFunction2(<%=rs.getInt(1)%>)">reject</button></td>

</tr>
<%
	}
}
}
catch(Exception e){
	e.printStackTrace();
}
%>
</table>
</div>
<div class="advertisements">
<a href="Logout">logout</a>
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