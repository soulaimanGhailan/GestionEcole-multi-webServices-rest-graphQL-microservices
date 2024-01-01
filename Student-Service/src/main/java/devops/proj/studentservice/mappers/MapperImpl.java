package devops.proj.studentservice.mappers;

import devops.proj.studentservice.dao.entities.Student;
import devops.proj.studentservice.dtos.StudentDTO;
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

}
