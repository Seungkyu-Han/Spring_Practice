package hello.servlet.domain.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private static Map<Long, Student> store = new HashMap<>();
    private static long STUDENT_ID_SEQUENCE = 0L;

    private static final StudentRepository instance = new StudentRepository();

    public static StudentRepository getInstance(){
        return instance;
    }

    private StudentRepository() {}

    public Student save(Student student){
        student.setStudentId(++STUDENT_ID_SEQUENCE);
        store.put(student.getStudentId(), student);
        return student;
    }

    public Student findById(Long id){
        return store.get(id);
    }

    public List<Student> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}