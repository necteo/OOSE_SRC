<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2022-06-07
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/TeacherView/css/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/TeacherView/css/teacherCreate.css" />
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
                    <a href="view" onclick="return chkValid()"> - 강사정보 | 수정</a>
                </li>
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
                    <h3 class="menu-sub-title">강사 등록</h3>
                </div>
                <button onclick="history.back()" class="exit-btn">나가기</button>
            </header>
            <form action="create" class="create-teacher-form" method="post">
                <div class="input-container">
                    <div class="info-item">
                        <label for="id">아이디</label>
                        <input type="text" name="id" id="id">
                    </div>
                    <div class="info-item">
                        <label for="password">비밀번호</label>
                        <input type="password" name="password" id="password">
                    </div>
                    <div class="info-item">
                        <label for="name">이름</label>
                        <input type="text" name="name" id="name">
                    </div>
                    <div class="info-item">
                        <label for="phone">전화번호</label>
                        <input type="text" name="phone" id="phone">
                    </div>
                    <div class="info-item">
                        <label for="email">이메일</label>
                        <input type="text" name="email" id="email">
                    </div>
                </div>
                <input type="submit" class="create-teacher-btn" value="등록">
            </form>
        </div>
    </main>
<script>
    function chkValid() {
        <%
            if (session.getAttribute("type") != null) {
                int type = (Integer) session.getAttribute("type");
                if (type == 1) { %>
            return true;
        <%      } else { %>
            alert('권한이 없습니다.');
            return false;
        <%      }
            } else { %>
            alert('로그인이 필요합니다.');
            return false;
        <%  } %>
    }
</script>
</body>
</html>

