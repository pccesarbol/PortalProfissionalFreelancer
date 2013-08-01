/**
 * Esta classe é responspável pela conexão com o banco de dados profissionalFreelancerDB no PostGreSQL
 * @author 38014335104
 * Data: 31/07/2013 as 14hs47min
 */
package fontes.dao;


/**
 * Definindo os imports
 * **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 38014335104
 * Tratando a conexão com o banco de dados postgresql
 */
public class Conexao {
	/**
	 * Definindo os atributos de persistencia da classe
	 * @author 38014335104
	 * 
	 * **/
	private static String driver   = "org.postgresql.Driver";
    private static String user     = "postgres";
    private static String senha    = "pcna1966";
    private static String url      = "jdbc:postgresql://localhost:5432/profissionalFreelancerDB";
    private static Connection con  = null;


	/**
	 * Construtor padrão da classe
	 */
	public Conexao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Obter a conexão com o banco de dados profissionalFreelancerDB
	 * @author 38014335104
	 * Data: 31/07/2013 as 14hs51min
	 * **/
	public static Connection getConexao(){
		try
        {
            Class.forName(driver);
            
            con = null;

            con = (Connection) DriverManager.getConnection(url, user, senha);

            System.out.println("Conexão realizada com sucesso.");

        }
        catch (ClassNotFoundException ex)
        {
            System.err.print(ex.getMessage());
        } 
        catch (SQLException e)
        {
            System.err.print(e.getMessage());
        }
		return con;
	}
	
	/**
	 * Fechando a conexão com o banco de dados
	 * @author 38014335104
	 * Data: 31/07/2013 as 14hs53min
	 * **/
	public static void fecharConexao(PreparedStatement stm, ResultSet rs, Connection conn){
		if(stm != null){
			try{
				stm.close();
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
			}
		}
		
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
			}
		}
		
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
			}
		}
		
	}

}
