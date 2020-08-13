<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	<script type="text/javascript" src="../springboot/resources/js/adminshowalllotteryresult.js"></script>
	<script type="text/javascript" src="../springboot/resources/My97DatePicker/WdatePicker.js"></script>
	<script>
	// 当前第几页数据  
	var currentPage = ${pager.currentPage};  
	// 总页数  
	var totalPage = ${pager.totalPage};
	</script>
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
                          <td  class="adminshowallproject">
                              <div class="adminshowallproject1">
                                   <form action="adminshowalllotteryresult?pageNum=<%=1%>" method="post" id="sform">
	                                   <table class="adminshowallproject4">
											   <tr>
											   		<td>
											       		<input type="button" value="删除彩票" style="height:30px;" onclick="submitDelForm()"/>
													 </td>
													 <td>
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									   		         </td>
													 <td>
													       <input type="button" value="添加彩票" style="height:30px;" onclick="javascript:window.location.href='/springboot/adminaddlottery'"/>
													 </td>
													 <td>
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									   		         </td>
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
												       <input type="submit" style="height:30px;" value="查询彩票"/>
												   </td>
												   
											   </tr>
									   </table>
								   </form>
								  <form action="admindeletelotteryresult" method="post" id="delform">
		                                   <table id="adminshowallproject2">
												   <tr class="adminshowallproject3">
												   			<td width="5%" align="center">
																<input type="checkbox" id="input_checkbox" onclick="selectAllCheckBox();"/>
															</td>
												           <td>
				                                               	期号
				                                           </td>
				                                           <td>
				                                               	日期
				                                           </td>
				                                           <td>
				                                               	红1
				                                           </td>
				                                           <td>
				                                              	 红2
				                                           </td>
				                                           <td>
				                                              	 红3
				                                           </td>
				                                           <td>
				                                               	红4
				                                           </td>
				                                           <td>
				                                               	红5
				                                           </td>
				                                           <td>
				                                               	蓝1
				                                           </td>
				                                           <td>
				                                               	蓝2
				                                           </td>
												   </tr>
												   <c:forEach items="${pager.dataList }" var="lotteryresult">
												   		<tr>  
												   			<td  align="center"><input type="checkbox" id="checkbox"  name="tduCheckBox" value="${lotteryresult.phase}" /></td>
												   		    <td><a href="adminbeforeupdatelotteryresult?phase=${lotteryresult.phase}"><c:out value="${lotteryresult.phase}"></c:out></a></td>
								                            <td><c:out value="${lotteryresult.date }"></c:out></td>  
								                            <td><c:out value="${lotteryresult.red1 }"></c:out></td> 
								                            <td><c:out value="${lotteryresult.red2}"></c:out></td>  
								                            <td><c:out value="${lotteryresult.red3 }"></c:out></td>  
								                            <td><c:out value="${lotteryresult.red4 }"></c:out></td> 
								                            <td><c:out value="${lotteryresult.red5}"></c:out></td>  
								                            <td><c:out value="${lotteryresult.blue1 }"></c:out></td>  
								                            <td><c:out value="${lotteryresult.blue2 }"></c:out></td> 
								                        </tr>  
								                    </c:forEach>      
										   </table>
								   </form>
								   <%-- <table align="center">
								   		<tr>
					                    	<td>
											       <input type="submit" value="删除彩票" onclick="submitDelForm()"/>
											 </td>
											 <td>
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							   		         </td>
											 <td>
											       <input type="submit" value="添加彩票" onclick="javascript:window.location.href='/springmvc/adminlotteryresult/adminaddlotteryresult.jsp'"/>
											 </td>
											 <td>
											 	   <font color="red"><c:out value="${sucess}"></c:out></font>
											 </td>
						                 </tr> 
						            </table> --%>
						            <table align="center">
						            	<tr>
						            		<td>
						            			<br> 共${pager.totalRecord}条记录共${pager.totalPage}页  当前第${pager.currentPage}页      
									            <a href="javascript:firstPage()">首页</a>    
									            <a href="javascript:nextPage()">下一页</a> 
									            <a href="javascript:previousPage()">上一页</a> 
									            <a href="javascript:lastPage()">尾页</a>
						            		</td>
						            	</tr>
						            </table>      
                              </div>
                          </td>
                     </tr>
              </table>
	  </div>
  </body>
  <jsp:include page="../adminhome/adminfooter.jsp"/>
</html>
