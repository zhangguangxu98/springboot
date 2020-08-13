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
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
  </head>
  <jsp:include page="adminheader.jsp"/>
  <body>
	   <div class="adminhome21">
              <table>
                     <tr>
                          <td>
                              <div>
                            		<jsp:include page="adminnavigator.jsp"/>
                              </div>
                      	  </td>
                          <td  class="adminhome22">
                              <div class="adminhome23">
                                   <table>
                                          <tr>
                                              <td>
                                                  <font color="red"><c:out value="${error}"></c:out></font>
                                              </td>
                                          </tr>
                                          <tr>
                                              <td>
                                                  <img src="../springboot/resources/images/adminhome4.jpg" height="300px" width="400px"/>
                                              </td>
                                          </tr>
                                   </table>
                              </div>
                          </td>
                     </tr>
              </table>
        </div>
  </body>
  <jsp:include page="adminfooter.jsp"/>
</html>
