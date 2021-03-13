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
		cone.setApelido("novo apelido5"); // o fato de ter mudado o entity qui persiste as duas modifica��es. note que
											// por estar em uma transaction n�o precisamos avisar a mudan�a ou algo
											// assim, a propria JPA ja gerencia isso
		// a entidade em estado managed � sincronizada automaticamente com o banco
		//  note que a JPA valida se ocorreu altera��o
		em.getTransaction().commit();
		
		// neste cen�rio, este update n�o vai executar por que a string � igual a que acabamos de por no banco
		//    se o que voltar do banco ja for o que estamos tentando por o comando de update n�o ser� executado.
		em.getTransaction().begin();
		cone.setApelido("novo apelido5");
		em.getTransaction().commit();

	}
}
