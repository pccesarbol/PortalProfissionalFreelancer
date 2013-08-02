/**
 * 
 */
package fontes.dao;


/**
 * @author 38014335104
 * Esta classe é responsável por gerenciar as constantes SQL que correspondem a tabela tabregistrarse
 */
public class ConstantesRegistrarClienteDAO {
	
	/**
	 * Definindo as constantes da classe
	 * **/	
	private static StringBuilder INCLUIR_NOVO_CLIENTE_REGISTRA_SE = new StringBuilder("INSERT INTO tabregistrase(nome_completo, email, telefone, celular, senha) VALUES (?, ?, ?, ?, ?)"); 
	private static StringBuilder AUTENTICAR_CLIENTE_NO_SISTEMA = new StringBuilder("SELECT count(nu_seq_registrase) as total FROM tabregistrase WHERE email = ? AND senha = ?");

	/**
	 * Construtor da classe
	 */
	public ConstantesRegistrarClienteDAO() {
		// TODO Auto-generated constructor stub
	}

	//-- Métodos acessores --//
	public static StringBuilder getINCLUIR_NOVO_CLIENTE_REGISTRA_SE() {
		return INCLUIR_NOVO_CLIENTE_REGISTRA_SE;
	}

	public static StringBuilder getAUTENTICAR_CLIENTE_NO_SISTEMA() {
		return AUTENTICAR_CLIENTE_NO_SISTEMA;
	}
	
	

}
