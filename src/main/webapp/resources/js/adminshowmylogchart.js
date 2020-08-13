function submitSform(){ 
    var type=document.getElementsByName("type")[0].value;
	if("red1"==type){
		alert(type);
		actionUrl="/springmvc/adminredonechart.do"
	}else if("red2"==type){
		alert(type);
		actionUrl="/springmvc/adminredonechart.do"
	}else if("red3"==type){
		alert(type);
		actionUrl="/springmvc/adminredonechart.do"
	}else if("red4"==type){
		alert(type);
		actionUrl="/springmvc/adminredonechart.do"
	}else if("red5"==type){
		alert(type);
		actionUrl="/springmvc/adminredonechart.do"
	}else if("blue1"==type){
		alert(type);
		actionUrl="/springmvc/adminredonechart.do"
	}else if("blue2"==type){
		alert(type);
		actionUrl="/springmvc/adminredonechart.do"
	}
	var formElement = document.getElementById("sform");
    formElement.action = actionUrl;  
    formElement.submit(); 
}  

	
