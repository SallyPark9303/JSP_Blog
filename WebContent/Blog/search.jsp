
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@page import="com.board.BoardDTO"%>
<%@page import="com.board.BoardDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
  <head>
  <%@include file="header.jsp" %>
  </head>
<script>
function dmdm(word){
	$.ajax({
		type  : "post",
		url : "postsearch.do",
		data: {"word" : word},
		success:function(data){		
			$("#SearchBoard").html(data);	
		},
		error : function(d){ alert("dd");}
		})	
}
function commentStr(coarea,num,idx){
	$("#"+coarea).css("display","block");
	$.ajax({
		url:"commentList.pr",
		data : {"num" : num},
	    type:"get",
	    success:function(data){
	    	
	    		data=$.parseJSON(data);
	    		var htmlStr="";
	    		htmlStr+="<table>";
	    		for(var i=0; i<data.length; i++){
	    			htmlStr+="<tr>";
	    			htmlStr+="<td>"+data[i].msg+"</td>";
	    			htmlStr+="<td>"+data[i].name+"</td>";
	    			htmlStr+="<td>"+data[i].regdate+"</td>";
	    			htmlStr+="</tr>";
	    		}
	    		htmlStr+="</table>";
	    		  $("#area"+idx).html(htmlStr);       	 
	    }	    		
	})
}

function commentInsertBtn(msg, num,idx){
  alert(msg +":" + num)	
  $.ajax({
		url:"commentInsert.pr",
	    type:"post",
	    data:{"msg":msg,"num":num},
	    success:function(d){
	    	if(d.trim()==1) {//로그인 안됨
	    		alert("Please login to add new comment.");
	    		location.href="/Login.pr";
	    		//절대경로 : http://localhost:8888/FirstJSP/member/loginForm.jsp
	    	}else{//로그인 됨
	        	alert(d);
		    	d=$.parseJSON(d);
	    		var htmlStr="";
	    		htmlStr+="<table>";
	    		for(var i=0; i<d.length; i++){
	    			htmlStr+="<tr>";
	    			htmlStr+="<td>"+d[i].msg+"</td>";
	    			htmlStr+="<td>"+d[i].name+"</td>";
	    			htmlStr+="<td>"+d[i].regdate+"</td>";
	    			htmlStr+="</tr>";
	    		}
	    		htmlStr+="</table>";
              $("#area"+idx).html(htmlStr); 
      		
	    	}
	    	    	
	    
	    }
	}	);	
}

	
</script>
  <body>
    <!--[if lte IE 9]>
      <p class="browserupgrade">
        You are using an <strong>outdated</strong> browser. Please
        <a href="https://browsehappy.com/">upgrade your browser</a> to improve
        your experience and security.
      </p>
    <![endif]-->

    <!-- header-start -->
  
    <!-- header-end -->

    <!-- bradcam_area_start -->
    <div class="bradcam_area2 breadcam_bg_2 ">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-xl-9">
            <div class="breadcam_text text-center">
              <h3>Search your Post</h3>
              <div class="find_dowmain">
                <form class="find_dowmain_form">
                  <input type="text" name="word" id="word" placeholder="Find your post"/>
                  <button id="search" onclick="dmdm($('#word').val())">Search</button>
                  <!-- <button id=search>search</button> -->
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- bradcam_area_end -->

    <!-- search_area_start -->
    <div class="search_area">
      <div class="container">
        <div class="row">
          <div class="col-xl-12">
            <div class="search_title">
              <h3>Search Result</h3>
            </div>
          </div>
          
          <div class="col-lg-8 posts-list">
               <div class="single-post">
                  <div class="feature-img">
       						   	<c:forEach items="${arrList }" var="item" varStatus="status">
									<img class="img-fluid" src="../upload/${item.filename }" alt="" width="500px" height="300px">
                  
					                  	<div class="blog_details">
					                  
						                  <h2>${item.title }</h2>
						
													<p class="excert">${item.description }</p>
													<ul class="blog-info-link mt-3 mb-4">
														<li><i class="fa fa-user"></i> ${item.writer}</li>
														<li><i class="fa fa-comments"></i><span onclick="commentStr('commentArea${status.index}',${item.num},${status.index})">Comments</span></li>
						
													</ul>
													<div id="area${status.index}"></div>
													<div align="center" id="commentArea${status.index}" style="display:none;">
														<textarea rows="2" cols="50" id="msg${status.index}"></textarea>   
														<input type="button" class="btn btn-primary btn-block"
															value="add comment" id="commentBtn" name="commentBtn" onclick="commentInsertBtn($('#msg${status.index}').val(),${item.num},${status.index})">
													</div>
						                  </div>
                                </c:forEach>
                                <div id="SearchBoard"></div>
                    </div>
                </div>
         
        </div>
      
      </div>
    </div>
    <!-- search_area_end -->

    <!-- have_question_start -->
    <div class="have_question"></div>
    <!-- have_question_end -->

    <!-- footer -->
 <%@include file="footer.jsp" %>
    <!-- footer -->
    <!-- link that opens popup -->

    <!-- form itself end-->
    <form id="test-form" class="white-popup-block mfp-hide">
      <div class="popup_box ">
        <div class="popup_inner">
          <div class="logo text-center">
            <a href="#">
              <img src="img/form-logo.png" alt="" />
            </a>
          </div>
          <h3>Sign in</h3>
          <form action="#">
            <div class="row">
              <div class="col-xl-12 col-md-12">
                <input type="email" placeholder="Enter email" />
              </div>
              <div class="col-xl-12 col-md-12">
                <input type="password" placeholder="Password" />
              </div>
              <div class="col-xl-12">
                <button type="submit" class="boxed_btn_green">Sign in</button>
              </div>
            </div>
          </form>
          <p class="doen_have_acc">
            Don't have an account?
            <a class="dont-hav-acc" href="#test-form2">Sign Up</a>
          </p>
        </div>
      </div>
    </form>
    <!-- form itself end -->

    <!-- form itself end-->
    <form id="test-form2" class="white-popup-block mfp-hide">
      <div class="popup_box ">
        <div class="popup_inner">
          <div class="logo text-center">
            <a href="#">
              <img src="img/form-logo.png" alt="" />
            </a>
          </div>
          <h3>Registration</h3>
          <form action="#">
            <div class="row">
              <div class="col-xl-12 col-md-12">
                <input type="email" placeholder="Enter email" />
              </div>
              <div class="col-xl-12 col-md-12">
                <input type="password" placeholder="Password" />
              </div>
              <div class="col-xl-12 col-md-12">
                <input type="Password" placeholder="Confirm password" />
              </div>
              <div class="col-xl-12">
                <button type="submit" class="boxed_btn_green">Sign Up</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </form>
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
