package devops.proj.fillierservice.web;

import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClients.StudentRestClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students/rest")
public class StudentExposeRestWebservice {

    private StudentRestClient studentRestClient ;

    public StudentExposeRestWebservice(StudentRestClient studentRestClient) {
        this.studentRestClient = studentRestClient;
    }

    /**  Get  **/
    @GetMapping
    public List<Student> getStudents(@RequestParam(name = "page" , defaultValue = "0") int page,
                                           @RequestParam(name = "size" , defaultValue = "5")int size){
        List<Student> students = this.studentRestClient.getStudents(page, size);
        return students;
    }
    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable Long id){
       return this.studentRestClient.findStudentById(id) ;
    }

    @GetMapping("/cne/{cne}")
    public Student getStudentByCne(@PathVariable String cne){
        return this.studentRestClient.findStudentByCne(cne) ;
    }


    /**  post  **/
    @PostMapping
    public Student addStudent(@RequestBody Student student){
      return this.studentRestClient.saveStudent(student);
    }


    /**  put  **/
    @PutMapping
    public void updateStudent(@RequestBody  Student student){
       this.studentRestClient.updateStudent(student) ;
    }

    /**  delete  **/
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
         this.studentRestClient.deleteStudent(studentId) ;
    }

}
