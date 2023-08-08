<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
    <meta charset="UTF-8">
    <style>
        a{text-decoration:none}
    </style>
    <body style="text-align:center">
        <h3>main.jsp ( ${data} )</h3>

        <h5>뷰(View)</h5>
             <a href="hello.html">스테이틱(static)</a>
             <a href="main.do">제이에스피(jsp)</a><br/>

        <h5>컨트롤러(Controller): 리턴방식</h5>
             <a href="template.do?name=tiger">템플릿(template)</a>
             <a href="string.do?na=lion">문자열(String)</a>
             <a href="json.do?title=스프링&price=20000">제이슨(JSON)</a><br/>

        <h4>컨트롤러(Controller): 다양한 Give&Take </h4>
           <a href="test">TEST(m00:defult)</a><br/>
           <a href="test/base1">TEST(m01:Get, Post, put , Delete URL)</a><br/>
           <a href="test/base2">TEST(m02:only Get방식)</a><br/>
           <a href="test/base3">TEST(m03:only Get방식 & Post방식s)</a><br/>
           <a href="test/param1?name=홍길동&age=30">TEST(m04:param1 Human 클래스 객체를 넘김)</a><br/>
           <a href="test/param2?name=이순신&age=40">TEST(m05:param2)</a><br/>
           <a href="test/param3?names=강감찬&names=이순신&names=유관순">TEST(m06:names&names)</a><br/>
           <a href="test/param4?ns=강감찬&ns=이순신&names=유관순">TEST(m07:ns&ns)</a><br/>
           <a href="test/param5?names=강감찬&names=이순신&names=유관순">TEST(m08:배열로)</a><br/>

            <!--
            <a href="test/param6?list[0].name=홍길동&list[0].age=27&list[1].name=이순신&list[1].age=28">m09</a>
            [ -> %5B
            ] -> %5D
            -->

            <a href="test/param6?list%5B0%5D.name=홍길동&list%5B0%5D.age=27&list%5B1%5D.name=이순신&list%5B1%5D.age=28">TEST(m09:list 배열[]표기)</a><br/>
            <a href="test/param7?name=이순신&page=10&age=30">TEST(m10:서로다른 객체 데이터 값 사용)</a><br/>
            <a href="test/param8?subject=데이트&cdate=2023/08/01 18:02:30">TEST(m11:날짜)</a><br/>
            <a href="test/json1">TEST(m12:json1 (HTTPHEADER 메소드))</a><br/>
            <a href="test/json2">TEST(m13:json2 (Human class 멤버번수꺼냄))</a><br/>

    </body>
    </html>
