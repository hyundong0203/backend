<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <style>
        a{text-decoration:none}
    </style>
    <body style="text-align:center">
        <h3>index.jsp</h3>

        <a href="address/list.do">주소록(JDBC)</a><br/>
        <a href="board/list.do">게시판(JDBC)</a><br/>
        <a href="address_page/list.do">주소록(페이징)</a><br/>
        <a href="board_page/list.do">게시판(페이징)</a><br/>

        <a href="file/upload.do">파일폼</a><br/>

        <a href="file/list.do">파일리스트</a><br/>
    </body>
</html>