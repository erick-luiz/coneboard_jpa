package modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conisse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private LocalDateTime data;
	private String descricao;

	// os tipos padrões a JPA manda ver, neste caso é um ENUM então informamos que
	//    é um enumeravel nosso e o que a JPA deve persistir no Banco: a string
	//    referente ao ENUM ou o int relacionado a ordem dele;
	@Enumerated(EnumType.STRING)
	private TipoDeConisse tipo;

	// demonstrado na aula, vai criar uma relação com uma chave estrangeira para a
	// conta. Note que por conta disto a conta deve estar persistida e no estado
	// managed na hora da persistencia da conisse.
	@ManyToOne
	private Cone cone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoDeConisse getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeConisse tipo) {
		this.tipo = tipo;
	}

	public Cone getCone() {
		return cone;
	}

	public void setCone(Cone cone) {
		this.cone = cone;
	}
}
