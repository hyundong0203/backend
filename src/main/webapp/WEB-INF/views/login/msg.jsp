<%@ page contentType="text/html;charset=utf-8" import="hd.backend.service.MemberLoginConst"%>

<script>
    if(${result} == <%=MemberLoginConst.NO_ID%>){
        alert("이메일을 확인하세요");
        //location.href="form.do";
        history.back();
    }else if(${result} == <%=MemberLoginConst.NO_PWD%>){
        alert("비밀번호를 확인하세요");
        //location.href="form.do";
        history.back();
    }else{
        alert("로그인 성공");
        if(${empty sessionScope.forward_url}){
            location.href="../";
        }else{
            location.href="../${sessionScope.forward_url}";
            <% session.removeAttribute("forward_url"); %>
            //alert("제거후: ${sessionScope.forward_url}");
        }
    }
</script>