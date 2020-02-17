<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

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
	</style>
	<meta charset="ISO-8859-1">
	<title>index</title>

</head>
<body>
			<header>
			 	<jsp:include page="homemenu.jsp"></jsp:include>
			</header>
			<div class="gap"></div>
			<!-- Slider -->
			<div class="container slider1">
			<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators" >
			    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
			    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
			    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
			  </ol>
			  <div class="carousel-inner" style="background-color: white">
			    <div class="carousel-item active">
			      <img src="photos/s1.jpg" class="d-block w-100" alt="..." style="height:400px;padding: 5px;">
			      <div class="carousel-caption d-none d-md-block">
			        <h5>First slide label</h5>
			        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
			      </div>
			    </div>
			    <div class="carousel-item" style="background-color: white">
			      <img src="photos/s2.jpg" class="d-block w-100" alt="..." style="height:400px;padding: 5px;">
			      <div class="carousel-caption d-none d-md-block">
			        <h5>Second slide label</h5>
			        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
			      </div>
			    </div>
			    <div class="carousel-item" style="background-color: white">
			      <img src="photos/s3.jpg" class="d-block w-100" alt="..." style="height:400px;padding: 5px;">
			      <div class="carousel-caption d-none d-md-block">
			        <h5>Third slide label</h5>
			        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
			      </div>
			    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
			<!-- Slider -->
			
			<jsp:useBean id="obj" class="bean.MenuItem"></jsp:useBean>
			
			<div class="grid">
			<h1> </h1>
			
			<div class="row">
				<c:forEach items="${obj.showAllMenuItem()}" var="mi">
				<div class="column ">
				    <div class="content">
				      <img src="photos/${mi.image}" alt="" >
				      <h4>${mi.itemname}</h4>
				      <p><font color="red"><del>160 Rs</del></font> ${mi.price} Rs</p>
				      <center><a href="addToCart?menuitem_id=${mi.menuitem_id}" class="btn">Add To cart</a></center>
				    </div>
				  </div>
			</c:forEach>			  
				
		    </div>
    </div>
    
     <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  
</body>


</html>