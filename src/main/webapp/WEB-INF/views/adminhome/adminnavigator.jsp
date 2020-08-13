<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
  </head>

  <body>
        <div>
              <table>
                     <tr>
                          <td>
                               <table class="adminhome19">
                                      <tr>
                                          <td>
                                              	BC System
                                          </td>
                                      <tr>
                                </table>
                               <div style="margin:1% 0% 1% 0%">
                                   <table class="adminhome20">
                                     <tr>
                                         <td>
                                              Version1.0(2015)
                                         </td>
                                     <tr>
                                   </table>
                                 </div>
		                          <div>
			                          <table class="adminhome9">
	                                      <tr>
	                                          <td>
	                                          		Lottery
	                                          </td>
	                                      <tr>
	                                   </table>
	                                   <table class="adminhome5">
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="adminshowalllotteryresult?pageNum=<%=1%>&pageSize=10">Lottery Result</a>
													 <!-- <img src="images/adminhome2.gif" alt="adminhome2"/><a href="/springmvc/adminlotteryresult/adminshowalllotteryresult.jsp">Lottery Result</a> -->
	                                   			</td>
	                                   		</tr>
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminupanddownloadlotteryresult">Import/Export</a>
	                                   			</td>
	                                   		</tr>
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminshowlotteryresultchart">Report</a>
	                                   			</td>
	                                   		</tr>
	                                   </table>
                                   </div>
                                   <div>
			                          <table class="adminhome9">
	                                      <tr>
	                                          <td>
	                                          		Log
	                                          </td>
	                                      <tr>
	                                   </table>
	                                   <table class="adminhome5">
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminshowallmylog?pageNum=1&pageSize=10">My Log</a>
	                                   			</td>
	                                   		</tr>
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminupanddownloadmylog">Import/Export</a>
	                                   			</td>
	                                   		</tr>
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminshowmylogchart">Report</a>
	                                   			</td>
	                                   		</tr>
	                                   </table>
                                   </div>
		                           <div>
			                          <table class="adminhome9">
	                                      <tr>
	                                          <td>
	                                          		Plan
	                                          </td>
	                                      <tr>
	                                   </table>
	                                   <table class="adminhome5">
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminshowallmyplan?pageNum=1&pageSize=10">My Plan</a>
	                                   			</td>
	                                   		</tr>
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminupanddownloadmyplan">Import/Export</a>
	                                   			</td>
	                                   		</tr>
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminshowmyplanchart">Report</a>
	                                   			</td>
	                                   		</tr>
	                                   </table>
                                   </div>
		                           <div>
	                                  <table class="adminhome9">
	                                      <tr>
	                                          <td>
	                                          		Administration
	                                          </td>
	                                      <tr>
	                                   </table>
	                                   <table class="adminhome5">
	                                   		<tr>
	                                   			<td>
													 <img src="../springboot/resources/images/adminhome2.gif" alt="adminhome2"/><a href="/springboot/adminshowalluser?pageNum=<%=1%>">UsersManage</a>
	                                   			</td>
	                                   		</tr>
	                                   </table>
		                         </div>
                          </td>
                     </tr>
              </table>
        </div>
  </body>
</html>
