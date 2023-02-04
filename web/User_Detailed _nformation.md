# web 에 유저 상제 정보 나타내기 

web.md 파일에서는 화면에 db 테이블에 있는 데이터를 화면에 나타내것을 했다.

요번에는 고객 아이디 클릭시 그 고객읠 상새 정보를 뜨게 만들어 본다.

기존에 index.jsp 파일이름을 list.jsp 로 변경을 해주고 

![스크린샷 2023-02-04 오후 7 52 45](https://user-images.githubusercontent.com/104719555/216763086-95a93433-d50b-46ec-959d-3e492d262e85.png)

위의 사진처럼 변경을 해준다.

바꿔준 이유는 <a hrep =  > 를 쓰기 위해서이다. 

``` 
 <a href="detail.jsp?memberType=<%=member.getMember_type()%>&userId=<%=member.getUser_id()%>">
```
   
가 사진에서 보이는데 앞에는 이동할 주소를 적어주고 ? 뒤에는 넘겨줄 데이터를 넣는다. 
 
hrep 는 이동할 주소를 적는 속성이다.
   
이렇게 한다음 톰캣으로 서버를 열게 되면 
   
   <img width="1672" alt="스크린샷 2023-02-04 오후 8 26 32" src="https://user-images.githubusercontent.com/104719555/216764745-1109026a-14ee-461c-a049-f3fc9b03e139.png">

위의 사진 처럼 링크로 뜨게 된다 . 
   
여기서 sdg990181@test.com 을 누르게 되면 
   
![스크린샷 2023-02-04 오후 8 27 26](https://user-images.githubusercontent.com/104719555/216764784-b0093587-c37c-4830-a639-58b9c3f22adf.png)

위의 사진 처럼 detail.jsp 로 이동이 되고 ? 뒤에 데이터가 전달되는것을 볼 수 있다.
   
즉, 아이디를 클릭하게 되면 http요청을 보내는데 그떄 파라마터와 함께 서버로 보내는것이다. 
  
조금더 단순하게 말하면 택배 보낼 때 상자에 member_type ,userId 를 넣어서 원하는 주소를 보낸다는 뜻이다.
   
 detail.jsp  
   
```jsp
   <%@ page import="example.MemberService" %>
<%@ page import="example.MemberInfo" %>
<%@ page import="java.util.List" %>

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
```
  
보낸 뒤에는 detail.jsp 파일이 있어야 하기 떄문에 위의 코드처럼 만들어준다. 
  
여기서 request.getParameter(); 가 보이는데 
  
request 는 요청 / response는 응답이다.
  
여기서는 list.jsp 에서 요청한 파라미터의 값을 가지고 오기 때문에 
  
request.getParameter() 를 쓴다.
  
 그리고 list.jsp 로 돌아가야하기 떄문에 밑에 갈수 있게 
  
 ``` 
    <a href="list.jsp">목록으로 </a>
 ``` 
 
 를 만들어줘서 목록으로 클릭하게 되면 list.jsp로 갈수 있게 만들어놓는다.
  
  여기서 ? 가 들어가지 않는 이유는 목록으로 돌아가는데 파라미터값이 필요없고 그냥 
  
  주소만 가면 되기 떄문에 이동할 주소의 값만 넣어주면 된다.
 
그러면 MemberService.java에 detail 메소드를 생성 해 준다.
  
```java
      public MemberInfo detail(String memberType, String userId) {
        MemberInfo member = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUserId, dbPassword);

            StringBuffer sb = new StringBuffer();
            sb.append("select m.member_type, m.user_id,m.password, m.name,");
            sb.append(" md.mobile_no, md.marketing_yn, md.register_date");
            sb.append(" from member m ");
            sb.append(" left join member_detail md on md.member_type = m.member_type and m.user_id = md.user_id");
            sb.append(" where m.member_type = ? and m.user_id = ?");

            prst = conn.prepareStatement(sb.toString());
            prst.setString(1, memberType);
            prst.setString(2, userId);
            rs = prst.executeQuery();

            if (rs.next()) {
                member = new MemberInfo();

                member.setMember_type(rs.getString("member_type"));
                member.setUser_id(rs.getString("user_id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setMobile_no(rs.getString("mobile_no"));
                member.setMarketing_yn(rs.getBoolean("marketing_yn"));
                member.setRegister_dete(rs.getDate("register_date"));
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (prst != null && !prst.isClosed()) {
                    prst.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return member;
    }
```

그리고 MemberInfo.java 에도 
 
상세 정보에 필요한 전화번호, 마케팅 수신 여부 , 등록일 의 필드의 값을 생성해주고 getter/setter를 만들어준다.
 
그러고 나서 다시 sdg990181@test.com의 아이디를 누르게 되면 
  
 ![스크린샷 2023-02-04 오후 8 47 57](https://user-images.githubusercontent.com/104719555/216765959-fa9a0c39-8b5f-4d53-bf26-2c57c92de4ce.png)
  
 위의 사진처럼 그 유저의 상세 정보를 얻을 수 있다.
  
(참고! member_detail 테이블이 존재해야됨! )
  
``` 
  
CREATE table member(
member_type varchar(10) not null comment '회원구분',
user_id varchar(50) not null comment'회원 아이디',
password varchar(50) null comment '비밀번호',
name varchar(50) null comment '이름',
primary key (member_type, user_id)
 ) comment '회원정보';
```
  
```  
 CREATE table member_detail(
 member_type varchar(10)  not null comment '회원구분',
 user_id varchar(50) not null comment '회원 아이디',
 mobile_no varchar(12) null comment '전화번호',
 marketing_yn bit  null comment '마케팅 수신 여부',
 register_date datetime default current_timestamp() null comment '가입일',
 primary key(member_type, user_id),
 constraint fk_member_detail foreign key(member_type, user_id) references member (member_type, user_id)
 ) comment '회원상세정보' ;
```
