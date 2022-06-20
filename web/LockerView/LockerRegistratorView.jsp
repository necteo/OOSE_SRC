<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sogongimms.persistent.dto.LockerDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: songd
  Date: 2022-05-28
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Registration Page</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>--%>
<%--</head>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<%--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/MemberView/css/bootstrap.css">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
    <title>소공체육시설홈페이지</title>
    <style>
        div {
            text-align: center;
            justify-content: center;
            align-items: center;
        }

        .one {
            display: inline-block;
        }

        .two {
            padding-left: 20px;
            display: inline-block;
        }

        .table1 {
            overflow: auto;
            height: 300px;
        }

        .table2 {
            overflow: auto;
            height: 300px;

        }

        .table3 {
            clear: both;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    area-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/sogongimms/Main.jsp">소공체육시설 웹 사이트</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
            <ul class="nav navbar-nav">
                <li><a href="/sogongimms/Main.jsp">메인</a></li>
                <li><a href="/sogongimms/LectureView/Lecture/listView">강습 목록</a></li>
                <li><a href="/sogongimms/TeacherView/Teacher/lists">강사 목록</a></li>
                <li class="active"><a href="/sogongimms/LockerView/Locker/registView">사물함 신청</a></li>
                <li><a href="/sogongimms/NoticeView/Notice/lists?page=1">공지 목록</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="nav-item dropdown">
                    <a class="nav-link pl-0 dropdown-toggle" href="#"
                       data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">회원관리<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="MemberView/Member/logout">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>

    <div>
        <div class="one">
            <div class="card" style="width: 500px; margin: 50px auto auto">
                <h2 class="bg-warning text-bold card-header">사용 중인 사물함</h2>
                <div class="table1">
                    <table class="table table-hover table-striped">
                        <tr>
                            <th>사물함 번호</th>
                            <th>사용 시작일
                            <th>사용 종료일</th>
                        </tr>
                        <%
                            ArrayList<LockerDTO> usingLockerList =
                                    (ArrayList<LockerDTO>) request.getAttribute("using_locker_list");
                            for (LockerDTO locker: usingLockerList) { %>
                        <tr>
                            <td><%= locker.getLockerNo() %>
                            </td>
                            <td><%= locker.getRegistDate() %>
                            </td>
                            <td><%= locker.getDueDate() %>
                            </td>
                        </tr>
                        <%
                            } %>
                    </table>
                    <%
                    %>
                </div>
            </div>
        </div>

        <div class="two">
            <div class="card" style="width: 500px; margin: 50px auto auto;">
                <h2 class="bg-info text-bold card-header">신청 가능한 사물함</h2>
                <div class="table2">

                    <table class="table table-hover table-striped">
                        <tr>
                            <th>사물함 번호</th>
                            <th>사용 시작일
                            <th>사용 종료일</th>
                        </tr>
                        <%
                            ArrayList<LockerDTO> availableLockerList =
                                    (ArrayList<LockerDTO>) request.getAttribute("available_locker_list");
                            for(LockerDTO locker: availableLockerList) { %>
                        <tr>
                            <td><%= locker.getLockerNo() %>
                            </td>
                            <td><%= "-" %>
                            </td>
                            <td><%= "-" %>
                            </td>
                        </tr>
                        <%
                            } %>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="table3">
        <div class="card" style="width: 600px; margin: 50px auto auto;">
            <form class="form" action="regist" method="post" name="regist" onsubmit="return check()">
                <%
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar time = Calendar.getInstance();
                    String currentDate = format1.format(time.getTime());
                    Date dt;

                    try {
                        dt = format1.parse(currentDate);
                        time.setTime(dt);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    time.add(Calendar.MONTH, 1);
                    String nextMonth = format1.format(time.getTime());
                %>
                <table class="table table-hover table-striped">
                    <tr>
                        <td>사물함 번호</td>
                        <td><input type="text" name="locker_no" id = "locker_no"></td>
                    </tr>
                    <input type="hidden" name="member_id" value="<%= session.getAttribute("user_id") %>">
                    <tr>
                        <td>사용 시작일</td>
                        <td><input type="date" name="regist_date" value=<%= currentDate %> min="2022-01-01" max="2023-12-31"></td>
                    </tr>
                    <tr>
                        <td>사용 종료일</td>
                        <td><input type="date" name="due_date" value=<%= nextMonth %> min="2022-01-01" max="2023-12-31"></td>
                    </tr>
                    <tr>
                        <td><button type="button" class="btn btn-outline-danger" onclick="history.back()">뒤로가기</button></td>
                        <td><input type="submit" class="btn btn-outline-success" value="등록"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

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
            if(blank_pattern.test(str.value) == true) {
                alert('공백은 사용할 수 없습니다.');
                return false;
            }

            const special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
            if(special_pattern.test(str.value) == true) {
                alert('특수문자는 사용할 수 없습니다.');
                return false;
            }

            const regist = document.forms['regist'];
            const registDate = regist['regist_date'].value.trim();
            const dueDate = regist['due_date'].value.trim();
            if (registDate > dueDate) {
                alert('기간이 올바르지 않습니다.');
                return false;
            }
            return true;
        }
    </script>

<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/MemberView/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/MemberView/js/bootstrap.js"></script>
</body>
</html>
