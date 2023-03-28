package hello.servlet.web.servlet;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "studentListServlet", urlPatterns = "/servlet/students")
public class StudentListServlet extends HttpServlet {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        List<Student> students = studentRepository.findAll();

        PrintWriter writer = resp.getWriter();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("    <meta charset=\"UTF-8\">");
        writer.write("    <title>신입생 전체 조회</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<a href=\"/index.html\">메인</a>");
        writer.write("<table>");
        writer.write("    <thead>");
        writer.write("    <th>studentId</th>");
        writer.write("    <th>studentName</th>");
        writer.write("    <th>year</th>");
        writer.write("    </thead>");
        writer.write("    <tbody>");
        for (Student student : students) {
            writer.write("    <tr>");
            writer.write("        <td>" + student.getStudentId() + "</td>");
            writer.write("        <td>" + student.getStudentName() + "</td>");
            writer.write("        <td>" + student.getYear() + "</td>");
            writer.write("    </tr>");
        }
        writer.write("    </tbody>");
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
