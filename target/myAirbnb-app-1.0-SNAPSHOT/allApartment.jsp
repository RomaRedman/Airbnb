<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html >
  <head>
    <meta charset="UTF-8">
    <title>My AirBnB</title>
    <link rel='stylesheet prefetch' href='http://tympanus.net/Blueprints/AnimatedHeader/css/default.css'>

        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <link rel="stylesheet" type="text/css" href="../css/reset.css">
            <link rel="stylesheet" type="text/css" href="../css/responsive.css">

            <script type="text/javascript" src="../js/jquery.js"></script>
  </head>

  <body>

    <div class="container">
  <div class="cbp-af-header">
    <div class="cbp-af-inner">
        <!--Fixed</h1>-->
      <!--<a href="../" class="logo"><img src="../img/logo.png"></a>-->
        <nav>
            <a href="login.jsp">Login</a>
            <a href="#">Look Apartments</a>
            <a href="#">Pears</a>
            <a href="#">Oranges</a>
        </nav>
    </div>
  </div>
  <header class="clearfix">
				<span>Blueprint <span class="bp-icon bp-icon-about" data-content="The Blueprints are a collection of basic and minimal website concepts, components, plugins and layouts with minimal style for easy adaption and usage, or simply for inspiration."></span></span>
				<h1>On-Scroll Animated Header</h1>
			</header>
  <div class="main" >
				<section class="listings">
                    <div class="wrapper">
                        <ul class="properties_list">
                            <c:forEach var='apartment' items='${apartmentsList}' varStatus='iterator' >
                               <c:set var='picture' value='img/property_1.jpg' />
                                <li>
                                <a href="#">
                                                        <img src=${picture} alt="" title="" class="property_img"/>
                                                    </a>
                                    <span class="price">${apartment.getHost()}$</span>
                                    <div class="property_details">
                                        <h1>
                                            <a href="#">${apartment.getCity()}</a>
                                        </h1>
                                        <h2>Type: ${apartment.getApartType()} <span class="property_size"> City: ${apartment.getCity()}</span></h2>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="more_listing">
                            <a href="#" class="more_listing_btn">View More Listings</a>
                        </div>
                    </div>
                </section>
			</div>
</div>-->
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://tympanus.net/Blueprints/AnimatedHeader/js/classie.js'></script>

        <script src="../js/index.js"></script>

    
    
    
  </body>
</html>
