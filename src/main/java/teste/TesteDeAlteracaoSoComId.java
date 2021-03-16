package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cone;

public class TesteDeAlteracaoSoComId {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		Cone cone = new Cone();
		cone.setId(1L);
		cone.setApelido("apelido sem carregar");
		
		em.getTransaction().begin();
		cone = em.merge(cone); // Deste modo deve mudar por ter mudado o estado da entity. em uma detached ele n�o opera a mudan�a
		// em.persist(cone); -> N�o funciona indicando que a entity esta com detached, um cara com id que n�o � gerido pelo banco. 
		em.getTransaction().commit();
		em.close();
	}
}
