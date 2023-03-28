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

@WebServlet(name = "studentSaveServlet", urlPatterns = "/servlet/students/save")
public class StudentSaveServlet extends HttpServlet {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        int year = Integer.parseInt(req.getParameter("year"));

        Student student = new Student(studentName, year);
        studentRepository.save(student);

        PrintWriter writer = resp.getWriter();

        writer.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" + "</head>\n" +
                "<body>\n" +
                "<ul>\n" +
                "    <li>studentId="+student.getStudentId()+"</li>\n" +
                "    <li>name="+student.getStudentName()+"</li>\n" +
                " <li>year="+student.getYear()+"</li>\n" + "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
                "</html>");
    }
}
