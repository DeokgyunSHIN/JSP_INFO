# db에 있는 데이터 web 화면에 띄우기 

db.jsp 파일을 보면 

4개의 java파일이 있고 

index.jsp 파일이 있다.

![스크린샷 2023-02-02 오후 10 46 25](https://user-images.githubusercontent.com/104719555/216341744-75c27c15-1b9a-4aa4-a66f-cfd7279a09a1.png)

DBInfo,java 는 db연동을 위해서 최소한으로 필요한 것을 담은 파일이고 

DbTestMain.java 은 시작하기 위한 자바 파일이다.

그리고 MemberInfo.java 는 데이터를 담을 자바 파일이며 

MemberService.java 파일은  서비스를 실행하기 (db 데이터를 뽑아오기) 위한 자바 파일이다.

맨 처음에 java 파일로 정상적으로 db에 데이터가 나오느지 확인을 한다.

<img width="542" alt="스크린샷 2023-02-02 오후 10 50 05" src="https://user-images.githubusercontent.com/104719555/216342738-00291535-e6ea-4f4b-a151-109e0fe14e04.png">

지금 사진을 보다시피 콘솔에 나와있는 데이터를 web에 띄워야 한다.

```jsp
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
```

테이블 없이도 데이터는 정상적으로 뽑아질수 있다.

하지만 그렇게 되어져 버리면 깔끔하게 보이지 않는다.

그러기 때문에 테이블을 사용하게 되면 

![스크린샷 2023-02-02 오후 11 03 00](https://user-images.githubusercontent.com/104719555/216345623-d3dc8849-6adf-4edb-902f-18087d63db60.png)

위의 사진 처럼 깔끔하게 나오는것을 볼수 있다.
