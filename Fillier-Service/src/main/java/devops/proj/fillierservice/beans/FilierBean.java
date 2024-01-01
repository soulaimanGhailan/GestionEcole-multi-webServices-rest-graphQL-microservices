package devops.proj.fillierservice.beans;

import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.service.FiliereService;
import devops.proj.fillierservice.webClients.StudentRestClient;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")
@Data
public class FilierBean {
    @Autowired
    private FiliereService filiereService ;
    @Autowired
    private StudentRestClient studentRestClient ;
    private FillierDTO fillierDTO ;
    private boolean modifyContext;

    public FilierBean() {
        this.fillierDTO =new FillierDTO() ;
        this.modifyContext = false ;
    }


    public String save(){
        setModifyContext(false);
        this.filiereService.saveOrUpdate(fillierDTO);
        this.fillierDTO = new FillierDTO() ;
        return "SUCCESS" ;
    }
    public String delete(FillierDTO fillierDTO){
        //delete all of the student related ;
        this.studentRestClient.deleteAllStudentsOfCourse(fillierDTO.getId());
        this.filiereService.delete(fillierDTO);
        return "SUCCESS";
    }
    public List<FillierDTO> getListFiliers(){
        return this.filiereService.getAll() ;
    }

    public String update(FillierDTO fillierDTO){
        this.setModifyContext(true);
        BeanUtils.copyProperties(fillierDTO ,this.fillierDTO);
        return "SUCCESS" ;
    }
    public boolean isModifyContext() {
        return modifyContext;
    }
    public void setModifyContext(boolean modifyContext) {
        this.modifyContext = modifyContext;
    }
    public String getLabel() {
        return isModifyContext() ? "Modification" : "Ajout";
    }
}
