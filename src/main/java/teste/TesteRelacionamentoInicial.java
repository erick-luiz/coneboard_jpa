package teste;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cone;
import modelo.Conisse;
import modelo.TipoDeConisse;

public class TesteRelacionamentoInicial {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cones");
		EntityManager em = emf.createEntityManager();

		Cone cone = new Cone();
		cone.setApelido("Afoncone");
		cone.setNome("Afonso");

		Conisse conisse = new Conisse();
		conisse.setTipo(TipoDeConisse.ESTRELADO);
		conisse.setDescricao(
				"Estava testando a release sem verificar se tinham modificações locais, quebrei os testes!");
		conisse.setData(LocalDateTime.now());
		conisse.setCone(cone);

		em.getTransaction().begin();
		em.persist(cone); // sem essa linha teremos um erro por tentar comitar a relação e dentro do obj
							// sendo comitado temos um trasient, ainda não persistido, ou seja sem chave
							// estrangeira para configurar a relação
		em.persist(conisse);
		em.getTransaction().commit();
		
		/* Após criar a tabela a JPA cria a chave estrangeira para o Cone
		   alter table Conisse 
	       add constraint FKt2j0k9ulvv59nn171ia1519hi 
	       foreign key (cone_id) 
	       references Cone (id)
		 * */

	}
}
