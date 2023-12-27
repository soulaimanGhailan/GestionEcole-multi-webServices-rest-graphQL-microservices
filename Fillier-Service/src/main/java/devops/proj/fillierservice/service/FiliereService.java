package devops.proj.fillierservice.service;


import devops.proj.fillierservice.dtos.FillierDTO;
import devops.proj.fillierservice.entities.Fillier;

import java.util.List;

public interface FiliereService {
	void saveOrUpdate(Fillier f);
	void delete(Fillier f);
	FillierDTO getById(Long id);
	List<FillierDTO> getAll();
}
