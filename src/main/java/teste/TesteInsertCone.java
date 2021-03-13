package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cone;

public class TesteInsertCone {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		Cone cone = new Cone();
		cone.setNome("erick kinho");
		cone.setApelido("conerick");

		em.persist(cone); // este � o comando para persistir, mas note que s� isso n�o vai de fato
							// persistir. Toda op de modifica��o de estado em JPA TEM que estar dentro de
							// uma transa��o, � s� chamando o m�todo n�o estamos fazendo isso
		
		// pondo dentro de uma transa��o
		em.getTransaction().begin(); // inicia a transaction 
		em.persist(cone);
		em.getTransaction().commit(); // commita a transacao
	}
}
