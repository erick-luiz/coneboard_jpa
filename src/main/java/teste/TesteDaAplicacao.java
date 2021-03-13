package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteDaAplicacao {
	
	public static void main(String[] args) {
		
		// Primeiro passo para utilizar o JPA, temos que criar a fabrica de EntityManagers
		//   Para isso usamos a classe Persistence que nada mais � do que a representa��o do arquivo de config persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		
		// com a fabrica podemos criar nossa entityManager
		//   Com isso garantimos a cria��o das entitys no banco 
		EntityManager em = emf.createEntityManager();
		
		// Fechando a conex�o
		em.close();
	}
}
