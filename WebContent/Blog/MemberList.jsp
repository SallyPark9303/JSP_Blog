

<%@page import="com.member.MemberDTO"%>
<%@page import="com.member.MemberDAO"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Hostza</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>
<script src="Blog.js"></script>
<script>

function del(email){
	$.getJSON("memAdminDelete.pr?email="+email,function(d){
		var htmlStr="";
		$.each(d,function(key,val){
		
			htmlStr+="<tr>";
			htmlStr+="<td>"+val.email+"</td>";
			htmlStr+="<td>"+val.nickname+"</td>";
			htmlStr+="<td onclick=del('"+val.email+"')>delete</td>";	
			
			htmlStr+="</tr>";
		})
		$("table tbody").html(htmlStr);
	})
		
}

</script>


<body>
  <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
    <header>
        <div class="header-area ">
          <div id="sticky-header" class="main-header-area">
            <div class="container-fluid p-0">
              <div class="row align-items-center no-gutters">
                <div class="col-xl-2 col-lg-2">
                  <div class="logo-img">
                    <a href="index.html">
                      <img src="img/logo.png" alt="" />
                    </a>
                  </div>
                </div>
                <div class="col-xl-7 col-lg-7">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">
										<li><a href="memView.pr">My account </a></li>
										<li><a class="active"  href="MemberList.jsp">Member account List </a></li>
									</ul>
									
								</nav>
					
							</div>
							
						</div>
							 <h5 style="color:white">${sessDto.nickname } administrator</h5 >
                         <div class="row align-items-center no-gutters">
              <ul class="navbar-nav ml-auto">
            
            <li class="nav-item dropdown mr-3">
             <a href="Login.jsp"
                 class="btn btn-primary btn-block"> 
                <i class="flaticon-user"></i><span> Logout</span>
              </a>
                </li>
          </ul> 
            </div>
                <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                  <div class="log_chat_area d-flex align-items-center">
                   
                  </div>
                </div>
                <div class="col-12">
                  <div class="mobile_menu d-block d-lg-none"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </header>
      
        <!-- header-end -->
    
        <!-- bradcam_area_start -->
        <div class="bradcam_area breadcam_bg overlay2">
        
             
                <br>
               </div>
            <!-- bradcam_area_end -->
    <!--================Blog Area =================-->
	<section class="blog_area section-padding">
		<div class="container">
			<div class="row">

				<div class="col-lg-8 mb-5 mb-lg-0">
					<div class="blog_left_sidebar">
						<article class="blog_item">
							<div class="blog_item_img"></div>

							<div class="blog_details">
								<div class="d-inline-block">


									<table>
										<thead>
											<tr>
												<th><h2 style="margin-right: 120px">Email</h2></th>
												<th><h2 style="margin-right: 120px">Nickname</h2></th>
												<th><h2>Delete</h2></th>
											</tr>
										</thead>


										<tbody>
											<c:forEach items="${arrList }" var="item">
												<tr>
													<td>${item.email }</td>
													<td>${item.nickname }</td>
													
	
													<td onclick="del('${item.email}')">delete</td>

												</tr>
											</c:forEach>
										</tbody>

									</table>
								</div>
							</div>
						</article>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Blog Area =================-->



    <!-- footer -->
    <footer class="footer">
   
		 <%@include file="footer.jsp" %>
        <!-- footer -->
        <!-- link that opens popup -->
    

    
        <!-- form itself end-->
      
      
        <!-- form itself end -->
<!-- form itself end -->
    <!-- JS here -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/gijgo.min.js"></script>

    <!--contact js-->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>

    <script src="js/main.js"></script>

</body>
</html>