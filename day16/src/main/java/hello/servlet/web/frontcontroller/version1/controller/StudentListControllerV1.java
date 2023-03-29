package hello.servlet.web.frontcontroller.version1.controller;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import hello.servlet.web.frontcontroller.version1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class StudentListControllerV1 implements ControllerV1 {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentRepository.findAll();
        request.setAttribute("students", students);

        String viewPath = "/WEB-INF/views/students.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
