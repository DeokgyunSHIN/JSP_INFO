# JSP

> JSP는 자바 서버 페이지(java server pages)라고 한다.
>
> JSP는 HTML 코드와 java 코드를 넣어서 동적 웹 페이지를 만들거나 생성하는 도구이다.

<img width="1678" alt="스크린샷 2023-01-31 오후 6 00 46" src="https://user-images.githubusercontent.com/104719555/215715059-80db1566-30d9-4f6a-ad04-da79173ebfe6.png">

입클립스라는 툴을 이용해서 hello.jsp파일을 생성하게 되면 위의 사친처럼 초기화면이 나오게된다. 

지금 화면에 보이는것은 마크코드(HTML)이다.

jsp는 위에서도 말했다시피 html와 자바를 쓸수 있다고 했다.

근데 그냥 여기에 자바코드르 넣게 되면 인식을 할수 없다.

```java
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
     System.out.println("hello1");
   %>
</body>
 </html>
```

위의 코드처럼 <% %> 사이에 자바코드를 넣어주면 여기는 자바코드구나 라고 인식을 하게 된다.

그러고 나서 톰캣으로 서버를 실행하게 되면 

<img width="1676" alt="스크린샷 2023-01-31 오후 6 15 00" src="https://user-images.githubusercontent.com/104719555/215718461-3e26a0d8-e644-4d3b-af3e-730cf7444462.png">

위의 사진처럼 아무것도 뜨지 않고 

<img width="1679" alt="스크린샷 2023-01-31 오후 6 15 14" src="https://user-images.githubusercontent.com/104719555/215718517-2da92e18-2fc0-4c79-8ae3-46a7a080b8f0.png">

콘솔에 hello1 라고 뜬다.

코드에서 out.println("hello2");

라고 적게 되면 

<img width="1674" alt="스크린샷 2023-01-31 오후 6 17 06" src="https://user-images.githubusercontent.com/104719555/215718909-46c2616e-dbc7-46e7-b6f5-d81a696b5006.png">

위의 사진처럼 웹에서 글씨가 나타나지는것을 볼수 있다.
