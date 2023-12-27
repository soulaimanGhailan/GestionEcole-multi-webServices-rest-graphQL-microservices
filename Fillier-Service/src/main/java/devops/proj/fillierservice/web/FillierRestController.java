package devops.proj.fillierservice.web;

import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClient.StudentRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fillier")
public class FillierRestController {

    @Autowired
    private StudentRestClient restClient ;

    @GetMapping("/test/{id}")
    public Student getaa(@PathVariable Long id){
        return restClient.getStudentById(id);
    }

    @GetMapping("cc")
    public Student create(){
        Student student = new Student() ;
        student.setEmail("xxxx");
        student.setCne("xxxxxx");
        student.setFirstName("xxxxx");
        student.setLastName("xxxxxx");
        return restClient.createStudent(student);
    }

}
