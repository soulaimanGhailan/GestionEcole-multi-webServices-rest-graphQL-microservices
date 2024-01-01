package devops.proj.studentservice.dao.reposotories;

import devops.proj.studentservice.dao.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student , Long> {
    Student findStudentByCne(String cne);
    @Modifying
    @Query("DELETE FROM Student s WHERE s.courseId = :courseId")
    void deleteByCourseId(Long courseId);
}
