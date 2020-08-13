function checkId(){
	var re = /^[0-9]*$/;//判断字符串是否为数字//判断正整数/[1−9]+[0−9]∗]∗/
	if(""==document.getElementById("id").value){
		  alert("序号不能为空!");
	}else{
		document.getElementById("addform").submit();
	}
	/*else if ((""!=document.getElementById("home").value)&&(!re.test(document.getElementById("home").value))) { 
　　	  alert("请输入家庭数字"); 
  }else if (""!=document.getElementById("clothes").value&&!re.test(document.getElementById("clothes").value)) { 
	　　　　alert("请输入衣服数字"); 
	}else if (""!=document.getElementById("meal").value&&!re.test(document.getElementById("meal").value)) { 
	　　　　alert("请输入食物数字"); 
	}else if (""!=document.getElementById("room").value&&!re.test(document.getElementById("room").value)) { 
	　　　　alert("请输入住宿数字"); 
	}else if (""!=document.getElementById("trip").value&&!re.test(document.getElementById("trip").value)) { 
	　　　　alert("请输入交通数字"); 
	}else if (""!=document.getElementById("lifeuse").value&&!re.test(document.getElementById("lifeuse").value)) { 
	　　　　alert("请输入用品数字"); 
	}else if (""!=document.getElementById("play").value&&!re.test(document.getElementById("play").value)) { 
	　　　　alert("请输入娱乐数字"); 
	}else if (""!=document.getElementById("insurance").value&&!re.test(document.getElementById("insurance").value)) { 
	　　　　alert("请输入收入数字"); 
	}　　 */
}
