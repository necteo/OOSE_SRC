<%@ page import="sogongimms.persistent.dto.TeacherDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    String password = (String) request.getAttribute("password");
    TeacherDTO teacherDTO = (TeacherDTO) request.getAttribute("teacher");
%>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/TeacherView/css/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/TeacherView/css/teacher.css" />
    <title>Document</title>
</head>
<body>
    <nav class="sidebar">
        <h1 class="center-name">소공체육센터</h1>
        <div class="profile-box">
            <div class="profile__user-img"></div>
            <span class="profile__user-name">관리자</span>
        </div>
        <div class="menu-container">
            <span class="teacher-menu-title">강사</span>
            <ul class="teacher-menu-list">
                <li class="teacher-menu-item">
                    <a href="lists">- 강사목록</a>
                </li>
            </ul>
        </div>
    </nav>
    <main>
        <div class="main-container">
            <header>
                <div class="title-container">
                    <h2 class="menu-super-title">강사</h2>
                    <h3 class="menu-sub-title">강사 정보</h3>
                </div>
                <button onclick="history.back()" class="exit-btn">나가기</button>
            </header>
            <div class="info-container">
                <div class="info-item">
                    <label for="id">아이디</label>
                    <input type="text" name="id" id="id" value="<%= teacherDTO.getId() %>" disabled>
                </div>
                <div class="info-item">
                    <label for="password">비밀번호</label>
                    <input id="password" name="password" type="password" value="<%= password %>" disabled>
                </div>
                <div class="info-item">
                    <label for="name">이름</label>
                    <input type="text" name="name" id="name" value="<%= teacherDTO.getName() %>" disabled>
                </div>
                <div class="info-item">
                    <label for="phone">전화번호</label>
                    <input type="text" name="phone" id="phone" value="<%= teacherDTO.getPhone() %>" disabled>
                </div>
                <div class="info-item">
                    <label for="email">이메일</label>
                    <input type="text" name="email" id="email" value="<%= teacherDTO.getEmail() %>" disabled>
                </div>
                <!--  end of info container -->
            </div>
        </div>
    </main>
</body>
</html>

