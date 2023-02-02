<%@ page import="example.MemberService" %>
<%@ page import="example.MemberInfo" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2023/02/02
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jsp</title>
    <style>
      table {
        width: 100%;
      }
      th, td{
        border: solid 1px black;
      }
    </style>
  </head>
  <body>
  <h1>회원 목록</h1>
    <table>
      <thead>
      <tr>
        <th>회원부분</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
      </tr>
       <%

         MemberService memberService=new MemberService();
         List<MemberInfo> memberList= memberService.MemberSelect();
         for (MemberInfo member: memberList) {
           out.write("<tr>");
           out.write("<td>" + member.getMember_type() + "</td>");
           out.write("<td>" +member.getUser_id()+ "</td>");
           out.write("<td>" +member.getPassword()+ "</td>");
           out.write("<td>" +member.getName()+ "</td>");
           out.write("</tr>");
         }
       %>
      </thead>
    </table>

  </body>
</html>
