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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminshowallmylog.css">
	<script type="text/javascript" src="../springboot/resources/js/adminshowalllmylog.js"></script>
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
                                   <form action="adminshowallmylog?pageNum=<%=1%>&pageSize=<%=10%>" method="post" id="sform">
	                                   <table class="adminshowallproject4">
											   <tr>
											   		 <!-- <td>
							                              <img src="images/delete.png" alt="delete" height="30px" width="30px"/>
							                         </td> -->
											   	   	 <td>
											       		<input type="button" value="删除日志" style="height:30px;" onclick="submitDelForm()"/>
													 </td>
													 <td>
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									   		         </td>
									   		         <!-- <td>
							                              <img src="images/add.png" alt="add" height="30px" width="30px"/>
							                         </td> -->
													 <td>
													       <input type="button" value="添加日志" style="height:30px;" onclick="javascript:window.location.href='/springboot/adminaddlog'"/>
													 </td>
												   <td>
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

														 
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
												       <input type="submit" style="height:30px;" value="查询日志"/>
												   </td>
												   
											   </tr>
									   </table>
								   </form>
								  <form action="admindeletemylog" method="post" id="delform">
		                                   <table id="adminshowallproject2">
												   <tr class="adminshowallproject3">
												   			<td width="5%" align="center">
																<input type="checkbox" id="input_checkbox" onclick="selectAllCheckBox();"/>
															</td>
												           <td>
				                                               	序号
				                                           </td>
				                                           <td>
				                                               	日期
				                                           </td>
				                                           <td>
				                                               	自制
				                                           </td>
				                                           <td>
				                                               	勤奋
				                                           </td>
				                                           <td>
				                                               	秩序
				                                           </td>
				                                           <td>
				                                               	整洁
				                                           </td>
				                                           <td>
				                                               	节俭
				                                           </td>
				                                           <td>
				                                               	诚实
				                                           </td>
				                                           <td>
				                                              	 正直
				                                           </td>
				                                           <td>
				                                              	谦虚
				                                           </td>
				                                           <td>
				                                              	 友善
				                                           </td>
				                                           <td>
				                                              	宽容
				                                           </td>
												   </tr>
												   <c:forEach items="${pager.dataList }" var="mylog"> 
												   		<tr>  
												   			<td  align="center"><input type="checkbox" id="checkbox"  name="tduCheckBox" value="${mylog.id}" /></td>
												   		    <td><a href="adminbeforeupdatemylog?id=${mylog.id}"><c:out value="${mylog.id}"></c:out></a></td>
								                            <td><c:out value="${mylog.date }"></c:out></td>    
								                            <td><c:out value="${mylog.selfcontrol}"></c:out></td>  
								                            <td><c:out value="${mylog.diligence}"></c:out></td> 
								                            <td><c:out value="${mylog.goodorder}"></c:out></td>  
								                            <td><c:out value="${mylog.clean}"></c:out></td>  
								                            <td><c:out value="${mylog.frugality}"></c:out></td> 
								                            <td><c:out value="${mylog.honest}"></c:out></td> 
								                            <td><c:out value="${mylog.integrity}"></c:out></td> 
								                            <td><c:out value="${mylog.modest}"></c:out></td> 
								                            <td><c:out value="${mylog.friendly}"></c:out></td> 
								                            <td><c:out value="${mylog.tolerant}"></c:out></td> 
								                        </tr>  
								                    </c:forEach>      
										   </table>
								   </form>
								   <%-- <table align="center">
								   		<tr>
					                    	<!-- <td>
											       <input type="submit" value="删除日志" onclick="submitDelForm()"/>
											 </td>
											 <td>
												 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   		         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							   		         </td>
											 <td>
											       <input type="submit" value="添加日志" onclick="javascript:window.location.href='/springmvc/adminmylog/adminaddmylog.jsp'"/>
											 </td> -->
											 <td>
											 	   <font color="red"><c:out value="${sucess}"></c:out></font>
											 </td>
						                 </tr> 
						            </table> --%>
						            <table align="center">
						            	<tr>
						            		<td>
						            			<br> 共${pager.totalRecord}条记录&nbsp;&nbsp;共${pager.totalPage}页  当前第${pager.currentPage}页      
									            <a href="javascript:firstPage()">首页</a>    
									            <a href="javascript:nextPage()">下一页</a> 
									            <a href="javascript:previousPage()">上一页</a> 
									            <a href="javascript:lastPage()">尾页</a>
									            <input type="text" style="width: 50px; height: 20px;" name="jumppage" id="jumppage">
									            <a href="javascript:jumpPage()">跳转</a>
									                               每页<input type="text" style="width: 50px; height: 20px;" name="pagesize" id="pagesize">条
									            <a href="javascript:setPage()">设置</a>                   
						            		</td>
						            	</tr>
						            </table>      
                              </div>
                          </td>
                     </tr>
              </table>
	  </div>
  </body>
<%--   <jsp:include page="/adminhome/adminfooter.jsp"/> --%>
</html>
