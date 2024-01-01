package devops.proj.fillierservice.beans;


import devops.proj.fillierservice.model.PageInfo;
import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClients.StudentRestClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
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
    private Long studentsSize ;
    private PageInfo studentsPageInfo ;
    private int currentPage;
    private boolean allStudentPage ;

    public StudentBean(){
        this.student = new Student() ;
        this.currentPage = 0 ;
        this.allStudentPage =true ;
    }

    public void onPageLoad() {
        if(this.allStudentPage == true){
            studentsPageInfo=this.studentRestClient.getStudentsPageInfo(5) ;
            getStudentsPage(currentPage, 5);
        }
    }

    public String saveStudent(){
        this.allStudentPage=true ;
        this.studentRestClient.saveStudent(student);
        return "SUCCESS" ;
    }


    public void getStudentById(){
        this.students=List.of(this.studentRestClient.findStudentById(this.student.getId())) ;
    }

    public void getStudentByCne(){
        this.allStudentPage=false ;
        this.students=List.of( this.studentRestClient.findStudentByCne(this.student.getCne()));
    }

    public void getStudentsPage(int page, int size){
        this.students = this.studentRestClient.getStudents(page ,size) ;
    }

    public void update(Student student) {
        this.allStudentPage=true ;
        this.studentRestClient.updateStudent(student);
        getStudentsPage(0 , 5);
    }

    public void delete(Student student) {
        this.allStudentPage=true ;
        this.studentRestClient.deleteStudent(student.getId());
        this.getStudentsPage(0 ,5 );
    }

    public List<Integer> getPageNumbers() {
        List<Integer> nums = new ArrayList<>() ;
        for (int i = 0; i <this.studentsPageInfo.getTotalPages() ; i++) {
            nums.add(i);
        }
        return nums ;
    }


}
