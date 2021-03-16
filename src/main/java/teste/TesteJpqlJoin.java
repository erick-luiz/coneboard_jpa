package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Categoria;
import modelo.Cone;
import modelo.Conisse;

public class TesteJpqlJoin {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		// Por ter uma relação de muitos para muitos, pegar a Conisse baseado na categoria vai nos exigir fazer um join (juntar as coisas)
		String jpql = "select c from Conisse c join c.categorias cat where cat = :pCategoria";
	
		Categoria cat = new Categoria();
		cat.setId(2L);

		TypedQuery<Conisse> jpqlQuery = em.createQuery(jpql, Conisse.class);
		jpqlQuery.setParameter("pCategoria", cat);

		List<Conisse> resultList2 = jpqlQuery.getResultList();
		for (Conisse c : resultList2) {
			System.out.println(c);
		}
		
	}
}
