package fontes.dao;

/**
 * Gerenciando as querys de persistencia dos orçamentos.
 * **/
public class ConstantesOrcamentosDAO {
	/**
	 * Definindo as constantes
	 * **/
	private final static StringBuilder SQL_GRAVAR_NOVO_ORCAMENTO = new StringBuilder("INSERT INTO taborcamento(nome, email, telefone, descrever_problema, atendido, dt_abertura)VALUES(?, ?, ?, ?, ?, ?)");
	
	/**
	 * Metodos acessores
	 * **/
	public static StringBuilder getSqlGravarNovoOrcamento() {
		return SQL_GRAVAR_NOVO_ORCAMENTO;
	}
	
	
}
