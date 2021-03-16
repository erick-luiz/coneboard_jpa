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
		cone = em.merge(cone); // Deste modo deve mudar por ter mudado o estado da entity. em uma detached ele não opera a mudança
		// em.persist(cone); -> Não funciona indicando que a entity esta com detached, um cara com id que não é gerido pelo banco. 
		em.getTransaction().commit();
		em.close();
	}
}
