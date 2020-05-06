<!DOCTYPE html>
<html class="no-js" lang="zxx">
  <head>
 <%@include file="header.jsp" %>
   <script>
  function Loadfunc(value){
	  var reader = new FileReader();
	  reader.onload= function(e){
		  $("#LoadImg").attr('src', e.target.result);
     }
	 reader.readAsDataURL(value.files[0]);

  }


  </script>
  </head>

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
    <div class="bradcam_area breadcam_bg overlay2">
      <h3>Post</h3>
    </div>
    <!-- bradcam_area_end -->

    <!-- post -->
    <div class="container">
      <div class="row">
        <div class="col-md-12 col-md-offset-2">
          <div class="card my-5">
            <h5 class="card-header">Post</h5>
            <div class="card-body">
              <form action="create.pr" method="post" enctype="multipart/form-data">
                <div class="form-group">
                  <label for="images"
                    >images<span>*</span> <small>(Upload images.)</small><input type="file" name="profile_image" id="profile_image" value accept="image/*" onchange="Loadfunc(this)" ></label>
                    <br>
                 <img id="LoadImg"> 
                </div>

                <div class="form-group">
                  <label for="title">Title <span>*</span></label>
                  <input
                    type="text"
                    class="form-control"
                    required="required"
                    name="title"
                  />
                </div>

                <div class="form-group">
                  <label for="description">Description</label>
                  <textarea
                    rows="5"
                    class="form-control"
                    name="description"
                    required="required"
                  ></textarea>
                </div>
                <div class="form-group">
                  <input type="submit" class="btn btn-primary" value="Create">
                   
                  <button class="btn btn-default">
                    Cancel
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- post end -->

    <!-- have_question_statr -->

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
            Don'€™t have an account?
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
       
        </div>
      </div>
    </form>
    <!-- form itself end -->

  </body>
</html>
