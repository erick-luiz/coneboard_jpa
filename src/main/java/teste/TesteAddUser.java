package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cone;
import modelo.Usuario;

public class TesteAddUser {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		Cone cone = new Cone();
		cone.setApelido("Jocone");
		cone.setNome("Joaquim");

		Usuario usuario = new Usuario();
		usuario.setConeInfo(cone);
		usuario.setUser("email@email.com");
		usuario.setPass("12345");
		
		// No usuário teremos uma chave estrangeira para o Cone ja criado.
		em.getTransaction().begin();
		em.persist(cone);
		em.persist(usuario);
		em.getTransaction().commit();

		// Este trecho abaixo deve lançar um erro pois desrespeita a chave estrangeira
		// criada na relação OneToOne com a adição da anotação JoinColumn(unique = true
		Usuario usuario2 = new Usuario();
		usuario2.setConeInfo(cone);
		usuario2.setUser("email@email.com");
		usuario2.setPass("54321");

		em.getTransaction().begin();
		em.persist(usuario2);
		em.getTransaction().commit();
	}
}
