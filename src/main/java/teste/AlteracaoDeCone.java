package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cone;

public class AlteracaoDeCone {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		// note que desta forma a alteracao nao é persistida no banco
		Cone cone = em.find(Cone.class, 1L);
		cone.setNome("Erick Kinho 2");

		em.getTransaction().begin();
		cone.setApelido("novo apelido5"); // o fato de ter mudado o entity qui persiste as duas modificações. note que
											// por estar em uma transaction não precisamos avisar a mudança ou algo
											// assim, a propria JPA ja gerencia isso
		// a entidade em estado managed é sincronizada automaticamente com o banco
		//  note que a JPA valida se ocorreu alteração
		em.getTransaction().commit();
		
		// neste cenário, este update não vai executar por que a string é igual a que acabamos de por no banco
		//    se o que voltar do banco ja for o que estamos tentando por o comando de update não será executado.
		em.getTransaction().begin();
		cone.setApelido("novo apelido5");
		em.getTransaction().commit();

	}
}
