package one.test;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import one.domain.User;


public class MainTest {
	public static void main(String[] args) {
		
		EntityManagerFactory em =
			      Persistence.createEntityManagerFactory("ProfessorService");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		EntityManager entitymanager = em.createEntityManager();
		
		ProfessorService service = new ProfessorService(entitymanager);
		
		entitymanager.getTransaction().begin();
		
		Collection<User> usr = service.findAllProfessors();
		
		for(User tmp : usr){ 
			System.out.println(tmp.getName());
		}
		
		
		/*
		CriteriaQuery<User> q =  cb.createQuery(User.class);
		//Root 는 쿼리의 모든 조인, 경로, Attributes 의 기준을 정의한다.
		//Criteria 쿼리에서 Root 는 언제나 Entity 이다.
		//Root 는 Criteria에 의해 정의되며 추가된다. Criteria는 javax.persistence.criteria.CriteriaQuery 메소드에 의해 오버라이드 된다. 
		Root<User> c = q.from(User.class);
		
		System.out.println("Select all records");
	    CriteriaQuery<User> select = q.select(c);
	    TypedQuery<User> typedQuery = entitymanager.createQuery(select);
	    List<User> resultlist = typedQuery.getResultList();
	    */
	    
		//q.select(c.get("name"), cb.count(c.get("name")));
	    
	    entitymanager.close( );
	    em.close( );
	}

}
