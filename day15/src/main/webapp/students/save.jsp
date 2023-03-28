<%@ page import="hello.servlet.domain.student.StudentRepository" %>
<%@ page import="hello.servlet.domain.student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  StudentRepository studentRepository = StudentRepository.getInstance();

  String studentName = request.getParameter("studentName");
  int year = Integer.parseInt(request.getParameter("year"));

  Student student = new Student(studentName, year);
  studentRepository.save(student);

%>
<html>
<head>
    <title>신입생 등록 완료</title>
    <meta charset="UTF-8">
</head>
<body>
<ul>
  <li>studentId=<%=student.getStudentId()%></li>
  <li>studentName=<%=student.getStudentName()%></li>
  <li>year=<%=student.getYear()%></li>
</ul>

<a href="/index.html">메인</a>

</body>
</html>
