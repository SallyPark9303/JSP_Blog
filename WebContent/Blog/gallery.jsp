
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@page import="com.board.BoardDTO"%>
<%@page import="com.board.BoardDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html class="no-js" lang="zxx">

<head>
<%@include file="header.jsp" %>	
</head>

<body>
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
   
		<!-- header-end -->
	
		<!-- bradcam_area_start -->
		<div class="bradcam_area breadcam_bg overlay2">
				<h3>Gallery</h3>
			</div>
			<!-- bradcam_area_end -->

	<!-- Start Sample Area -->

	<!-- End Sample Area -->

	<!-- Start Button -->
	
	<!-- End Button -->

	<!-- Start Align Area -->
	<div class="whole-wrap">
		<div class="container box_1170">
			<div class="section-top-border">
				<h3>Image Gallery</h3>
				<div class="row gallery-item">
					<div class="col-md-4">
						<a href="img/elements/g1.jpg" class="img-pop-up">
							<div class="single-gallery-image" style="background: url(img/elements/g1.jpg);"></div>
						</a>
					</div>
					
					<!-- image start  -->
				
					<c:forEach items="${arrList }" var="item" varStatus="status">
						<div class="col-md-4">
						
						<a href="../upload/${item.filename }"  class="img-pop-up" alt="" >
					
						<div class="single-gallery-image" style="background: url(../upload/${item.filename });" ></div>
					</a>
				</div>
					</c:forEach>
				
					<!-- image end -->
				
				</div>
			</div>

							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Align Area -->
    <!-- footer -->
     <%@include file="footer.jsp" %>
		<!-- footer -->
		<!-- link that opens popup -->
	
		<!-- form itself end-->
	
		<!-- form itself end -->
	
		<!-- form itself end-->
	
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
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            disableDaysOfWeek: [0, 0],
        //     icons: {
        //      rightIcon: '<span class="fa fa-caret-down"></span>'
        //  }
        });
        $('#datepicker2').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
             rightIcon: '<span class="fa fa-caret-down"></span>'
         }

        });
        var timepicker = $('#timepicker').timepicker({
         format: 'HH.MM'
     });
    </script>
</body>
</html>