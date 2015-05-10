package one.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import one.domain.User;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("$objectdb/db/user.odb");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setAge(i);
			u.setName("나는" + i);
			em.persist(u);
		}
		em.getTransaction().commit();

		Query q1 = em.createQuery("SELECT COUNT(u) FROM User u");
		System.out.println("Total User : " + q1.getSingleResult());

		TypedQuery<User> query = em.createQuery("SELECT u FROM User u",
				User.class);
		List<User> results = query.getResultList();
		for (User u : results) {
			System.out.println("순번 : " + u.getIdx());
			System.out.println("나이 : " + u.getAge());
			System.out.println("이름 : " + u.getName());
		}
		
		em.close();
        emf.close();


	}
}
