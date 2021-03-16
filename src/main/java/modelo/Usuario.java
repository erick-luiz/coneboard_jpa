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

	@JoinColumn(unique = true) // A relação 1 para 1, não cria diretamente a cronstraint de chave estrangeira,
								// logo sem essa anotação será porssivel ter dois usuários com o mesmo coneInfo.
								// O importante dessa anotação é que ela é performada na criação da tabela,
								// assim sendo após criar isso não será mais performado pela JPA.
	@OneToOne // Mapeamento de relações um para um. no banco da dados esta relação deve criar
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
