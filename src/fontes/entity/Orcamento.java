/**
 * Gerencia os atributos dos orçamentos solicitados
 */
package fontes.entity;

/**
 * @author 38014335104
 * Gerenciando os atributos dos orçamentos 
 */
public class Orcamento {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String descreverProblemas;
	private String atendido;
	private String dataAbertura;
	private String dataFechamento;
	
	/**
	 * Construtor padrão da classe
	 */
	public Orcamento() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Definindo os métodos acessores
	 * **/
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

	public String getDescreverProblemas() {
		return descreverProblemas;
	}

	public void setDescreverProblemas(String descreverProblemas) {
		this.descreverProblemas = descreverProblemas;
	}

	public String getAtendido() {
		return atendido;
	}

	public void setAtendido(String atendido) {
		this.atendido = atendido;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

}
