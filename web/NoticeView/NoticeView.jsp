<%--
  Created by IntelliJ IDEA.
  User: Mo
  Date: 2022-05-28
  Time: 오후 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="sogongimms.persistent.dto.NoticeDTO" %>
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
            <%
                NoticeDTO noticeDTO = (NoticeDTO) request.getAttribute("res_notice");
            %>
            <h3><%= noticeDTO.getNoticeNum() %></h3>
            <h3><%= noticeDTO.getTitle() %></h3>
            <h3><%= noticeDTO.getUserId() %></h3>
            <h3><%= noticeDTO.getUploadDate() %></h3>
            <h3><%= noticeDTO.getContent() %></h3>
        </div>
    </div>
</body>
</html>
