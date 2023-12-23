package devops.proj.studentservice.dao.reposotories;

import devops.proj.studentservice.dao.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student , Long> {
}
