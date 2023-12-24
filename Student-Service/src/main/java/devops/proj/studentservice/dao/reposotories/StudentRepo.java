package devops.proj.studentservice.dao.reposotories;

import devops.proj.studentservice.dao.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student , Long> {
    Student findStudentByCne(String cne);
    Student findStudentByProfilePicturePictureId(Long pictureId);
}
