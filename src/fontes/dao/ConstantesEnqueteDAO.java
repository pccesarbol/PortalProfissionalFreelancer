/**
 * Gerenciando a camada de persistencia das enquetes
 */
package fontes.dao;

/**
 * @author 38014335104
 * Gerenciar a persistencia das enquetes
 */
public class ConstantesEnqueteDAO {
	private static StringBuilder SQL_INCLUIR_PESQUISA_DE_SATISFACAO = new StringBuilder("INSERT INTO tabenquete(descricao) VALUES (?)");

	public static StringBuilder getSQL_INCLUIR_PESQUISA_DE_SATISFACAO() {
		return SQL_INCLUIR_PESQUISA_DE_SATISFACAO;
	}

}
