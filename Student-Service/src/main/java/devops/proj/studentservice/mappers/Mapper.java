package devops.proj.studentservice.mappers;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dao.entities.Student;
import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.dtos.StudentDTO;

public interface Mapper {

    Student fromStudentDTO(StudentDTO studentDTO);
    StudentDTO fromStudent(Student student);

    Picture fromPictureDTO(PictureDTO pictureDTO) ;
    PictureDTO fromPicture(Picture picture);

}
