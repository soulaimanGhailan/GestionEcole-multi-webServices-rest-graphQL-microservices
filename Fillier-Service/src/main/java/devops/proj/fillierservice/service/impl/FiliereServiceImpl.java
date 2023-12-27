package devops.proj.fillierservice.service.impl;
import devops.proj.fillierservice.dao.FiliereDAO;
import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.entities.Fillier;
import devops.proj.fillierservice.mappers.Mapper;
import devops.proj.fillierservice.service.FiliereService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FiliereServiceImpl implements FiliereService {

	private FiliereDAO filiereDao ;
	private Mapper mapper ;

	@Override
	@Transactional
	public void saveOrUpdate(Fillier f) {
		this.filiereDao.saveOrUpdate(f);
	}

	@Override
	@Transactional
	public void delete(Fillier f) {
		this.filiereDao.delete(f);		
	}

	@Override
	public FillierDTO getById(Long id) {
		return mapper.fromFillier(this.filiereDao.getById(id));
	}

	@Override
	@Transactional
	public List<FillierDTO> getAll() {
		List<Fillier> filieres = this.filiereDao.getAll();
		return filieres.stream()
						.map(fillier -> mapper.fromFillier(fillier) )
						.collect(Collectors.toList()) ;
	}
}
