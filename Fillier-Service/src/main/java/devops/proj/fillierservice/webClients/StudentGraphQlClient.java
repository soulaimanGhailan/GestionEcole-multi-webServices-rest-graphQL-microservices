package devops.proj.fillierservice.webClients;

import devops.proj.fillierservice.model.Student;

import java.util.List;

public interface StudentGraphQlClient {
    Student findStudentById(Long studentId);
    Student findStudentByCne(String cne) ;
    Student saveStudent(Student Student) ;
    Student updateStudent(Student Student) ;
    List<Student> getStudents(int page, int size);
    Student deleteStudent(Long studentId) ;
    void deletePictureOfStudent(Long studentId) ;
    void deleteAllStudentsOfCourse(Long courseId);
    void deleteAllStudent() ;
}
