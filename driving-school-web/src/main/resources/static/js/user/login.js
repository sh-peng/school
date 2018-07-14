$(function(){

  var $document = $(document);
  //登录
  $document.on('click','.btn-success',function(){
		 var userName = $("#userName").val();
		 var pwd = $("#pwd").val();
		 validator(userName,pwd)
		 $.ajax({
		    	type:"POST",
		        url: '/driving-school/loginAction',
		        data:{
		        	userName:userName,
		        	userPwd:pwd
		        },
		        success: function (data) {
		        	if ("NOT_USER_ERROR" == data) {
						$("#errorMsg").html("用户名不存在");
					}
		        	if ("NOT_PWD_ERROR" == data) {
		        		$("#errorMsg").html("输入密码错误");
					}
		        	if ("SUCCESS" == data) {
		        		$("#errorMsg").html("");
		        		window.location.href = "/driving-school/index";
					}
		        },
		        error: function (err) {
		          console.log("获取分页数据失败" + err)
		        }
		})
  });
  
  //退出登录
  $document.on('click','#outLogin',function(){ 
		$.ajax({
	    	type:"POST",
	        url: '/driving-school/outLoginAction',
	        success: function (data) {
	        	if ("SUCCESS" == data) {
	        		window.location.href = "/driving-school/login";
				}
	        },
	        error: function (err) {
	          console.log("获取分页数据失败" + err)
	        }
		});
  });
  
  
  //用户名输入框获得焦点清空错误提示信息
  $document.on('focus','#userName',function(){ 
	  $("#errorMsg").html("");
  });
  
  //密码输入框获得焦点清空错误提示信息
  $document.on('focus','#pwd',function(){ 
	  $("#errorMsg").html("");
  });
  
  //验证用户名密码
  function validator(userName,pwd){
	if (userName == "") {
		$("#errorMsg").html("用户名不能为空");
		return false;
	}
	if (pwd == "") {
		$("#errorMsg").html("用户密码不能为空");
		return false;
	}
	return true;
  }
 
});