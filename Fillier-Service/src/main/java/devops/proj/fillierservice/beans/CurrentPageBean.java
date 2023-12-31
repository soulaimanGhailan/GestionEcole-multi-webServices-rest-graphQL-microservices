package devops.proj.fillierservice.beans;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;

@Component
@ManagedBean
@Scope("session")
@Data
public class CurrentPageBean {
    private String currentPage ;

   public CurrentPageBean(){
       this.currentPage = "FILIERE" ;
   }

    public void goToFilieres() {
        this.currentPage="FILIERE" ;
    }

    public void goToStudents() {
        this.currentPage = "STUDENT" ;
    }


}
