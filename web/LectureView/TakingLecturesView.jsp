<%@ page import="sogongimms.persistent.dto.LectureListDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: S
  Date: 2022-06-19
  Time: 오후 6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<LectureListDTO> lectureList = (ArrayList<LectureListDTO>) request.getAttribute("lect_list");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
        <td><%= lectureList.get(i).getLectureCode() %></td>
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
</body>
</html>
