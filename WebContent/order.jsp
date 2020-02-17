<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<link rel="stylesheet" href="css/mystyle.css">
	<style>
		body
		{
	     	background-image:  url("photos/407349.jpg");
	     	background-size: cover;
	    }
	    .gap
	    {
	    	margin-top: -450px; 
	    }
	    h5,p
	    {
	    	color:white;
	    	font-size: 20px;
	    }
	    .mytable
	    {
	    	width:45%;
	    	margin-left: 20%;
	    	padding: 20%;
	    	font-size:20px;
	    	float:right;
	    }
	</style>
</head>
<body>
			<header>
			 	<jsp:include page="homemenu.jsp"></jsp:include>
			</header>
			<div class="gap"></div>
	<form action="">
		<table class="mytable">
			<tr>
				<th>OrderId</th>
				<th>EmailId</th>
				<th>Name</th>
				<th>Address</th>
				<th>Contact</th>
				<th>Date&Time</th>
				<th>Action</th>
			</tr>
			<tr>
				<td>1</td>
				<td>ak@gmail.com</td>
				<td>Anup</td>
				<td>Belgharia</td>
				<td>8981881924</td>
				<td>19:11:19-05:40</td>
				<td>View</td>
			</tr>
		</table>
	</form>
</body>
</html>