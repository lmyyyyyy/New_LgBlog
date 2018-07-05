$(function () {
    $("#button").click(function(){
        var name = $("#contact-name").val().trim();
        var email = $("#contact-email").val().trim();
        var body = $("#contact-body").val().trim();
        if (name.length == 0) {
        	alert("用户名不能为空");
        	$("#contact-name").focus();
        	return false;
        }
        if (email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) == -1){
    		alert("邮箱格式不正确");
    		$("#contact-email").focus();
    		return false;
    	}
        if (body.length == 0) {
        	alert("内容不能为空");
        	$("#contact-body").focus();
        	return false;
        }
        var data={
        		"contactName":name,
        		"contactEmail":email,
        		"contactMessage":body,
        	}
        $.ajax({
            type:'POST',
            url:'/contact/send',
            data:JSON.stringify(data),
            dataType:'json',
            contentType:'application/json;charset=UTF-8',
            success:function(data){
            	var obj = eval(data);
            	if(obj.result == "ok") {
            		alert("发送成功");
            	} 
            	if(obj.result == "error") {
            		alert("发送失败");
            	}
            	if(obj.result == "name is null") {
            		alert("名字不能为空");
            	}
            	if(obj.result == "email is error") {
            		alert("邮箱格式不正确");
            	}
            	if(obj.result == "message is null") {
            		alert("内容不能为空");
            	}
            	window.location.href="/contact";
            }

        })
    });
});