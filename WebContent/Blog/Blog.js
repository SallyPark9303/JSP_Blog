var exp=/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/
	

	$(function() {
			$("#loginBtn").click(function() {
				if ($("#email").val() == "") {
					alert("Please enter your email.");
					$("#email").focus();
					return false;
				}
				if ($("#pwd").val() == "") {
					alert("Please enter your password.");
					$("#pwd").focus();
					return false;
				}
				$.ajax({
					type : "post",
					url : "login.pr",
					data : {
						"email" : $("#email").val(),
						"pwd" : $("#pwd").val()
						},
					success : function(data) {
						if(data.trim()==-1) {
						alert("Your account dose not exist. please create new account.");
						location.href="#";
						
					}else if(data.trim()==0){
						alert("Login success");
						location.href="postList.pr";
					
					}else if(data.trim()==1){
						alert("Admin Login success");
						location.href="memList.pr";
					}else if(data.trim()==2){
						alert("Please confirm your password again.");
					}
				},
					error : function(e) {
						alert("error : " + e);
					}
				})
			})
			
			$("#RegistrationBtn").click(function(){
				if($("#email").val()==""){
					alert("Please enter your email.");
					$("#email").focus();
					return false;
				}
				if($("#pwd").val()=="") {
					alert("Please enter your password.");
					$("#pwd").focus();
					return false;
					
				}
				if($("#pwd").val()!=$("#pwd_check").val()) {
					alert("Password that you entered does not match.");
					$("#pwd_check").focus();
					return false;
				}
				$("#frm2").submit();
				
			})

		})

