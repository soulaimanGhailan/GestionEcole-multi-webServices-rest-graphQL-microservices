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
        BeanUtils.copyProperties(student , studentDTO);
        return studentDTO;
    }

    @Override
    public Picture fromPictureDTO(PictureDTO pictureDTO) {
        Picture picture = new Picture() ;
        byte[] pictureContent = fromStringBase64ToByte(pictureDTO.getImageContentBase64());
        picture.setPictureContent(pictureContent);
        BeanUtils.copyProperties(pictureDTO , picture);
        return picture;
    }

    @Override
    public PictureDTO fromPicture(Picture picture) {
        PictureDTO pictureDTO = new PictureDTO() ;
        String imageContentBase64 = fromByteToStringBase64Image(picture.getPictureContent());
        pictureDTO.setImageContentBase64(imageContentBase64);
        BeanUtils.copyProperties(picture , pictureDTO);
        return pictureDTO;
    }

    // convert StringBase64 image to byte[]
    private byte[] fromStringBase64ToByte(String imageBase64){
        String base64Data = imageBase64 ;
        if(imageBase64.startsWith("data:image/jpeg;base64,")) {
            base64Data = imageBase64.substring(imageBase64.indexOf(",") + 1);
        }
        byte[] picContent = Base64.decodeBase64(base64Data);
        return picContent ;
    }

    // convert image byte[] to String base64
    private String fromByteToStringBase64Image(byte[] imageData){
        return Base64.encodeBase64String(imageData);
    }
}
