package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome;
	
	// necessario para o hibernates. para indicar que não devemos usar depressiamos este método
	@Deprecated
	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	
}
