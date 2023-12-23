package devops.proj.studentservice.mappers;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dao.entities.Student;
import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.dtos.StudentDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MapperImpl implements Mapper {
    @Override
    public Student fromStudentDTO(StudentDTO studentDTO) {
        Student student = new Student() ;
        BeanUtils.copyProperties(studentDTO ,student);
        return  student ;
    }

    @Override
    public StudentDTO fromStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO() ;
        byte[] imageData  = student.getStudentProfilePicture().getPictureContent();
        String base64Image = Base64.encodeBase64String(imageData);
        studentDTO.setImageContentBase64(base64Image);
        BeanUtils.copyProperties(student , studentDTO);
        return studentDTO;
    }

    @Override
    public Picture fromPictureDTO(PictureDTO pictureDTO) {
        return null;
    }

    @Override
    public PictureDTO fromPicture(Picture picture) {
        return null;
    }
}
