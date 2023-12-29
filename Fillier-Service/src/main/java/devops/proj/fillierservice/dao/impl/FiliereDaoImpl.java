package devops.proj.fillierservice.dao.impl;


import devops.proj.fillierservice.dao.FiliereDAO;
import devops.proj.fillierservice.entities.Fillier;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Repository
public class FiliereDaoImpl extends HibernateDaoSupport implements FiliereDAO {

	@Autowired
	public void setUpSessionFactory(SessionFactory sf) {
		this.setSessionFactory(sf);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Fillier f) {
	
		this.getHibernateTemplate().saveOrUpdate(f);
	}
	
	
	@Override
	@Transactional
	public void delete(Fillier f) {
		this.getHibernateTemplate().delete(f);
	}

	@Override
	public Fillier getById(Long id) {
		
		return this.getHibernateTemplate().get(Fillier.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fillier> getAll() {
		return (List<Fillier>) this.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Fillier.class));
	}
}
