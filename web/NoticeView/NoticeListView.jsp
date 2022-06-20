<%--
  Created by IntelliJ IDEA.
  User: Mo
  Date: 2022-05-28
  Time: 오후 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="sogongimms.persistent.dto.NoticeTitleDTO" %>
<%@ page import="java.util.ArrayList" %>
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
        <h4>공지</h4><br>
        <tr>
            <th>no</th>
            <th>Title</th>
            <th>writer</th>
        <tr><br>
        <%
            ArrayList<NoticeTitleDTO> noticeTitleList = null;
            if (null != request.getAttribute("res_notice_titles")) {
                noticeTitleList = (ArrayList<NoticeTitleDTO>) request.getAttribute("res_notice_titles");
            }
            int page_max_size = (Integer) request.getAttribute("page_size");

            if (noticeTitleList != null) {
                for (int i = 0; i < noticeTitleList.size(); i++) {
        %>
                    <tr>
                        <td><%= noticeTitleList.get(i).getNoticeNum() %></td>
                        <td><a href="view?num=<%= noticeTitleList.get(i).getNoticeNum() %>">
                                <%= noticeTitleList.get(i).getTitle() %>
                            </a></td>
                        <td><%= noticeTitleList.get(i).getUserId() %></td>
                    </tr>
        <%      }
            }

            for (int i = 0; i < page_max_size; i++) {
                int pageNum = i + 1;
        %>
                <button type="button" onclick="location.href='lists?page=<%= pageNum %>'"><%= pageNum %></button>
        <%
            }
        %>
        <%
            if (session.getAttribute("type") != null) {
                int type = (Integer) session.getAttribute("type");
                if (type == 2) { %>
                    <button type="button" onclick="location.href='createView'">공지작성</button>
        <%      }
            }
        %>
    </div>
</div>
</body>
</html>
