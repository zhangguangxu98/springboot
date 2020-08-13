function checkPassword(){
	var pwd1=document.getElementById("password").value;
	var pwd2=document.getElementById("password1").value;
	if(pwd1!=pwd2){
		document.getElementById("adminaddemployee3").innerHTML="check your password!";
	}else{
		document.getElementById("adminaddemployee3").innerHTML="your password is right";
	}
}
