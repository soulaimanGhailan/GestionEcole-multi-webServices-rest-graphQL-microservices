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
@RequestMapping(value = "students")
public class StudentRestController {
    private StudentService studentService ;

    public StudentRestController(StudentService studentService) {
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
        try {
            return studentService.findStudentById(id);
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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

    @GetMapping("/picture/{id}")
    public PictureDTO getPictureOfStudent(@PathVariable Long id){
        try {
           return this.studentService.getPictureOfStudent(id) ;
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**  post  **/
    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        return this.studentService.saveStudent(studentDTO);
    }

    @PostMapping("/picture/{studentId}")
    public PictureDTO addStudentPicture(@RequestBody PictureDTO pictureDTO , @PathVariable Long studentId){
        try {
            return this.studentService.addPictureToStudent(pictureDTO , studentId);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**  put  **/
    @PutMapping
    public StudentDTO updateStudent(@RequestBody  StudentDTO studentDTO){
        try {
            return this.studentService.updateStudent(studentDTO);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("picture/{studentId}")
    public PictureDTO updateStudentPicture(@RequestBody  PictureDTO pictureDTO , @PathVariable Long studentId){
            return this.studentService.updatePictureOfStudent(pictureDTO , studentId) ;
    }

    /**  delete  **/
    @DeleteMapping("{studentId}")
    public StudentDTO deleteStudent(@PathVariable Long studentId){
        try {
            return this.studentService.deleteStudent(studentId);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**  delete  **/
    @DeleteMapping("picture/{studentId}")
    public void deleteStudentPicture(@PathVariable Long studentId) throws StudentNotFoundException {
         this.studentService.deletePictureOfStudent(studentId);
    }

}
