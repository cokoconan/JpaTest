package one.test;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import one.domain.User;


public class ProfessorService {

	protected EntityManager em;

	public ProfessorService(EntityManager em) {
		this.em = em;
	}

	public Collection<User> findAllProfessors() {
		Query query = em.createQuery("SELECT e FROM User e");
		return (Collection<User>) query.getResultList();
	}

}
  