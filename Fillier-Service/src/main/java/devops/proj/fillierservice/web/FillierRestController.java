package devops.proj.fillierservice.web;

import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.entities.Fillier;
import devops.proj.fillierservice.service.FiliereService;
import devops.proj.fillierservice.webClients.StudentRestClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fillier")
public class FillierRestController {


    private StudentRestClient restClient ;
    private FiliereService filiereService ;

    public FillierRestController(StudentRestClient restClient, FiliereService filiereService) {
        this.restClient = restClient;
        this.filiereService = filiereService;
    }

    @GetMapping
    public List<FillierDTO> getFilliers(){
        return this.filiereService.getAll() ;
    }

    @GetMapping("/id/{id}")
    public FillierDTO getById(@PathVariable Long id){
        return this.filiereService.getById(id);
    }

    @PostMapping
    public void createFillier(@RequestBody Fillier fillier){
         this.filiereService.saveOrUpdate(fillier);
    }

}
