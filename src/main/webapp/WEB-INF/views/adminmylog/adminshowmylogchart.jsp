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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminshowmylogchart.css">
	<script type="text/javascript" src="../springboot/resources/js/adminshowmylogchart.js"></script>
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
											       <!-- <input type="submit" value="showChart" onclick="submitSform()"/> -->
											       <input type="button" value="显示柱状图表" onclick="showBar()" style="height: 30px"/>
											   </td> 
											   <td>
											       <!-- <input type="submit" value="showChart" onclick="submitSform()"/> -->
											       <input type="button" value="显示饼状图表" onclick="showPie()" style="height: 30px"/>
											   </td> 
										   </tr>
								   </table>
                     	    </div>
                     		<div id="container" style="height: 300px"></div>
                     	</td>
                  </tr>
            </table>
      </div>
	<script type="text/javascript" src="../springboot/resources/js/echarts.min.js"></script>
	<script type="text/javascript" src="../springboot/resources/js/jquery-1.10.2.min.js"></script>
       <script type="text/javascript">
       //页面加载   获取全部信息
       function showBar() {
           $.ajax({
               type: "POST",//请求方式
               url: "showmylogchart",//地址，就是json文件的请求路径
               dataType: "json",//数据类型可以为 text xml json  script  jsonp
               data:  {"startdate": $("#startdate").val(), "enddate": $("#enddate").val()},
               success: function(result){//返回的参数就是 action里面所有的有get和set方法的参数  
	               
	               	var dom = document.getElementById("container");
	               	var myChart = echarts.init(dom);
	               	var app = {};
	               	option = null;
	               	app.title = '坐标轴刻度与标签对齐';
	
	               	option = {
	               	    color: ['#3398DB'],
		               	 title: {
		                     text: '个人收支',
		                     subtext: '参考',
		                     left: 'center'
		                 },
	               	    tooltip : {
	               	        trigger: 'axis',
	               	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	               	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	               	        }
	               	    },
	               	    grid: {
	               	        left: '3%',
	               	        right: '4%',
	               	        bottom: '3%',
	               	        containLabel: true
	               	    },
	               	    xAxis : [
	               	        {
	               	            type : 'category',
	               	            data : ['家庭', '衣服', '食物', '住宿', '交通', '用品', '娱乐', '税后收入', '税前收入','支出'],
	               	            axisTick: {
	               	                alignWithLabel: true
	               	            }
	               	        }
	               	    ],
	               	    yAxis : [
	               	        {
	               	            type : 'value'
	               	        }
	               	    ],
	               	    series : [
	               	        {
	               	        	label: {
	               	             normal: {
	               	                 show: true,
	               	                 position: 'top'
	               	             }
	               	         	},
	               	         	
	               	        	name:'直接访问',
	               	            type:'bar',
	               	            barWidth: '60%',
	               	            data:result
	               	        }
	               	    ]
	               	};
	               	;
	               	if (option && typeof option === "object") {
	               	    myChart.setOption(option, true);
	               	}
               }
           });
       };
     //页面加载   获取全部信息
       function showPie() {
           $.ajax({
               type: "POST",//请求方式
               url: "showmylogchart",//地址，就是json文件的请求路径
               dataType: "json",//数据类型可以为 text xml json  script  jsonp
               data:  {"startdate": $("#startdate").val(), "enddate": $("#enddate").val()},
               success: function(result){//返回的参数就是 action里面所有的有get和set方法的参数  
	               
	               	var dom = document.getElementById("container");
	               	var myChart = echarts.init(dom);
	               	var app = {};
	               	option = null;
	               	app.title = '坐标轴刻度与标签对齐';
	
	               	option = {
               		    title : {
               		        text: '支出比例',
               		        subtext: '参考',
               		        x:'center'
               		    },
               		    tooltip : {
               		        trigger: 'item',
               		        formatter: "{a} <br/>{b} : {c} ({d}%)"
               		    },
               		    legend: {
               		        orient: 'vertical',
               		        left: '',
               		        data: ['家庭','衣服','食物','住宿','交通','用品','娱乐']
               		    },
               		    series : [
               		        {
               		            name: '访问来源',
               		            type: 'pie',
               		            radius : '55%',
               		            center: ['50%', '60%'],
	               		        label : {
	               		        	normal : {
		               		        	formatter: '{b}:{c}: ({d}%)',
		               		        	textStyle : {
			               		        	fontWeight : 'normal',
			               		        	fontSize : 15
		               		        	}
	               		        	}
	               		        }, 
               		            data:[
               		            	{value:result[0], name:'家庭'},
               		                {value:result[1], name:'衣服'},
               		                {value:result[2], name:'食物'},
               		                {value:result[3], name:'住宿'},
               		                {value:result[4], name:'交通'},
               		                {value:result[5], name:'用品'},
            		                {value:result[6], name:'娱乐'},
               		            ],
               		            itemStyle: {
               		                emphasis: {
               		                    shadowBlur: 10,
               		                    shadowOffsetX: 0,
               		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
               		                }
               		            }
               		        }
               		    ]
               		};
	               	if (option && typeof option === "object") {
	               	    myChart.setOption(option, true);
	               	}
               }
           });
       };
       </script>
</body>
<jsp:include page="../adminhome/adminfooter.jsp"/>
</html>