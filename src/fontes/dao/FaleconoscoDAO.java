/**
 * Gerenciamento os metodos de persistencia do módulo faleconosco
 */
package fontes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fontes.entity.FaleConosco;

/**
 * @author 38014335104
 * Gerencia a persistencia 
 */
public class FaleconoscoDAO {
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;

	/**
	 * Construtor da classe
	 */
	public FaleconoscoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**Gravar novo faleconosco na base de dados
	 * @author 38014335104
	 * @see Data: 31/07/2013 as 16hs16min
	 * 
	 * **/
	public boolean salvarFaleConosco(final FaleConosco fala)throws SQLException{
		conn = null;
		 stm = null;
		  rs = null;
		  
	   boolean salvou = false;		  
		  
       try{
    	   conn = Conexao.getConexao();
    	    stm = conn.prepareStatement(ConstatnteFaleconoscoDAO.getSqlIncluirFaleConosco().toString());
    	    stm.setString(1, fala.getNome());
    	    stm.setString(2, fala.getTelefone());
    	    stm.setString(3, fala.getEmail());
    	    stm.setString(4, fala.getAssunto());
    	    stm.setString(5, fala.getRespondido());
    	    
    	    if(stm.executeUpdate() >= 1){
    	    	salvou = true;
    	    }
    	    
       }catch(Exception e){    	   
    	   
    	   System.out.println(e.getLocalizedMessage());
    	   
    	   throw new SQLException(e.getMessage(), e);
    	   
       }finally{
    	   Conexao.fecharConexao(stm, rs, conn);
       } 	
       
       return salvou;
	}

}
