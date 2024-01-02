package devops.proj.studentservice.web;

import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.StudentNotFoundException;
import devops.proj.studentservice.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class StudentGraphQlController {
    private StudentService studentService ;

    public StudentGraphQlController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**(very important) --->>> the names of the variable have to be the same in graphQl schema**/
//    /**  Query  **/
//    @QueryMapping
//    public List<StudentDTO> getStudentPage(@RequestParam(name = "page" , defaultValue = "0") int page,
//                                           @RequestParam(name = "size" , defaultValue = "5")int size){
//        return studentService.getStudents(page , size) ;
//    }
    @QueryMapping
    public StudentDTO getStudentById(@Argument Long id){
        try {
            return studentService.findStudentById(id);
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @QueryMapping
    public ResponseEntity<StudentDTO> getStudentByCne(@Argument String cne){
        try {
            return new ResponseEntity<>(studentService.findStudentByCne(cne) , HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
    }


    /**  Mutation / post delete put  **/
    @MutationMapping
    public StudentDTO addStudent(@Argument StudentDTO student){
        try {
            return this.studentService.saveStudent(student);
        } catch (devops.proj.studentservice.exceptions.CneExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @MutationMapping
    public StudentDTO updateStudent(@Argument  StudentDTO student){
        try {
            return this.studentService.updateStudent(student);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @MutationMapping
    public StudentDTO deleteStudent(@Argument Long studentId){
        try {
            return this.studentService.deleteStudent(studentId);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
