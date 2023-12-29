package devops.proj.fillierservice.web;

import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.mappers.Mapper;
import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.service.FiliereService;
import devops.proj.fillierservice.webClients.StudentRestClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filliers")
@Api(value = "filliers")
public class FillierRestController {


    private StudentRestClient restClient ;
    private FiliereService filiereService ;
    private Mapper mapper ;

    public FillierRestController(StudentRestClient restClient, FiliereService filiereService, Mapper mapper) {
        this.restClient = restClient;
        this.filiereService = filiereService;
        this.mapper = mapper;
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
    public void createFillier(@RequestBody FillierDTO fillierDTO){
        this.filiereService.saveOrUpdate(fillierDTO);
    }

    @PutMapping
    public void updateStudent(@RequestBody FillierDTO fillierDTO){
        this.filiereService.saveOrUpdate(fillierDTO);
    }

    @DeleteMapping
    public void deleteFillier(@RequestBody FillierDTO fillierDTO){
        this.filiereService.delete(fillierDTO);
    }
    @DeleteMapping("/id/{id}")
    public void deleteFillierById(@PathVariable Long id){
        this.filiereService.deleteById(id);
    }
    //test
    @GetMapping("students")
    public List<Student> getAll(@RequestParam(name = "page" , defaultValue = "0") int page,
                                @RequestParam(name = "size" , defaultValue = "5")int size){
        return this.restClient.getAllStudents(page, size) ;

    }


}
