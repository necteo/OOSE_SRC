<%@ page import="sogongimms.persistent.dto.TeacherDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/TeacherView/css/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/TeacherView/css/teacherList.css" />
    <title>소공스포츠센터</title>
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
                    <h3 class="menu-sub-title">강사 목록</h3>
                </div>
                <button onclick="history.back()" class="exit-btn">나가기</button>
            </header>
            <button class="create-teacher-btn">
                <a href="createView">신규 등록</a>
            </button>
            <table class="teacher-list-table">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
                </thead>
                <tbody>
                <%
                    int num = 1;
                    ArrayList<TeacherDTO> teacherList = (ArrayList<TeacherDTO>) request.getAttribute("teacher_list");
                    for (TeacherDTO teacher: teacherList) {
                %>
                        <tr onclick="location.href=`view?id=<%= teacher.getId() %>`">
                            <td><%= num++ %></td>
                            <td><%= teacher.getId() %></td>
                            <td><%= teacher.getName() %></td>
                            <td><%= teacher.getPhone() %></td>
                            <td><%= teacher.getEmail() %></td>
                        </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </main>
<script>
    <%--function chkValid() {--%>
    <%--<%--%>
    <%--    if (session.getAttribute("type") != null) {--%>
    <%--        int type = (Integer) session.getAttribute("type");--%>
    <%--        if (type == 1) { %>--%>
    <%--            return true;--%>
    <%--<%      } else { %>--%>
    <%--            alert('권한이 없습니다.');--%>
    <%--            return false;--%>
    <%--<%      }--%>
    <%--    } else { %>--%>
    <%--        alert('로그인이 필요합니다.');--%>
    <%--        return false;--%>
    <%--<%  } %>--%>
    <%--}--%>

    function view(id) {
        location.href = `view/${id}`;
    }
</script>
</body>
</html>

