package hello.servlet.web.frontcontroller.version2.controller;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.version2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class StudentListControllerV2 implements ControllerV2 {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentRepository.findAll();
        request.setAttribute("students", students);

        return new MyView("/WEB-INF/views/students.jsp");
    }
}
