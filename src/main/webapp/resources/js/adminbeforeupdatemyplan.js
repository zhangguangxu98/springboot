function checkId(){
	if(""==document.getElementById("id").value){
		alert("序号不能为空!");
	}else{
		document.getElementById("addform").submit();
	}
}
