package devops.proj.studentservice.web;

import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.StudentNotFoundException;
import devops.proj.studentservice.service.PictureService;
import devops.proj.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/rest/students")
public class StudentRestController {
    private StudentService studentService ;

    public StudentRestController(StudentService studentService, PictureService pictureService) {
        this.studentService = studentService;
    }

    /**  Get  **/
    @GetMapping
    public List<StudentDTO> getStudentPage(@RequestParam(name = "page" , defaultValue = "0") int page,
                                           @RequestParam(name = "size" , defaultValue = "5")int size){
        return studentService.getStudents(page , size) ;
    }
    @GetMapping("id/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("cne/{cne}")
    public ResponseEntity<StudentDTO> getStudentByCne(@PathVariable String cne){
        try {
            return new ResponseEntity<>(studentService.findStudentByCne(cne) , HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
    }

    /**  post  **/
    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        return this.studentService.saveStudent(studentDTO);
    }

    @PostMapping("picture")
    public StudentDTO addStudentPicture(@RequestBody PictureDTO pictureDTO){
        return this.studentService.addPictureToStudent(pictureDTO);
    }

    /**  delete  **/
    @DeleteMapping("{studentId}")
    public StudentDTO deleteStudent(@PathVariable Long studentId){
        return this.studentService.deleteStudent(studentId);
    }

    /**  put  **/
    @PutMapping
    public StudentDTO updateStudent(StudentDTO studentDTO){
        return this.studentService.updateStudent(studentDTO);
    }

}
