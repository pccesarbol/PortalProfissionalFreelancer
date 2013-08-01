/**
 * Gerenciar os atributos do módulo de fale conosco
 */
package fontes.entity;

/**
 * @author 38014335104
 * Atributos da classe
 */
public class FaleConosco {
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String assunto;
	private String respondido;
	
	/**
	 * Construtor da classe
	 */
	public FaleConosco() {
		// TODO Auto-generated constructor stub
	}

	//-- Métodos acessores --//
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getRespondido() {
		return respondido;
	}

	public void setRespondido(String respondido) {
		this.respondido = respondido;
	}
	
	
}
