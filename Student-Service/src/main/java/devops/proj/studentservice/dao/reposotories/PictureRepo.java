package devops.proj.studentservice.dao.reposotories;

import devops.proj.studentservice.dao.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepo extends JpaRepository<Picture , String> {
}
