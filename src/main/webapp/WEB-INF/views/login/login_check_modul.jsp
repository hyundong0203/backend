<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty loginOkUser}">
    <script>
        alert("회원서비스입니다. 로그인후 이용해주세요");
        location.href="../login/form.do";
    </script>
</c:if>
