package devops.proj.fillierservice.webClients.impls;

import devops.proj.fillierservice.model.Picture;
import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClients.StudentGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentGraphQlClientImpl implements StudentGraphQlClient {

    @Override
    public Student findStudentById(Long studentId) {
        return null;
    }

    @Override
    public Student findStudentByCne(String cne) {
        return null;
    }

    @Override
    public Student saveStudent(Student Student) {
        return null;
    }

    @Override
    public Student updateStudent(Student Student) {
        return null;
    }

    @Override
    public Picture addPictureToStudent(Picture Picture, Long studentId) {
        return null;
    }

    @Override
    public Picture updatePictureOfStudent(Picture Picture, Long studentId) {
        return null;
    }

    @Override
    public List<Student> getStudents(int page, int size) {
        return null;
    }

    @Override
    public Picture getPictureOfStudent(Long studentId) {
        return null;
    }

    @Override
    public Student deleteStudent(Long studentId) {
        return null;
    }

    @Override
    public void deletePictureOfStudent(Long studentId) {

    }

    @Override
    public void deleteAllStudentsOfCourse(Long courseId) {

    }

    @Override
    public void deleteAllStudent() {

    }
}
