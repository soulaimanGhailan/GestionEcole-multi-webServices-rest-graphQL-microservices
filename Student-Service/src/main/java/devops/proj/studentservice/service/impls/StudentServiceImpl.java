package devops.proj.studentservice.service.impls;

import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.StudentNotFoundException;
import devops.proj.studentservice.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentDTO findStudentById(Long studentId) {
        return null;
    }

    @Override
    public StudentDTO findStudentByCne(String cne) throws StudentNotFoundException {
        return null;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO addPictureToStudent(PictureDTO pictureDTO) {
        return null;
    }

    @Override
    public StudentDTO deleteStudent(Long studentId) {
        return null;
    }

    @Override
    public List<StudentDTO> getStudents(int page, int size) {
        return null;
    }

    @Override
    public void deleteAllStudentsOfCourse(Long courseId) {

    }

    @Override
    public void deleteAllStudent() {

    }
}
