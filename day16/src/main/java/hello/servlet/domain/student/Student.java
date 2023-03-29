package hello.servlet.domain.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private Long studentId;
    private String studentName;
    private int year;

    public Student(String studentName, int year){
        this.studentName = studentName;
        this.year = year;
    }
}
