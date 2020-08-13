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
        submitForm("/springboot/adminshowalllotteryresult?pageNum=1");
        return true;  
    }  
}  
  
// 下一页  
function nextPage(){  
	if(currentPage == totalPage){  
        alert("已经是最后一页数据");  
        return false;  
    }else{  
        submitForm("/springboot/adminshowalllotteryresult?pageNum=" + (currentPage+1));
        return true;  
    }  
}  
  
// 上一页  
function previousPage(){  
    if(currentPage == 1){  
        alert("已经是第一页数据");  
        return false;  
    }else{  
        submitForm("/springboot/adminshowalllotteryresult?pageNum=" + (currentPage-1));
        return true;  
    }  
}  
  
// 尾页  
function lastPage(){  
    if(currentPage == totalPage){  
        alert("已经是最后一页数据");  
        return false;  
    }else{  
        submitForm("/springboot/adminshowalllotteryresult?pageNum="+totalPage);
        return true;  
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
	
	
