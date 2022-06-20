<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-05-18
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="MemberView/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
    <title>소공체육시설홈페이지</title>
</head>
<body>
<% //로그인 세션 관리
    Integer type = null;
    if (session.getAttribute("type") != null) {
        type = (Integer) session.getAttribute("type");
    }

    if (type == null) { %>
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        area-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Main.jsp">소공체육시설 웹 사이트</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="Main.jsp">메인</a></li>
                    <li><a href="LectureView/Lecture/listView">강습 목록</a></li>
                    <li><a href="TeacherView/Teacher/lists">강사 목록</a></li>
                    <li><a href="NoticeView/Notice/lists?page=1">공지 목록</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item dropdown">
                        <a class="nav-link pl-0 dropdown-toggle" href="#"
                           data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">접속하기<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="MemberView/Member/login">로그인</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
<%  } else if (type == 2) { %>
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        area-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Main.jsp">소공체육시설 웹 사이트</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="Main.jsp">메인</a></li>
                    <li><a href="MemberView/Member/lists">회원 조회</a></li>
                    <li><a href="MemberView/Member/join">회원 등록</a></li>
                    <li><a href="LectureView/Lecture/listView">강습 목록</a></li>
                    <li><a href="TeacherView/Teacher/lists">강사 목록</a></li>
                    <li><a href="LockerView/Locker/createView">사물함 등록</a></li>
                    <li><a href="NoticeView/Notice/lists?page=1">공지 목록</a></li>
                    <li><a href="SalesView/Sales/salesView">매출 메인</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item dropdown">
                        <a class="nav-link pl-0 dropdown-toggle" href="#"
                           data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">관리자관리<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="MemberView/Member/logout">로그아웃</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
<%  } else { %>
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        area-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Main.jsp">소공체육시설 웹 사이트</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="Main.jsp">메인</a></li>
                    <li><a href="LectureView/Lecture/listView">강습 목록</a></li>
                    <li><a href="TeacherView/Teacher/lists">강사 목록</a></li>
                    <li><a href="LockerView/Locker/registView">사물함 신청</a></li>
                    <li><a href="NoticeView/Notice/lists?page=1">공지 목록</a></li>
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
<%  } %>

<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="MemberView/js/bootstrap.min.js"></script>
<script src="MemberView/js/bootstrap.js"></script>
</body>
</html>
