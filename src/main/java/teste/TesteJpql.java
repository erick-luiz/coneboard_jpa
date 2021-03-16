package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import modelo.Cone;
import modelo.Conisse;

public class TesteJpql {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		// este é um modelo ainda preso no modelo relcional onde estamos utilizando a
		// linguagem SQL usada em bancos para as consultas do mundo relacional.
		String sql = "select * from conisse where cone_id = 8";

		// sem passar o tipo da erro de conversão
		Query sqlQuery = em.createNativeQuery(sql, Conisse.class);
		List<Conisse> resultList = sqlQuery.getResultList();
		for (Conisse c : resultList) {
			System.out.println(c);
		}

		// a mesma query utilizando JPQL não deveria conhecer a table conisse, ou usar a
		// sintaxe *, menos ainda usar o nome de uma coluna cone_id, no mundo orientado
		// a objetos nossa pergunta seria: quais as conisses do érick, e não do id 8,
		// logo:
		String jpql = "select c from Conisse c where c.cone = :pCone";

		Cone cone = new Cone();
		cone.setId(8L);

		TypedQuery<Conisse> jpqlQuery = em.createQuery(jpql, Conisse.class);
		jpqlQuery.setParameter("pCone", cone);

		List<Conisse> resultList2 = jpqlQuery.getResultList();
		for (Conisse c : resultList2) {
			System.out.println(c);
		}
		// note que na primeira consulta eu tenho ideia de como o banco esta
		// estruturado, inclusive uso o nome da tabela e da coluna. Na segunda
		// oportunidade eu não olhei pro banco, apenas para os objetos. Isto me torna
		// mais mutavel e mais flexivel com quem esta desenvolvendo
		
	}
}
