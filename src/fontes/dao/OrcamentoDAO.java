/**
 * Gerenciar os métodos de persistencia
 */
package fontes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fontes.entity.Orcamento;

/**
 * @author 38014335104
 * Gerenciando os orçamentos - persistencia
 */
public class OrcamentoDAO {
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;
	

	/**
	 * Construtor padão da classe
	 */
	public OrcamentoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Incluir solicitação de orçamento
	 * @author 38014335104
	 * @see Data: 31/07/2013 as 17hs31min
	 * **/
	public boolean gravarSolicitacaoOrcamento(final Orcamento orca)throws SQLException{
		boolean gravou = false;
		conn = null;
		 stm = null;
		  rs = null;
		try{
			conn = Conexao.getConexao();
			 stm = conn.prepareStatement(ConstantesOrcamentosDAO.getSqlGravarNovoOrcamento().toString());
			 stm.setString(1, orca.getNome());
			 stm.setString(2, orca.getEmail());
			 stm.setString(3, orca.getTelefone());
			 stm.setString(4, orca.getDescreverProblemas());
			 stm.setString(5, orca.getAtendido());
			 stm.setString(6, orca.getDataAbertura());
			 
			 if(stm.executeUpdate() >= 1){
				 gravou = true;
			 }
			 
		}catch(Exception e){			
			throw new SQLException(e.getLocalizedMessage(), e);
			
		}finally{
			Conexao.fecharConexao(stm, rs, conn);
		}
		return gravou;
	}

}
