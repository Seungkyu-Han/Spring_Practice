package hello.servlet.web.servletmvc;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcStudentSaveServlet", urlPatterns = "/servlet-mvc/students/save")
public class MvcStudentSaveServlet extends HttpServlet {
    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        int year = Integer.parseInt(req.getParameter("year"));

        Student student = new Student(studentName, year);
        studentRepository.save(student);

        req.setAttribute("student", student);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
}
