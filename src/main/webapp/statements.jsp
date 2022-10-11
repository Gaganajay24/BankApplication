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
  margin-left:340px;
  border-radius: 25px;
  cursor: pointer;
  outline: none;

}

.inplabel{
font-size:20px;
font-weight:bold;
padding: 12px 20px;
}

.date{
display:block;
text-align:center;
font-size:20px;
font-weight:bold;
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

<a href="transfer.jsp">
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
<form action="statementsDisplay.jsp">
<h1></h1><br><br><br>
<div class="date">
<label class="inplabel">From date</label>
<input type="date" name="from_date"><br><br>
</div>
<div class="date">
<label class="inplabel">To date</label>
<input type="date" name="to_date"><br><br>
</div>
<button type="submit" class="loginbutton">Statements</button>
</form>
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