package devops.proj.fillierservice.webClients;

import devops.proj.fillierservice.model.PageInfo;
import devops.proj.fillierservice.model.Student;

import java.util.List;

public interface StudentRestClient {
    Student findStudentById(Long studentId);
    Student findStudentByCne(String cne) ;
    Student saveStudent(Student Student) ;
    void updateStudent(Student Student) ;
    List<Student> getStudents(int page, int size);
    void deleteStudent(Long studentId) ;
    void deleteAllStudentsOfCourse(Long courseId);
    void deleteAllStudent() ;
    Long getNumberOfStudent() ;
    PageInfo getStudentsPageInfo(int size);
}
