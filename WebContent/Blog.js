
$(function() {
		$("#loginBtn").click(function() {
			if ($("#userid").val() == "") {
				alert("아이디를 입력하세요");
				$("#userid").focus();
				return false;
			}
			if ($("#pwd").val() == "") {
				alert("비밀번호를  입력하세요");
				$("#pwd").focus();
				return false;
			}
			$.ajax({
				type : "post",
				url : "login.go",
				data : {
					"userid" : $("#userid").val(),
					"pwd" : $("#pwd").val()
					},
				success : function(data) {
				if(data.trim()==-1) {
					alert("회원이 아님.회원가입하세요.");
					location.href="memInsert.go";
					
				}else if(data.trim()==0){
					alert("일반회원 로그인");
					location.href="memView.go";
				
				}else if(data.trim()==1){
					alert("관리자 로그인");
					location.href="memList.go";
				}else if(data.trim()==2){
					alert("비밀번호를 확인하세요.");
				}
			},
				error : function(e) {
					alert("error : " + e);
				}
			})
		})

	})






var exp=/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/
$(function(){
	$("#send").click(function(){
		if($("#name").val()=="") {
			alert("이름을 입력하세요");
			$("#name").focus();
			return false; 
		}

		if($("#userid").val()=="") {
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}
		if($("#pwd").val()=="") {
			alert("암호를 입력하세요");
			$("#pwd").focus();
			return false;
		}
		if($("#pwd").val()!=$("#pwd_check").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd_check").focus();
			return false;
		}
		

		if($("#email").val()=="") {
			alert("이메일를 입력하세요");
			$("#email").focus();
			return false;
		}
	
		if(!$("#phone").val().match(exp)){
			alert("전화번호 입력 양식이 아닙니다.");
			$("#phone").focus();
			return false;
			
		}

		$("#frm").submit();
	})

	//중복체크버튼
	$("#idBtn").click(function(){
		window.open("idCheck.go","","width=800 height=500")
	})	
})




	