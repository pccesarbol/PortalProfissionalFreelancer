/**
 * 
 */
package fontes.facade;

import java.sql.Date;

import fontes.dao.EnqueteDAO;
import fontes.dao.FaleconoscoDAO;
import fontes.dao.OrcamentoDAO;
import fontes.dao.RegistraSeDAO;
import fontes.entity.Cliente;
import fontes.entity.Enquete;
import fontes.entity.FaleConosco;
import fontes.entity.Orcamento;
import java.text.SimpleDateFormat;

/**
 * @author 38014335104
 * Esta classe � respons�vel pelos servi�os de registros dos novos clientes
 */
public class RegistrarClienteFacade{
	/**
	 * Definindo os atributos da classe
	 * **/
	private String msg = "";
	
	/**
	 * Construtor padr�o da classe
	 */
	public RegistrarClienteFacade() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Realizar comunica��o com o flex build
	 * @author 38014335104
	 * @see Data: 29/07/2013 as 13hs15min.
	 * **/
	public String getMensagem(){
		return "Aten��o! Esta mensagem foi enviada pela classe de facade (RegistrarClienteFacade).";
	}
	
	/**
	 * Autenticar usu�rio no sistema �rea do cliente
	 * @author 38014335104
	 * @see Data: 30/07/2013 as 13hs04
	 * **/
	public String autenticarUsuario(String email, String senha){//alterar o retorno para objeto usu�rio, antes criar o objeto usu�rio no flex *.as
		//-- passar os dados recebidos para o banco de dados e realizar a autentica��o do usu�rio no sistema --//
		
		//-- abrir a tela principal do sistema --//
		
		return "Aten��o! Os dados informados do cliente s�o:\nE-mail: ("+email+").\nSenha: ("+senha+").";
	}
	
	/**
	 * Autenticar usu�rio no sistema �rea ADM.
	 * @author 38014335104
	 * @see Data: 30/07/2013 as 13hs04
	 * **/
	public String autenticarUsuarioADM(String email, String senha){//alterar o retorno para objeto usu�rio, antes criar o objeto usu�rio no flex *.as
		//-- passar os dados recebidos para o banco de dados e realizar a autentica��o do usu�rio no sistema --//
		
		//-- abrir a tela principal do sistema --//
		
		return "Aten��o! Os dados informados da �rea ADM s�o:\nE-mail: ("+email+").\nSenha: ("+senha+").";
	}
	
	/**
	 * Fale conosco - guarda os dados na base de dados
	 * @author 38014335104
	 * @see Data: 31/07/2013 as 10hs10min
	 * **/
	public String enviarFaleConosco(String nome, String telefone, String email, String assunto){
		this.msg = null;
		try{
			FaleConosco f = new FaleConosco();
			f.setAssunto(assunto);
			f.setEmail(email);
			f.setNome(nome);
			f.setTelefone(telefone);
			f.setRespondido("N");
			
			FaleconoscoDAO dao = new FaleconoscoDAO();
			
			if(dao.salvarFaleConosco(f)){
				this.msg = "Aten��o! ("+nome+")\nA sua mensagem foi registrada na nossa base de dados.\nAguarde nosso retorno, obrigado.";
			}
			
		}catch(Exception e){
			this.msg = "Aten��o! N�o foi poss�vel salvar sua mensagem.\nErro: "+e.getMessage();
		}
		
		return this.msg;
	}
	
	/**
	 * Registrar no cliente no sistema
	 * @author 38014335104
	 * @see Data: 31/07/2013 as 11hs21min
	 * **/
	public String registrarNovoCliente(String nomeCompleto, String celular, String confirmarSenha, String email, String senha, String skype, String telefone){
		this.msg = null;
		
		try{
			if(senha != confirmarSenha){
				this.msg = "Aten��o! O valor informado no campo confirmar senha\nesta diferente do valor informado no campo senha.\nCorrija.";
				
			}else{
				RegistraSeDAO dao = new RegistraSeDAO();
				
				Cliente c = new Cliente();
				c.setCelular(celular);
				c.setEmail(email);
				c.setNomeCompleto(nomeCompleto);
				c.setSenha(senha);
				c.setSkype(skype);
				c.setTelefone(telefone);
				
				if(dao.cadastrarNovoCliente(c)){
					//-- Enviar e-mail para o cliente com o end. da minha p�gina e dados de cadastro para confirma��o --//
					
					
					//-- enviar msg de sucesso para o usu�rio --//
					this.msg = "Aten��o! ("+nomeCompleto+"), o seu cadastro foi realizado com sucesso.\nPara entrar na �rea do cliente,\n infrome seu email e sua senha.";
				}
			}
			
		}catch(Exception e){	
			this.msg = "Aten��o! N�o foi poss�vel cadastrar, ERRO:\n"+e.getMessage();
			System.out.println(e.getLocalizedMessage());
		}
		
		return this.msg;		
		
	}
	
	/**
	 * Salvar resultado da pesquisa de satisfa��o Enquete
	 * @author 38014335104
	 * @see Data: 31/07/2013 as 13hs22min
	 * **/
	public String salvarResultadoEnquete(String enquete){
		this.msg = null;
		try{
			Enquete      e = new Enquete();
			e.setDescricao(enquete);
			
			EnqueteDAO dao = new EnqueteDAO();
			
			if(dao.salvarPesquisaDeSatisfacao(e)){
			  this.msg = "Aten��o! Obrigado por responder a este questionamento.\nA sua opni�o � muito importante para n�s.";	
			}
			
		}catch(Exception e){
			this.msg = "Aten��o! N�o foi poss�vel cadastrar a sua resposta, erro:\n"+e.getMessage();
			System.out.println(e.getMessage());
		}
		return this.msg;
	}
	
	/**
	 * Salvar nova solicita��o de or�amento de cria��o e ou manuten��o de software
	 * @author 38014335104
	 * @see Data: 31/07/2013 as 13hs56min
	 * **/
	public String salvarSolicitacaoOrcamento(String nome, String email, String telefone, String descricaoProblema){
		this.msg = null;
		try{
			Orcamento o = new Orcamento();
			o.setAtendido("N");
			Date data = new Date(System.currentTimeMillis());
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			o.setDataAbertura(dt.format(data));
			o.setDescreverProblemas(descricaoProblema);
			o.setEmail(email);
			o.setNome(nome);
			o.setTelefone(telefone);
			
			OrcamentoDAO dao = new OrcamentoDAO();
			
			if(dao.gravarSolicitacaoOrcamento(o)){
				this.msg = "Aten��o! ("+nome+"),\nA sua solicita��o de or�amento foi registrada.\nPor favor aguarde nosso retorno, obrigado.";
			}
			
		}catch(Exception e){
			this.msg = "Aten��o! ("+nome+").\nN�o foi poss�vel gravar sua solicita��o, erro:\n"+e.getMessage();
		}
		
		return this.msg;
	}

}
