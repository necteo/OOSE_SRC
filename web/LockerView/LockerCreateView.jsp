<%--
  Created by IntelliJ IDEA.
  User: songd
  Date: 2022-05-28
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<%--    <title>Start Page</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>--%>

<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/LockerView/css/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/LockerView/css/locker.css" />
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
            <span class="teacher-menu-title">사물함</span>
            <ul class="menu-list">
                <li class="menu-item">
                    <a href="createView"> - 사물함 등록</a>
                </li>
                <li class="menu-item">
                    <a> - 사물함 삭제</a>
                </li>
                <li class="menu-item">
                    <a> - 사물함 조회</a>
                </li>
            </ul>
        </div>
    </nav>
    <main>
        <div class="main-container">
            <header>
                <div class="title-container">
                    <h2 class="menu-super-title">사물함</h2>
                    <h3 class="menu-sub-title">사물함 등록</h3>
                </div>
                <button onclick="location.href = '/sogongimms/Main.jsp'" class="exit-btn">나가기</button>
            </header>
            <form class="form" action="create" method="post" name="fm" onsubmit="return check()">
                <div class="input-container">
                    <div class="info-item">
                        <label>사물함 번호</label>
                        <input type="text" name="locker_no" id="locker_no">
                    </div>
                </div>
                <input type="submit" class="create-btn" value="등록">
            </form>
        </div>
    </main>

    <script>
        function check() {
            const str = document.getElementById('locker_no');
            if(str.value == '' || str.value == null) {
                alert('값을 입력해주세요!');
                return false;
            }

            let blank_pattern = /^\s+|\s+$/g;
            if(str.value.replace(blank_pattern, '') == "") {
                alert('공백만 입력되었습니다');
                return false;
            }

            blank_pattern = /[\s]/g;
            if(blank_pattern.test( str.value) == true) {
                alert('공백은 사용할 수 없습니다.');
                return false;
            }

            const special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
            if(special_pattern.test(str.value) == true) {
                alert('특수문자는 사용할 수 없습니다.');
                return false;
            }
            return true;
        }
    </script>
</body>
</html>


<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Registration Page</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>--%>
<%--    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>--%>
<%--</head>--%>
<%--<body class="container-fluid">--%>
<%--<div class="card" style="width: 600px; margin: 50px auto auto;">--%>
<%--    <h2 class="bg-info text-light card-header">Locker Registration</h2>--%>
<%--    <form class="form" action="create" method="post">--%>
<%--        <table class="table table-hover table-striped">--%>
<%--            <tr>--%>
<%--                <td>LockerNo:</td>--%>
<%--                <td><input type="text" name="locker_no"></td>--%>
<%--            </tr>--%>
<%--            <input type="hidden" name="member_id" value="<%= session.getAttribute("user_id") %>">--%>
<%--            <tr>--%>
<%--                <td><button type="button" class="btn btn-outline-danger" onclick="history.back()">뒤로가기</button></td>--%>
<%--                <td><input type="submit" class="btn btn-outline-success" value="등록"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>

<%--</body>--%>
