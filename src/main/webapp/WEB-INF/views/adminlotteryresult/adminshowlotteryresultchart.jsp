<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    <base href="<%=basePath%>">

    <title>个人管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminhome.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminshowalllotteryresult.css">
	<script type="text/javascript" src="../springboot/resources/js/adminshowlotteryresultchart.js"></script>
	<script type="text/javascript" src="../springboot/resources/My97DatePicker/WdatePicker.js"></script>
  </head>
<jsp:include page="../adminhome/adminheader.jsp"/>
<body>
	<div class="adminhome21">
          <table>
                 <tr>
                      <td>
                          <div>
                          		<jsp:include page="../adminhome/adminnavigator.jsp"/>
                          </div>
                     	</td>
                     	<td class="adminshowallproject">
                     	    <div>
                     	          <form action="showlotteryresultchart" method="post" id="sform">
	                                   <table class="adminshowallproject4">
											   <tr>
												   <td>
		                                               	起始日期:
		                                           </td>
		                                           <td>
			                                           <input type="text" style="width: 100px; height: 30px;" name="startdate" id="startdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate">
			                                       </td>
			                                       <td>
		                                               	结束日期:
		                                           </td>
		                                           <td>
			                                           <input type="text" style="width: 100px; height: 30px;" name="enddate" id="enddate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate">
			                                       </td>
			                                       <td>
		                                               	彩票类型:
		                                           </td>
			                                       <td>
			                                       	   <select style="width: 100px; height: 30px;" name="type" id="type" >
										                              <option>red1</option>
										                              <option>red2</option>
										                              <option>red3</option>
										                              <option>red4</option>
										                              <option>red5</option>
										                              <option>blue1</option>
										                              <option>blue2</option>
										               </select> 
										           </td>
											       <td>
												       <!-- <input type="submit" value="showChart" onclick="submitSform()"/> -->
												       <input type="button" value="显示柱状图表" onclick="showBar()"/>
												   </td>
												   
											   </tr>
									   </table>
								   </form>
                     	    </div>
                     		<div>
                     			<div id="container" style="height: 300px"></div> 
                     		</div>
                     	</td>
                  </tr>
            </table>
      </div>
</body>
<script type="text/javascript" src="../springboot/resources/js/echarts.min.js"></script>
<script type="text/javascript" src="../springboot/resources/js/jquery-1.10.2.min.js"></script>
       <script type="text/javascript">
       //页面加载   获取全部信息
       function showBar() {
           $.ajax({
               type: "POST",//请求方式
               url: "showlotteryresultchart",//地址，就是json文件的请求路径
               dataType: "json",//数据类型可以为 text xml json  script  jsonp
               data:  {"startdate": $("#startdate").val(), "enddate": $("#enddate").val(), "type": $("#type").val()},
               success: function(result){//返回的参数就是 action里面所有的有get和set方法的参数  
            	   var keyAry = [];
            	   var valueAry = [];
            	   for(var key in result){
            	       keyAry.push(key);
            	       valueAry.push(result[key]);
            	   }
	               	var dom = document.getElementById("container");
	               	var myChart = echarts.init(dom);
	               	var app = {};
	               	option = null;
	               	app.title = '坐标轴刻度与标签对齐';
	
	               	option = {
	               		    xAxis: {
	               		        type: 'category',
	               		        data: keyAry,
	               		    },
	               		    yAxis: {
	               		        type: 'value'
	               		    },
	               		    series: [{
	               		    	label: {
		               	             normal: {
		               	                 show: true,
		               	                 position: 'top'
		               	             }
		               	        },
	               		    	data: valueAry,
	               		        type: 'bar',
	               		     	areaStyle: {},
	               		    }]
	               		};

	               	if (option && typeof option === "object") {
	               	    myChart.setOption(option, true);
	               	}
               }
           });
       };
       </script>
<jsp:include page="../adminhome/adminfooter.jsp"/>
</html>