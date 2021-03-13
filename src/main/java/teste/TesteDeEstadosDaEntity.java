package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cone;

public class TesteDeEstadosDaEntity {
	public static void main(String[] args) {

		Cone cone = new Cone();
		cone.setApelido("cone estado");
		cone.setNome("estado");
		// neste momento este entity esta no estado transient, ele ainda não foi
		// persistido mas é um potencial objeto que pode ser persistido

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		// fazendo isso vamos inserir o objeto no banco e ele vai se manter no contexto
		// logo vai estar no estado Managed
		em.getTransaction().begin();
		em.persist(cone);
		em.getTransaction().commit();

		em.close(); // nesse momento o cone estara como depached, não tem mais um entity manager
					// gerindo ele

		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		cone = em2.merge(cone); // commitando algo caso tenha e voltando de despached para managed
								// Ao contrario do que o curso trouxe o merge não torna o despached managed, ele
								// apenas busca o managed no contexto e retorna ele caso você queira utilizado.
								// sem receber devolta teremos um erro por tentar remover uma entity em estado
								// despached
		cone.setApelido("mudança de estado");
		em2.getTransaction().commit();

		em2.getTransaction().begin();
		em2.remove(cone);
		em2.getTransaction().commit();

	}
}
