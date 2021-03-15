package teste;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Categoria;
import modelo.Cone;
import modelo.Conisse;
import modelo.TipoDeConisse;

public class TestaManyToMany {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();
		
		Categoria cat = new Categoria("Código");
		Categoria cat2 = new Categoria("ponto");

		Cone cone = new Cone();
		cone.setApelido("Jocone");
		cone.setNome("Joaquim");

		Conisse conisse = new Conisse();
		conisse.setTipo(TipoDeConisse.NORMAL);
		conisse.setDescricao(
				"Codei errado e me passei no horario de almoço");
		conisse.setData(LocalDateTime.now());
		conisse.setCone(cone);
		conisse.setCategorias(Arrays.asList(cat, cat2));
		
		
		Conisse conisse2 = new Conisse();
		conisse2.setTipo(TipoDeConisse.NORMAL);
		conisse2.setDescricao(
				"Codei errado");
		conisse2.setData(LocalDateTime.now());
		conisse2.setCone(cone);
		conisse2.setCategorias(Arrays.asList(cat));
		
		
		em.getTransaction().begin();
		em.persist(cone);
		em.persist(cat); // Note que não fazer isso traria um erro de transient tentando ser persistido
		em.persist(cat2);
		em.persist(conisse);
		em.persist(conisse2);
		em.getTransaction().commit();
		em.close();
	}
}
