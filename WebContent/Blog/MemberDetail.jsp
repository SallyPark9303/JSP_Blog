
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.member.MemberDTO"%>
<%@page import="com.member.MemberDAO"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

check=function(){
	if($("#pwd").val()==""){
		alert("Please enter your password.");
	$("#pwd").focus();
		return false;
	}
	
	if($("#pwd").val()!==$("#pwd_check").val()){
		alert("Your password does not match.");
		$("#pwd_check").focus();
		return false;
	}
	$("#frm").submit();	//action 한테 감
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
										<li><a class="active"  href="memView.pr">My account </a></li>
									
									</ul>
									
								</nav>
					
							</div>
							
						</div>
							 <h5 style="color:white">${sessDto.nickname }</h5 >
                         <div class="row align-items-center no-gutters">
              <ul class="navbar-nav ml-auto">
            
            <li class="nav-item dropdown mr-3">
             <a href="logout2.pr"
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
									<form action="memUpdate.pr" id="frm" method="post">
									<input type="hidden" name="email" id="email" value="${mdto.email }">

										<table>
											<thead>
												<tr>
													<th><h2 style="margin-right: 120px">Email</h2></th>
													<td><input type="text" name="email" id="email" size="40" value="${mdto.email }"></td> </tr>
													<tr><th><h2>Password</h2></th>
													<td><input type="password" name="pwd" id="pwd" size="20" value="${mdto.pwd }"></td> <br> 
													</tr>
													<tr><th><h2>Confirm your Password </h2></th>
													<td><input type="password" name="pwd_check" id="pwd_check" size="20" ></td> <br> 
													</tr>
													<tr><th><h2 style="margin-right: 120px">Nickname</h2></th>
															<td><input type="text" name="nickname" id="nickname" size="50" value="${mdto.nickname }"></td> 
												
												</tr>
											</thead>
											</div>
											<p>
											<tbody>
												<c:forEach items="${arrList }" var="item">
													<tr>
														<td>${item.email }</td>
														<td>${item.nickname }</td>
													</tr>
												</c:forEach>
											</tbody>
											</p>

											<tr>
												<td colspan="2" align="center">
													<input type="button" value="Profile Update" class="btn btn-primary btn-block" onclick="check()">
												<input  class="btn btn-danger btn-block" type="button" value="Cancel" onClick="history.go(-1)"> 
												</td>
											</tr>
										</table>
									</form>
								</div></article>
					</div>
        </div>
 
  
    </section>
    
    <!--================Blog Area =================-->



    <!-- footer -->
    <footer class="footer">
   
									     <div class="footer_top">
          <div class="container">
            <div class="row">
              <div class="col-xl-4 col-md-6 col-lg-4">
                <div class="footer_widget">
                  <div class="footer_logo">
                    <a href="#">
                      <img src="img/logo.png" alt="" />
                    </a>
                  </div>
                  <p class="footer_text doanar">
                    <a class="first" href="#">+10 0008 0000 </a> <br />
                    <a href="">yndg@support.com</a>
                  </p>
                  <div class="socail_links">
                    <ul>
                      <li>
                        <a href="https://www.facebook.com/" target="_blank">
                          <i class="fa fa-facebook-square"></i>
                        </a>
                      </li>
                      <li>
                        <a href="https://twitter.com/?lang=ko" target="_blank">
                          <i class="fa fa-twitter"></i>
                        </a>
                      </li>
                      <li>
                        <a
                          href="https://www.instagram.com/?hl=ko"
                          target="_blank"
                        >
                          <i class="fa fa-instagram"></i>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
  
              <div class="col-xl-3 col-md-6 col-lg-3">
                <div class="footer_widget">
                  <h3 class="footer_title">
                    Navigation
                  </h3>
                  <ul>
                    <li><a href="#test-form2">Join</a></li>
                    <li><a href="#test-form">Login</a></li>
                    <li><a href="/blog.html">Blog</a></li>
                    <li><a href="/gallery.html">Gallery</a></li>
                  </ul>
                </div>
              </div>
              <div class="col-xl-5 col-md-6 col-lg-5">
                <div class="footer_widget">
                  <h3 class="footer_title">
                    Newsletter
                  </h3>
                  <form action="#" class="newsletter_form">
                    <input type="text" placeholder="Enter your mail" />
                    <button type="submit">Sign Up</button>
                  </form>
                  <p class="newsletter_text">
                    Subscribe newsletter to get updates
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="copy-right_text">
          <div class="container">
            <div class="footer_border"></div>
            <div class="row">
              <div class="col-xl-12">
                <p class="copy_right text-center">
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                  Copyright &copy;
                  <script>
                    document.write(new Date().getFullYear());
                  </script>
                  All rights reserved | This template is made with
                  <i class="fa fa-heart-o" aria-hidden="true"></i> by
                  <a href="https://colorlib.com" target="_blank">Colorlib</a>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
              </div>
            </div>
          </div>
        </div>
      </footer>
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