

$(document).ready(function(){
  $(".btn_gotop").click(function(){
	  $("html,body").scrollTop(0);
  });
});


$(document).ready(function(){
  $("#index_scroll_bottom1").click(function(){
    $("#index_scroll_down1").slideToggle();
  });
});
$(document).ready(function(){
  $("#index_scroll_bottom2").click(function(){
    $("#index_scroll_down2").slideToggle();
  });
});
$(document).ready(function(){
  $("#index_scroll_bottom3").click(function(){
    $("#index_scroll_down3").slideToggle();
  });
});
$(document).ready(function(){
  $("#index_scroll_bottom4").click(function(){
    $("#index_scroll_down4").slideToggle();
  });
});

$(document).ready(function(){
  $(window).scroll(function() {
var scroll_top=$(window).scrollTop();
if(scroll_top>=300){
    $(".header_box").css("position","fixed");
$(".header_box").css("top","0");
$(".header_box").css("background-color","#fff");
$(".header_box").css("z-index","999");
}

else{$(".header_box").css("position","relative");}

  });
});