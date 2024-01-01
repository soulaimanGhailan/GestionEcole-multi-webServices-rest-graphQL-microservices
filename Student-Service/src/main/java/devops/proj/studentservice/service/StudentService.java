package devops.proj.studentservice.service;

import devops.proj.studentservice.dtos.PageInfo;
import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.CneExistsException;
import devops.proj.studentservice.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    StudentDTO findStudentById(Long studentId) throws StudentNotFoundException;
    StudentDTO findStudentByCne(String cne) throws StudentNotFoundException;
    StudentDTO saveStudent(StudentDTO studentDTO) throws CneExistsException;
    StudentDTO updateStudent(StudentDTO studentDTO) throws StudentNotFoundException;
    List<StudentDTO> getStudents(int page, int size);
    StudentDTO deleteStudent(Long studentId) throws StudentNotFoundException;
    void deleteAllStudentsOfCourse(Long courseId);
    void deleteAllStudent() ;
    long getNumberOfStudents();
    PageInfo getPageInfo(int size);
}
