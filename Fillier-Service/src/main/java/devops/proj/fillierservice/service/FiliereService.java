package devops.proj.fillierservice.service;


import devops.proj.fillierservice.dtos.FillierDTO;

import java.util.List;

public interface FiliereService {
	void saveOrUpdate(FillierDTO f);
	void delete(FillierDTO f);
	FillierDTO getById(Long id);
	List<FillierDTO> getAll();
	void deleteById(Long id);
}
