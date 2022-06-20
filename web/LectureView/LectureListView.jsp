<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 2022-05-25
  Time: 오후 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sogongimms.persistent.dto.LectureListDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<LectureListDTO> lectureList = (ArrayList<LectureListDTO>) request.getAttribute("lect_list");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>강습 목록 조회 화면</title>
</head>
<body>
    <form action="register" method="post">
        <table border="1">
            <caption>강습 목록</caption>
            <thead>
                <tr>
                    <th>강습코드</th>
                    <th>강습명</th>
                    <th>종목</th>
                    <th>성별</th>
                    <th>최대인원</th>
                    <th>요일</th>
                    <th>강사</th>
                    <th>시작시간</th>
                    <th>종료시간</th>
                </tr>
            </thead>
            <tbody>
            <%
                if (lectureList != null) {
                    for (int i = 0; i < lectureList.size(); i++) {
            %>
                        <tr>
                            <td><input type="radio" name="register" value="<%= lectureList.get(i).getLectureCode() %>">
                                <%= lectureList.get(i).getLectureCode() %></td>
                            <td><%= lectureList.get(i).getLectureName() %></td>
                            <td><%= lectureList.get(i).getSports() %></td>
                            <td><%
                                    if (lectureList.get(i).getGender() == 0) { %>
                                        남자
                                <%  } else if (lectureList.get(i).getGender() == 1) { %>
                                        여자
                                <%  } else { %>
                                        남자, 여자
                                <%  } %></td>
                            <td><%= lectureList.get(i).getCapacity() %></td>
                            <td><%= lectureList.get(i).getWeeks() %></td>
                            <td><%= lectureList.get(i).getTeacherName() %></td>
                            <td><%= lectureList.get(i).getStartTime() %></td>
                            <td><%= lectureList.get(i).getEndTime() %></td>
                        </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
        <input type="submit" value="수강 신청">
    </form>
    <form method="post" action="lists">
        <select name="filter">
            <option value="">::검색 유형::</option>
            <option value="1">강습명</option>
            <option value="2">종목</option>
        </select>
        <input type="text" name="keyword" placeholder="검색어를 입력하세요">
        <button type="submit">강습 조회</button>
    </form>
    <%
        Integer type = null;
        if (session.getAttribute("type") != null) {
            type = (Integer) session.getAttribute("type");
        }

        if (type != null && type >= 1) { %>
            <button type="button" onclick="location.href='createView'">강습 등록</button>
    <%  } %>
    <%
        type = null;
        if (session.getAttribute("type") != null) {
            type = (Integer) session.getAttribute("type");
        }

        if (type != null && type == 0) { %>
    <button type="button" onclick="location.href='takingView'">수강 중인 강습</button>
    <%  } %>
    <a href="/sogongimms/Main.jsp">메인으로 돌아가기</a>

</body>
</html>
