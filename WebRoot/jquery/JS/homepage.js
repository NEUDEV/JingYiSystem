/**
 * 
 */
charset="UTF-8"
function moveon(x,y)
{
	x.style.backgroundColor='#1693f1';
y.style.color='#fff';
}	
function moveout(x,y)
{
	x.style.background='#fff';
	if(y==document.getElementById('activenav'))
		y.style.color="#1693f1";	
	else y.style.color="#666";
}


$(document).ready(function(){
	  $("#homereg1").click(function(){
		    $("#box1").slideToggle(600);
		    
	        $("#box2").hide();
	        $("#box3").hide();
	        $("#box4").hide();
	        $("#box5").hide();
	        $("#box6").hide();
	        $("#box7").hide();
	        $("#box8").hide();
	  });
	});
$(document).ready(function(){
	  $("#homereg2").click(function(){
	    $("#box2").slideToggle(600);

        $("#box1").hide();
        $("#box3").hide();
        $("#box4").hide();
        $("#box5").hide();
        $("#box6").hide();
        $("#box7").hide();
        $("#box8").hide();
	  });
	});

$(document).ready(function(){
	  $("#homereg3").click(function(){
	    $("#box3").slideToggle(600);

      $("#box1").hide();
      $("#box2").hide();
      $("#box4").hide();
      $("#box5").hide();
      $("#box6").hide();
      $("#box7").hide();
      $("#box8").hide();
	  });
	});

$(document).ready(function(){
	  $("#homereg4").click(function(){
	    $("#box4").slideToggle(600);

      $("#box1").hide();
      $("#box3").hide();
      $("#box2").hide();
      $("#box5").hide();
      $("#box6").hide();
      $("#box7").hide();
      $("#box8").hide();
	  });
	});

$(document).ready(function(){
	  $("#homereg5").click(function(){
	    $("#box5").slideToggle(600);

    $("#box1").hide();
    $("#box3").hide();
    $("#box2").hide();
    $("#box4").hide();
    $("#box6").hide();
    $("#box7").hide();
    $("#box8").hide();
	  });
	});
$(document).ready(function(){
	  $("#homereg6").click(function(){
	    $("#box6").slideToggle(600);

  $("#box1").hide();
  $("#box3").hide();
  $("#box2").hide();
  $("#box4").hide();
  $("#box5").hide();
  $("#box7").hide();
  $("#box8").hide();
	  });
	});
$(document).ready(function(){
	  $("#homereg7").click(function(){
	    $("#box7").slideToggle(600);

$("#box1").hide();
$("#box3").hide();
$("#box2").hide();
$("#box4").hide();
$("#box5").hide();
$("#box6").hide();
$("#box8").hide();
	  });
	});
$(document).ready(function(){
	  $("#homereg8").click(function(){
	    $("#box8").slideToggle(600);

$("#box1").hide();
$("#box3").hide();
$("#box2").hide();
$("#box4").hide();
$("#box5").hide();
$("#box7").hide();
$("#box6").hide();
	  });
	});


$(document).ready(function(){
	  $("#infoslide").click(function(){
		    if($('#infoslide').attr('src') == 'images/fang.png'){
		        $('#infoslide').attr('src', 'images/shou.png');
		    }else{
		        $('#infoslide').attr('src', 'images/fang.png');
		    }
		  
		    $("#info").slideToggle(600);
		    
	  });
	});

$(document).ready(function(){
	  $(".btn_gotop").click(function(){
		  $("html,body").scrollTop(0);
	  });
	});