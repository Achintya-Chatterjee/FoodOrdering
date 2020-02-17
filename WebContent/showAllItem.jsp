<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>All Items</title>
<link rel="stylesheet" href="css/mystyle.css">
<style>
	body
	{
     	background-image:  url("photos/407349.jpg");
     	background-size: cover;
    }
    .gap
    {
    	margin-top: -600px; 
    }
</style>
<meta charset="ISO-8859-1">
<title>index</title>

</head>
<body>
			<header>
			 	<jsp:include page="homemenu.jsp"></jsp:include>
			</header>
			
			<div class="grid">
			<h1> </h1>
	<div class="gap"></div>
	<div class="row">
			<c:forEach begin="1" end="12">
				<div class="column ">
				    <div class="content">
				      <img src="photos/1.jpg" alt="" >
				      <h4>Palak Panner</h4>
				      <p><font color="red"><del>210 Rs</del></font> 160 Rs</p>
				    </div>
				  </div>
			</c:forEach>
				  
				  
<!-- END GRID -->
    </div>
    </div>
</body>
</html>