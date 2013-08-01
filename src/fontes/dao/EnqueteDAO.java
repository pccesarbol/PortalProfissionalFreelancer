/**
 * 
 */
package fontes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fontes.entity.Enquete;

/**
 * @author 38014335104
 *
 */
public class EnqueteDAO {
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stm;

	/**
	 * Construtor padrão da classe 
	 */
	public EnqueteDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gravar resposta da pesquisa de satisfação
	 * @author 38014335104
	 * Data: 31/07/2013 as 15hs45min
	 * **/
	public boolean salvarPesquisaDeSatisfacao(final Enquete enquete)throws SQLException{
		conn = null;
		 stm = null;
		  rs = null;
		boolean salvou = false;
		try{
			conn = Conexao.getConexao();
			 stm = conn.prepareStatement(ConstantesEnqueteDAO.getSQL_INCLUIR_PESQUISA_DE_SATISFACAO().toString());
			 stm.setString(1, enquete.getDescricao());
			 
			 if(stm.executeUpdate() >= 1){
				 salvou = true;
			 }
			 
		}catch(Exception e){
			System.out.println(e.getMessage());
			
			throw new SQLException(e.getLocalizedMessage(), e);
			
		}finally{
			Conexao.fecharConexao(stm, rs, conn);
		}
		return salvou;
	}
}
