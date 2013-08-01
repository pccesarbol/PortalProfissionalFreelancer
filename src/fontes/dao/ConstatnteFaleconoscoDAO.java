/**
 * Gerenciamento as constantes da classe 
 */
package fontes.dao;

/**
 * @author 38014335104
 * Gerenciar as constantes da clasee de persistencia
 */
public class ConstatnteFaleconoscoDAO {

	private final static StringBuilder SQL_INCLUIR_FALE_CONOSCO = new StringBuilder("INSERT INTO tabfaleconosco(nome, telefone, email, assunto, respondido)VALUES(?, ?, ?, ?, ?)");

	public static StringBuilder getSqlIncluirFaleConosco() {
		return SQL_INCLUIR_FALE_CONOSCO;
	}

}
