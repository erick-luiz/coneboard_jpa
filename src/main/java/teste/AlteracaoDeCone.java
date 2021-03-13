package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cone;

public class AlteracaoDeCone {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		// note que desta forma a alteracao nao � persistida no banco
		Cone cone = em.find(Cone.class, 1L);
		cone.setNome("Erick Kinho 2");

		em.getTransaction().begin();
		cone.setApelido("novo apelido"); // o fato de ter mudado o entity qui persiste as duas modifica��es. note que
											// por estar em uma transaction n�o precisamos avisar a mudan�a ou algo
											// assim, a propria JPA ja gerencia isso
		em.getTransaction().commit();

	}
}
