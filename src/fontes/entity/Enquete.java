/**
 * Classe responsável por gerenciar a pesquisa de satisfação dos atendimentos do profissional freelancer Paulo Augusto
 */
package fontes.entity;

/**
 * @author 38014335104
 * gerenciar a pesquisa de satisfação.
 */
public class Enquete {
    private Long id;
    private String descricao;
    
	/**
	 * construtor padrão da classe
	 */
	public Enquete() {
		// TODO Auto-generated constructor stub
	}
	
	//-- Definindo os métodos acessores --//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
