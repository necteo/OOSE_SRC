<%--
  Created by IntelliJ IDEA.
  User: Mo
  Date: 2022-05-28
  Time: 오후 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminMain</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/NoticeView/css/notice.css">
</head>
<body>
    <div class="main_container">
        <div class="sidebar">
            <div class="member">
                <img class="user_icon" src="${pageContext.request.contextPath}/NoticeView/img/user-icon.png">
                <%  if (session.getAttribute("user_id") != null) { %>
                        <div class="user_text"><%= session.getAttribute("user_id") %></div>
                <%  } else { %>
                        <div class="user_text"><a href="/sogongimms/MemberView/Member/login">관리자 로그인</a></div>
                <%  } %>
            </div>
            <div class="side_menu">
                <button type="button" onclick="location.href='lists?page=1'">공지조회</button>
            </div>
        </div>
        <div class="content_container">
            <form action="create" method="post">
                제목:<input type="text" name="title"><br/>
                <label>내용:</label><textarea cols="30" name="content"></textarea>
                <input type="submit" value="공지 등록">
            </form>
        </div>
    </div>
</body>
</html>
