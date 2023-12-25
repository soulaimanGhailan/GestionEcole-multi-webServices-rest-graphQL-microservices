package devops.proj.studentservice.web;

import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.dtos.StudentDTO;
import devops.proj.studentservice.exceptions.StudentNotFoundException;
import devops.proj.studentservice.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @QueryMapping
    public PictureDTO getPictureOfStudent(@Argument Long studentId){
        try {
            return this.studentService.getPictureOfStudent(studentId) ;
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**  Mutation / post delete put  **/
    @MutationMapping
    public StudentDTO addStudent(@Argument StudentDTO student){
        return this.studentService.saveStudent(student);
    }

    @MutationMapping
    public PictureDTO addStudentPicture(@Argument PictureDTO picture , @Argument Long studentId){
        try {
            return this.studentService.addPictureToStudent(picture , studentId);
        } catch (StudentNotFoundException e) {
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
    public PictureDTO updateStudentPicture(@Argument  PictureDTO picture , @Argument Long studentId){
        return this.studentService.updatePictureOfStudent(picture , studentId) ;
    }

    @MutationMapping
    public StudentDTO deleteStudent(@Argument Long studentId){
        try {
            return this.studentService.deleteStudent(studentId);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @MutationMapping
    public void deleteStudentPicture(@Argument Long studentId) throws StudentNotFoundException {
        this.studentService.deletePictureOfStudent(studentId);
    }

}
