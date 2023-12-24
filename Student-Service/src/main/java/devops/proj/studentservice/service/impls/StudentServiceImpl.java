package devops.proj.studentservice.service.impls;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dao.entities.Student;
import devops.proj.studentservice.dao.reposotories.StudentRepo;
import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.StudentNotFoundException;
import devops.proj.studentservice.mappers.Mapper;
import devops.proj.studentservice.service.PictureService;
import devops.proj.studentservice.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo ;
    private Mapper mapper ;
    private PictureService pictureService ;

    public StudentServiceImpl(StudentRepo studentRepo, Mapper mapper, PictureService pictureService) {
        this.studentRepo = studentRepo;
        this.mapper = mapper;
        this.pictureService = pictureService;
    }

    @Override
    public StudentDTO findStudentById(Long studentId) throws StudentNotFoundException {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException("student not found exception"));
        return mapper.fromStudent(student) ;
    }

    @Override
    public StudentDTO findStudentByCne(String cne) throws StudentNotFoundException {
        Student student = studentRepo.findStudentByCne(cne);
        if(student == null) throw new StudentNotFoundException("student not found by cne exception");
        return mapper.fromStudent(student);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student savedStudent = this.studentRepo.save(mapper.fromStudentDTO(studentDTO));
        return  mapper.fromStudent(savedStudent) ;

    }

    // make sure that the image ne sera pas ecraser (do not procceed by dto mapper)
    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws StudentNotFoundException {
        Student student = this.studentRepo.findById(studentDTO.getId()).orElseThrow(
                () -> new StudentNotFoundException("student not found exception"));
        BeanUtils.copyProperties(studentDTO , student);
        return  mapper.fromStudent(student) ;
    }

    @Override
    public StudentDTO addPictureToStudent(PictureDTO pictureDTO , Long studentId) throws StudentNotFoundException {
        StudentDTO studentDTO = findStudentById(studentId);
        Picture picture = this.pictureService.create(pictureDTO);
        Student student = mapper.fromStudentDTO(studentDTO);
        student.setProfilePicture(picture);
        Student savedStudent = this.studentRepo.save(student);
        return mapper.fromStudent(savedStudent);
    }

    @Override
    public StudentDTO updatePictureOfStudent(PictureDTO pictureDTO ,Long studentId) {
        return null;
    }

    @Override
    public StudentDTO deleteStudent(Long studentId) {
        return null;
    }

    @Override
    public void deletePictureOfStudent(Long studentId) {

    }

    @Override
    public List<StudentDTO> getStudents(int page, int size) {
        Page<Student> studentsPage = this.studentRepo.findAll(PageRequest.of(page, size));
        return studentsPage.getContent().stream()
                .map(student -> mapper.fromStudent(student))
                .collect(Collectors.toList());
    }

    @Override
    public PictureDTO getPictureOfStudent(Long studentId) throws StudentNotFoundException {
        Student student = this.studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException("student not found exception"));
        return pictureService.getPicById(student.getProfilePicture().getPictureId());
    }

    @Override
    public void deleteAllStudentsOfCourse(Long courseId) {

    }

    @Override
    public void deleteAllStudent() {

    }
}
