package devops.proj.fillierservice.mappers;

import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.entities.Fillier;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MapperImpl implements Mapper {
    @Override
    public Fillier fromFillierDTO(FillierDTO fillierDTO) {
        Fillier fillier = new Fillier() ;
        BeanUtils.copyProperties(fillierDTO , fillier);
        return fillier;
    }

    @Override
    public FillierDTO fromFillier(Fillier fillier) {
        FillierDTO fillierDTO = new FillierDTO() ;
        BeanUtils.copyProperties(fillier , fillierDTO);
        return fillierDTO;
    }
}
