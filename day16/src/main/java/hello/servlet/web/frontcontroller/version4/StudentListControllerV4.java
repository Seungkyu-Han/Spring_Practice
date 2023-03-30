package hello.servlet.web.frontcontroller.version4;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;

import java.util.List;
import java.util.Map;

public class StudentListControllerV4 implements ControllerV4{

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Student> students = studentRepository.findAll();
        model.put("students", students);

        return "students";
    }
}
