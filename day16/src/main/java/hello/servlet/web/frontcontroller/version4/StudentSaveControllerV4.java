package hello.servlet.web.frontcontroller.version4;

import hello.servlet.domain.student.Student;
import hello.servlet.domain.student.StudentRepository;

import java.util.Map;

public class StudentSaveControllerV4 implements ControllerV4{

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String studentName = paramMap.get("studentName");
        int year = Integer.parseInt(paramMap.get("year"));

        Student student = new Student(studentName, year);
        studentRepository.save(student);

        model.put("student", student);

        return "save-result";
    }
}
