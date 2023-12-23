package devops.proj.studentservice.service;


import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    StudentDTO findStudentById(Long studentId);
    StudentDTO findStudentByCne(String cne) throws StudentNotFoundException;
    StudentDTO saveStudent(StudentDTO studentDTO) ;
    StudentDTO updateStudent(StudentDTO studentDTO);
    StudentDTO addPictureToStudent(PictureDTO pictureDTO) ;
    List<StudentDTO> getStudents(int page, int size);
    StudentDTO deleteStudent(Long studentId);
    void deletePictureOfStudent(Long studentId);
    void deleteAllStudentsOfCourse(Long courseId);
    void deleteAllStudent() ;
}
