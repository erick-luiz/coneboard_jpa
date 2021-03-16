package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Anotação utilizada pela JPA para definir que o objeto é uma tabela do banco 
//    temos essa anotação tanto pelo pacote javax.persistence quanto hibernate
//    devemos utilizar a persistence para uma possivel mudança de implementação
@Entity
public class Cone {

	@Id // identifica o atributo como identificador da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // definindo que queremos usar chaves sequenciais no banco
														// usando o auto-increment
	private Long id;
	private String nome;
	private String apelido;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
}
