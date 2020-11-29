function submitForm(actionUrl){  
    var formElement = document.getElementById("sform");  
    formElement.action = actionUrl;  
    formElement.submit();  
} 

// 第一页  
function firstPage(){  
    if(currentPage == 1){  
        alert("已经是第一页数据");  
        return false;  
    }else{  
        submitForm("/springboot/adminshowallmylog?pageNum=1"+"&pageSize=10");
        return true;  
    }  
}  
  
// 下一页  
function nextPage(){  
	if(currentPage == totalPage){  
        alert("已经是最后一页数据");  
        return false;  
    }else{  
        submitForm("/springboot/adminshowallmylog?pageNum=" + (currentPage+1)+"&pageSize=10");
        return true;  
    }  
}  
  
// 上一页  
function previousPage(){  
    if(currentPage == 1){  
        alert("已经是第一页数据");  
        return false;  
    }else{  
        submitForm("/springboot/adminshowallmylog?pageNum=" + (currentPage-1)+"&pageSize=10");
        return true;  
    }  
}  
  
// 尾页  
function lastPage(){  
    if(currentPage == totalPage){  
        alert("已经是最后一页数据");  
        return false;  
    }else{  
        submitForm("/springboot/adminshowallmylog?pageNum="+totalPage+"&pageSize=10");
        return true;  
    }  
}

//跳转
function jumpPage(){  
	var jumppage=document.getElementById("jumppage").value; 
	var r = /^\+?[1-9][0-9]*$/;　　//正整数
	var flag=r.test(jumppage);
	if(flag){
		submitForm("/springboot/adminshowallmylog?pageNum="+jumppage+"&pageSize=10");
	    return true;  
	}else{
		alert("请输入数字");
	}
}

//设置
function setPage(){  
	var jumppage=document.getElementById("jumppage").value;
	var pagesize=document.getElementById("pagesize").value; 
	var r = /^\+?[1-9][0-9]*$/;　　//正整数
	var flag=r.test(pagesize);
	var flag1=r.test(jumppage);
	if(!flag1){
		jumppage=1;
	}
	if(flag){
		submitForm("/springboot/adminshowallmylog?pageNum="+jumppage+"&pageSize="+pagesize);
	    return true;  
	}else{
		alert("请输入数字");
	}
}
    
//全选
function selectAllCheckBox(){
		var select=document.getElementById("input_checkbox");
		var allcheckBoxs=document.getElementsByName("tduCheckBox");
		if(select.checked){
			for(var i=0;i<allcheckBoxs.length;i++){
				allcheckBoxs[i].checked=true;
			}
		}else{
			for(var i=0;i<allcheckBoxs.length;i++){
				allcheckBoxs[i].checked=false;
			}
		}
}

function submitDelForm(){
	if(!confirm("确认要删除？")){
		window.event.returnValue=false;
	}else{
		var formElement = document.getElementById("delform");
		formElement.submit();
	}
}

function beforeAdd(){
		window.location.href="/springboot/adminbeforeaddmylog";
}
	
