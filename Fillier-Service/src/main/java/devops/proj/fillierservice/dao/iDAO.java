package devops.proj.fillierservice.dao;

import java.util.List;


public interface iDAO <T> {

	void saveOrUpdate(T f);
	void delete(T f);
	T getById(Long id);
	List<T> getAll();
}
