package devops.proj.fillierservice.beans;


import devops.proj.fillierservice.model.PageInfo;
import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClients.StudentRestClient;
import lombok.Data;
import org.springframework.beans.BeanUtils;
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
    private boolean modifiedContext ;

    public StudentBean(){
        this.student = new Student() ;
        this.currentPage = 0 ;
        this.allStudentPage =true ;
        this.modifiedContext = false ;
    }

    public void onPageLoad() {
        if(this.allStudentPage == true){
            studentsPageInfo=this.studentRestClient.getStudentsPageInfo(5) ;
            getStudentsPage(currentPage, 5);
        }
    }

    public String saveStudent(){
        this.allStudentPage=true ;
        if(this.modifiedContext == false)
            this.studentRestClient.saveStudent(student);
        else
            this.studentRestClient.updateStudent(student);
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
        BeanUtils.copyProperties(student , this.student);
        this.modifiedContext = true ;
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

    public String getLabel(){
        return this.modifiedContext==false ? "ajouter" : "modifier";
    }

}
