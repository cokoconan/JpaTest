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
		//Root �� ������ ��� ����, ���, Attributes �� ������ �����Ѵ�.
		//Criteria �������� Root �� ������ Entity �̴�.
		//Root �� Criteria�� ���� ���ǵǸ� �߰��ȴ�. Criteria�� javax.persistence.criteria.CriteriaQuery �޼ҵ忡 ���� �������̵� �ȴ�. 
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
