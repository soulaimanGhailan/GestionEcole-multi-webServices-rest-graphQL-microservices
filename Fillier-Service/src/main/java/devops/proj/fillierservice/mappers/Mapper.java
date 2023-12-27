package devops.proj.fillierservice.mappers;

import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.entities.Fillier;

public interface Mapper {
    Fillier fromFillierDTO(FillierDTO fillierDTO) ;
    FillierDTO fromFillier(Fillier fillier) ;
}
