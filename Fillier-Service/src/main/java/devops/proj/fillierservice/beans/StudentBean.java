package devops.proj.fillierservice.beans;


import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClients.StudentRestClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")
@Data
public class StudentBean {
    @Autowired
    private StudentRestClient studentRestClient ;

    private Student student ;
    private List<Student> students ;

    public StudentBean(){
        this.student = new Student() ;
    }

    public void onPageLoad() {
        getStudentsPage(0, 5);
    }

    public String saveStudent(){
        this.studentRestClient.saveStudent(student);
        return "SUCCESS" ;
    }
    public void updateStudent(){
        this.studentRestClient.updateStudent(student);
    }
    public Student getStudentById(){
        return this.studentRestClient.findStudentById(this.student.getId()) ;
    }
    public Student getStudentByCne(){
        return this.studentRestClient.findStudentByCne(this.student.getCne()) ;
    }
    void getStudentsPage(int page, int size){
        this.students = this.studentRestClient.getStudents(page ,size) ;
    }

    public void update(Student student) {
        this.studentRestClient.updateStudent(student);
        getStudentsPage(0 , 5);
    }

    public void delete(Student student) {
        this.studentRestClient.updateStudent(student);
        this.getStudentsPage(0 ,5 );
    }
}
