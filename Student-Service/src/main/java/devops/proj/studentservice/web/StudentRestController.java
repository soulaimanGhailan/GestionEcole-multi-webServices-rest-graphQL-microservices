package devops.proj.studentservice.web;


import devops.proj.studentservice.dtos.PageInfo;
import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.CneExistsException;
import devops.proj.studentservice.exceptions.StudentNotFoundException;
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
    @GetMapping("pageInfo")
    public PageInfo getStudentsNumber(@RequestParam(name = "size" , defaultValue = "5")int size){
        return this.studentService.getPageInfo(size);
    }

    /**  post  **/
    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO){
        try {
            return this.studentService.saveStudent(studentDTO);
        } catch (CneExistsException e) {
            e.printStackTrace();
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


    /**  delete  **/
    @DeleteMapping("{studentId}")
    public StudentDTO deleteStudent(@PathVariable Long studentId){
        try {
            return this.studentService.deleteStudent(studentId);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("filiere/{filiereId}")
    public void deleteStudentOfFiliere(@PathVariable Long filiereId){
        System.out.println(filiereId);
        this.studentService.deleteAllStudentsOfCourse(filiereId);
    }


}
