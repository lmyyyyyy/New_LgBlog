$(function () {
            $("#button").click(function(){
            	var bId = $("#bId").val().trim();
                var name = $("#comment-name").val().trim();
                var email = $("#comment-email").val().trim();
                var body = $("#comment-body").val().trim();
                if (name.length == 0) {
                	alert("用户名不能为空");
                	$("#comment-name").focus();
                	return false;
                }
                if (email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) == -1){
            		alert("邮箱格式不正确");
            		$("#comment-email").focus();
            		return false;
            	}
                if (body.length == 0) {
                	alert("内容不能为空");
                	$("#comment-body").focus();
                	return false;
                }
                var data={
                		"lgBlogId":bId,
                		"replyUsername":name,
                		"replyEmail":email,
                		"replyContent":body,
                	}
                $.ajax({
                    type:'POST',
                    url:'/reply/send',
                    data:JSON.stringify(data),
                    dataType:'json',
                    contentType:'application/json;charset=UTF-8',
                    success:function(data){
                    	var obj = eval(data);
                    	var id = obj.blogId;
                    	/* if(obj.result == "ok") {
                    		alert("发送成功");
                    	}  */
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
                    	window.location.href="/single/"+id;
                    }

                })
            });
        });
$(function() {
    $(".pay_item").click(function() { 
	    $(this).addClass('checked').siblings('.pay_item').removeClass('checked'); 
	    var dataid = $(this).attr('data-id'); 
	    $(".shang_payimg img").attr("src", "../img/" + dataid + "img.png"); 
	    $("#shang_pay_txt").text(dataid == "alipay" ? "支付宝" : "微信"); 
	});
});
function dashangToggle() {
    $(".hide_box").fadeToggle();
    $(".shang_box").fadeToggle();
}
