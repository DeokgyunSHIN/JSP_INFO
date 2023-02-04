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
<%
    String memberType=request.getParameter("memberType");
    String userId=request.getParameter("userId");
    MemberService memberService = new MemberService();
   MemberInfo member = memberService.detail(memberType,userId);
%>
<html>
<head>
    <title>jsp</title>
    <style>
        table {
            width: 100%;
        }

        th, td {
            border: solid 1px black;
        }
    </style>
</head>

<h1>회원 상세</h1>
<table>
    <colgroup>
        <col style="width: 20%"/>
        <col style="width: 80%"/>
    </colgroup>
    <tbody>
    <tr>
        <th>회원부분</th>
        <td>
        <%=member.getMember_type()%>
        </td>
    </tr>
    <tr>
        <th>아이디</th>
        <td>
            <%=member.getUser_id()%>
        </td>
    </tr>
    <tr>
        <th>비밀번호</th>
        <td>
            <%=member.getPassword()%>
        </td>
    </tr>
    <tr>
        <th>이름</th>
        <td>
            <%=member.getName()%>
        </td>
    </tr>
    <tr>
        <th>전화번호</th>
        <td>
            <%=member.getMobile_no()%>
        </td>
    </tr>
    <tr>
        <th>마케팅 수신 여부</th>
        <td>
            <%=member.isMarketing_yn()%>
        </td>
    </tr>

    <tr>
        <th>등록일</th>
        <td>
            <%=member.getRegister_dete()%>
        </td>
    </tr>

    </tbody>
</table>
   <div>
       <a href="list.jsp">목록으로 </a>
   </div>

</html>
