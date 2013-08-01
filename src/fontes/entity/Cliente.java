/**
 * Classe responsável pelo gerenciamento dos dados dos novos clientes
 */
package fontes.entity;

/**
 * @author 38014335104
 * Data: 31/07/2013 as 15hs01min
 */
public class Cliente {

	/**
	 * Definindo os atributos da classe
	 * **/
	private Long id;
	private String nomeCompleto;
	private String email;
	private String telefone;
	private String celular;
	private String skype;
	private String senha;
	
	/**
	 * Construntor padrão da classe
	 */
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Métodos acessores da classe
	 * **/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
