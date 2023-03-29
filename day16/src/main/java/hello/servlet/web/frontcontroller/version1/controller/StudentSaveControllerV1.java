package hello.servlet.web.frontcontroller.version1.controller;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import hello.servlet.web.frontcontroller.version1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StudentSaveControllerV1 implements ControllerV1 {

    private StudentRepository studentRepository = StudentRepository.getInstance();


    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        int year = Integer.parseInt(request.getParameter("year"));

        Student student = new Student(studentName, year);
        studentRepository.save(student);

        request.setAttribute("student", student);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
