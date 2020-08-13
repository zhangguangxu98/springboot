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
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/adminaddlotteryresult.css">
	<link rel="stylesheet" type="text/css" href="../springboot/resources/css/datepicker.css">
	<script type="text/javascript" src="../springboot/resources/js/adminhome.js"></script>
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
                        <td  class="adminaddproject">
                            <div class="adminaddproject1">
                            <form action="adminaddlotteryresult" method="post">
                                <table>
						          <tr class="adminaddproject2">
						              <td>添加彩票结果:</td>
						          </tr>
						          <tr>
                                          <td>
                                              	期号:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 300px; height: 30px;" name="phase" id="phase" value=''>
                                       </td>
                                    </tr>        
                                  <tr>
                                          <td>
                                              	日期:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 300px; height: 30px;" name="date" id="date" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate">
                                       </td>
                                   </tr>
                                    <tr>
                                          <td>
                                              	红1:
                                          </td>
                                          <td>
                                           <input type="text" style="width: 300px; height: 30px;" name="red1" id="red1" value=''>
                                       </td>
                                     </tr>
                                     <tr>
                                           <td>
                                               	红2:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red2" id="red2" value=''>
                                           </td>
                                      </tr>
                                      <tr>
                                           <td>
                                               	红3:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red3" id="red3" value=''>
                                           </td>
                                       </tr>
                                       <tr>
                                           <td>
                                               	红4:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red4" id="red4" value=''>
                                           </td>
                                        </tr>
                                        <tr>
                                           <td>
                                               	红5:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="red5" id="red5" value=''>
                                           </td>
                                         </tr>
                                         <tr>
                                           <td>
                                               	蓝1:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="blue1" id="blue1" value=''>
                                           </td>
                                        </tr>
                                        <tr>
                                           <td>
                                               	蓝2:
                                           </td>
                                           <td>
                                               <input type="text" style="width: 300px; height: 30px;" name="blue2" id="blue2" value=''>
                                           </td>
                                       </tr>   
                                       <tr>        
                                          <td></td>                             
                                          <td>                                          
                                               <input type="submit" value="Add"/>                
                                          </td>
                                      </tr>                   
                               </table> 
                            </form>
                            </div>
                        </td>
                   </tr>
            </table>
	  </div>
  </body>
  <jsp:include page="../adminhome/adminfooter.jsp"/>
</html>
