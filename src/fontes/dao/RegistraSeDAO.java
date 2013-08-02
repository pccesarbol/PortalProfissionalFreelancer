/**
 * Esta classe é responsável pela persistencia dos novos clientes no sistema
 * @author 38014335104
 * Data: 31/07/2013 as 14hs49min
 */
package fontes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fontes.entity.Cliente;

/**
 * @author 38014335104
 * Gerenciamento da persistencia dos dados dos clientes
 */
public class RegistraSeDAO {
	/**
	 * Definindo os atributos de persistencia da classe
	 * **/
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;
	

	/**
	 * Construtor padrão da classe
	 */
	public RegistraSeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Incluir no cliente no sistema
	 * @author 38014335104
	 * 
	 * **/
	public boolean cadastrarNovoCliente(final Cliente cliente)throws SQLException{
	    conn = null;
	     stm = null;
	      rs = null;
	      boolean incluiu = false;
		try{
			conn = Conexao.getConexao();
			 stm = conn.prepareStatement(ConstantesRegistrarClienteDAO.getINCLUIR_NOVO_CLIENTE_REGISTRA_SE().toString());
			 stm.setString(1, cliente.getNomeCompleto());
			 stm.setString(2, cliente.getEmail());
			 stm.setString(3, cliente.getTelefone());
			 stm.setString(4, cliente.getCelular());
			 stm.setString(5, cliente.getSenha());
			 
			 if(stm.executeUpdate() >= 1){
				 incluiu = true;
			 }
			 
		}catch(Exception e){
			
			e.printStackTrace();
			
			throw new SQLException(e.getLocalizedMessage(), e);
			
		}finally{
			Conexao.fecharConexao(stm, rs, conn);
		}
		
		return incluiu;
	}
	
	/**
	 * Autenticar usuário no sistema
	 * @author 38014335104
	 * @see Data: 02/08/2013 as 13hs55min
	 * **/
	public boolean autenticarClienteNoSistema(final String email, final String senha)throws SQLException{
		conn = null;
		 stm = null;
		  rs = null;
		boolean validou = false;
		try{			
			conn = Conexao.getConexao();
			 stm = conn.prepareStatement(ConstantesRegistrarClienteDAO.getAUTENTICAR_CLIENTE_NO_SISTEMA().toString());
			 stm.setString(1, email);
			 stm.setString(2, senha);
			  rs = stm.executeQuery();
			  
			if (rs.next()){
				if(rs.getInt("total") >= 1)
					validou = true;
			}  
			
		}catch(Exception e){
			e.printStackTrace();
			
			throw new SQLException(e.getLocalizedMessage(), e);
			
		}finally{
			Conexao.fecharConexao(stm, rs, conn);
		}
		return validou;
	}

}
