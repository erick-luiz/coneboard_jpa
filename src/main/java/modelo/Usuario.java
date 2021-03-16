package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String user;
	private String pass;

	@JoinColumn(unique = true) // A rela��o 1 para 1, n�o cria diretamente a cronstraint de chave estrangeira,
								// logo sem essa anota��o ser� porssivel ter dois usu�rios com o mesmo coneInfo.
								// O importante dessa anota��o � que ela � performada na cria��o da tabela,
								// assim sendo ap�s criar isso n�o ser� mais performado pela JPA.
	@OneToOne // Mapeamento de rela��es um para um. no banco da dados esta rela��o deve criar
				// uma chave estrangeira, bem como todo mapeamento @*ToOne.
	private Cone coneInfo;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Cone getConeInfo() {
		return coneInfo;
	}

	public void setConeInfo(Cone coneInfo) {
		this.coneInfo = coneInfo;
	}
}
