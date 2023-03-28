<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 조회</title>
    <meta charset="UTF-8">
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>studentId</th>
    <th>studentName</th>
    <th>year</th>
    </thead>
    <tbody>
    <c:forEach var = "student" items="${students}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.year}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
