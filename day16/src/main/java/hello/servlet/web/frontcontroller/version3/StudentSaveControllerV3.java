package hello.servlet.web.frontcontroller.version3;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;
import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public class StudentSaveControllerV3 implements ControllerV3{

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String studentName = paramMap.get("studentName");
        int year = Integer.parseInt(paramMap.get("year"));

        Student student = new Student(studentName, year);
        studentRepository.save(student);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("student", student);
        return modelView;
    }
}
