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

		em.persist(cone); // este é o comando para persistir, mas note que só isso não vai de fato
							// persistir. Toda op de modificação de estado em JPA TEM que estar dentro de
							// uma transação, é só chamando o método não estamos fazendo isso
		
		// pondo dentro de uma transação
		em.getTransaction().begin(); // inicia a transaction 
		em.persist(cone);
		em.getTransaction().commit(); // commita a transacao
	}
}
