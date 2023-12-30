package devops.proj.fillierservice.web;

import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.mappers.Mapper;
import devops.proj.fillierservice.service.FiliereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filliers")
public class FillierRestController {


    private FiliereService filiereService ;
    private Mapper mapper ;

    public FillierRestController( FiliereService filiereService, Mapper mapper) {

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



}
