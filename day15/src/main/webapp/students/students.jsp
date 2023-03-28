<%@ page import="hello.servlet.domain.student.StudentRepository" %>
<%@ page import="hello.servlet.domain.student.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    StudentRepository studentRepository = StudentRepository.getInstance();
    List<Student> students = studentRepository.findAll();
%>
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
    <%
        for(Student student: students){
            out.write("<tr>\n");
            out.write("<td>" + student.getStudentId() + "</td>\n");
            out.write("<td>" + student.getStudentName() + "</td>\n");
            out.write("<td>" + student.getYear() + "</td>\n");
            out.write("</tr>\n");
        }
    %>
    </tbody>
</table>

</body>
</html>
