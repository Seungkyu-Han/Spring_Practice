package hello.servlet.web.frontcontroller.version2.controller;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.version2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StudentSaveControllerV2 implements ControllerV2 {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        int year = Integer.parseInt(request.getParameter("year"));

        Student student = new Student(studentName, year);
        studentRepository.save(student);

        request.setAttribute("student", student);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
