package hello.servlet.domain.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    StudentRepository studentRepository = StudentRepository.getInstance();

    @AfterEach
    void afterEach(){
        studentRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Student student = new Student("hyunttai", 2022);

        //when
        Student savedStudent = studentRepository.save(student);

        //then
        Student findStudent = studentRepository.findById(savedStudent.getStudentId());
        Assertions.assertEquals(savedStudent, findStudent);
    }

    @Test
    void findAll(){
        //given
        Student student1 = new Student("hyeontae", 2022);
        Student student2 = new Student("hyeonttai", 2022);

        //when
        studentRepository.save(student1);
        studentRepository.save(student2);
        List<Student> result = studentRepository.findAll();

        //then
        Assertions.assertEquals(result.size(), 2);
        org.assertj.core.api.Assertions.assertThat(result).contains(student1, student2);
    }
}