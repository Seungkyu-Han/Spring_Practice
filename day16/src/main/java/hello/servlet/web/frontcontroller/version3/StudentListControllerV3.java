package hello.servlet.web.frontcontroller.version3;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import hello.servlet.web.frontcontroller.ModelView;

import java.util.List;
import java.util.Map;

public class StudentListControllerV3 implements ControllerV3{

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Student> students = studentRepository.findAll();

        ModelView modelView = new ModelView("students");
        modelView.getModel().put("students", students);

        return modelView;
    }
}
