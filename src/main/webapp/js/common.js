
$(function(){
    $(window).scroll(function(){
        if($(window).scrollTop() > 100){
            $("#gotop").fadeIn(1000);//一秒渐入动画
        }else{
            $("#gotop").fadeOut(1000);//一秒渐隐动画
        }
    });
     
    $('#gotop').click(function(){
        $('body,html').animate({scrollTop:0},'slow');
    });
}); 


function upvote(id){
	var url = "/home/upvote?id="+id
	$.ajax({
        type:'POST',
        url:url,
        dataType:'json',
        success:function(data){
        	var obj = eval(data);
        	if(obj.result == "ok") {
        		//alert(obj.upvoteCount);
        		//$(".love-count").html(obj.upvoteCount);
        		/* $(".post-love").addClass(".done .fa-heart-o:before"); */
        		setTimeout("location.reload()",500);
        	} 
        	if(obj.result == "not") {
        	}
        	if(obj.result == "error") {
        		alert("出了点小故障~");
        	}
        }
    })
}