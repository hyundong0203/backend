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
        <a href="file/list.do">파일리스트</a>(회원가입서비스)<br/>

        <a href="ajax/test1.do">Ajax1</a>
        <a href="ajax/test2.do">Ajax2</a>&nbsp;&nbsp;
        <a href="ajax/test3.do">Ajax3</a>&nbsp;&nbsp;
        <a href="ajax/test4.do">Ajax4</a>(JSP)<br/>

        <a href="auto/auto.do">Autocomplete(자동완성)</a><br/>
        <a href="drag_drop/form_dd.do">Drag&Drop폼</a><br/>
        <a href="drag_drop/list.do">Drag&Drop리스트</a><br/>

        <a href="chart/chart.do">Google Chart</a><br/>
        <a href="rest_addr/create1?name=오늘은&addr=수요일">REST</a><br/>
        <a href="rest_addr/read">REST1</a><br/>
        <a href="rest_board/read">RESTBoard</a><br/>

        <c:choose>
            <c:when test="${empty loginOkUser}">
                <a href="login/form.do">로그인</a>
            </c:when>
            <c:otherwise>
                <font style="color:green">${loginOkUser.name}</font>님 어서오세요<br/>
                <a href="login/logout.do">로그아웃</a>
            </c:otherwise>
        </c:choose>


    </body>
</html>