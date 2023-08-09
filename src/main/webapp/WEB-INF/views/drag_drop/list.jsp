<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>list.jsp</title>
		<style>
			a{text-decoration:none}
		    table{
		        width:60%
		    }
			table,th,td {
			  border : 1px solid black;
			  border-collapse: collapse;
			}
			th,td {
			  padding: 5px;
			}
		</style>
	</head>
	<body style="text-align:center">
	    <h1>Drag&Drop List with SpringBoot</h1>
		<a href="form_dd.do">Drag&Drop업로드폼</a>&nbsp;&nbsp;&nbsp;
	    <a href="../">인덱스
	    <br/><br/>

        <center>
	    <table>
	        <tr>
	           <th width="10%">번호</th>
	           <th>이름</th>
	           <th width="10%">삭제</th>
	        </tr>
            
            
	           <tr>
	             <td align="center">
                   16
                 </td>
	             <td align="center">
	               <a href="attach/16">MVC_매커니즘.png</a>
	             </td>
	             <td align="center">
	               <a href="remove.do?id=16">삭제</a>
	             </td>
	          </tr>
            
	           <tr>
	             <td align="center">
                   17
                 </td>
	             <td align="center">
	               <a href="attach/17">AOP개념.png</a>
	             </td>
	             <td align="center">
	               <a href="remove.do?id=17">삭제</a>
	             </td>
	          </tr>
            
	    </table>
	    </center>
	</body>
</html>