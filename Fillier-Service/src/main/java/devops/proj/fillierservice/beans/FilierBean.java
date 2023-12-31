package devops.proj.fillierservice.beans;

import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.service.FiliereService;
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
    private FillierDTO fillierDTO ;
    public FilierBean() {
        this.fillierDTO =new FillierDTO() ;
    }

    public String save(){
        this.filiereService.saveOrUpdate(fillierDTO);
        this.fillierDTO = new FillierDTO() ;
        return "SUCCESS" ;
    }
    public String delete(FillierDTO fillierDTO){
        this.filiereService.delete(fillierDTO);
        return "SUCCESS";
    }
    public List<FillierDTO> getListFiliers(){
        return this.filiereService.getAll() ;
    }

    public String update(FillierDTO fillierDTO){
        BeanUtils.copyProperties(fillierDTO ,this.fillierDTO);
        return "SUCCESS" ;
    }
}
