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
 * Esta classe é responsável pelos serviços de registros dos novos clientes
 */
public class RegistrarClienteFacade{
	/**
	 * Definindo os atributos da classe
	 * **/
	private String msg = "";
	
	/**
	 * Construtor padrão da classe
	 */
	public RegistrarClienteFacade() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Realizar comunicação com o flex build
	 * @author 38014335104
	 * @see Data: 29/07/2013 as 13hs15min.
	 * **/
	public String getMensagem(){
		return "Atenção! Esta mensagem foi enviada pela classe de facade (RegistrarClienteFacade).";
	}
	
	/**
	 * Autenticar usuário no sistema área do cliente
	 * @author 38014335104
	 * @see Data: 30/07/2013 as 13hs04
	 * **/
	public String autenticarUsuario(String email, String senha){//alterar o retorno para objeto usuário, antes criar o objeto usuário no flex *.as
		//-- passar os dados recebidos para o banco de dados e realizar a autenticação do usuário no sistema --//
		
		//-- abrir a tela principal do sistema --//
		
		return "Atenção! Os dados informados do cliente são:\nE-mail: ("+email+").\nSenha: ("+senha+").";
	}
	
	/**
	 * Autenticar usuário no sistema área ADM.
	 * @author 38014335104
	 * @see Data: 30/07/2013 as 13hs04
	 * **/
	public String autenticarUsuarioADM(String email, String senha){//alterar o retorno para objeto usuário, antes criar o objeto usuário no flex *.as
		//-- passar os dados recebidos para o banco de dados e realizar a autenticação do usuário no sistema --//
		
		//-- abrir a tela principal do sistema --//
		
		return "Atenção! Os dados informados da área ADM são:\nE-mail: ("+email+").\nSenha: ("+senha+").";
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
				this.msg = "Atenção! ("+nome+")\nA sua mensagem foi registrada na nossa base de dados.\nAguarde nosso retorno, obrigado.";
			}
			
		}catch(Exception e){
			this.msg = "Atenção! Não foi possível salvar sua mensagem.\nErro: "+e.getMessage();
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
				this.msg = "Atenção! O valor informado no campo confirmar senha\nesta diferente do valor informado no campo senha.\nCorrija.";
				
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
					//-- Enviar e-mail para o cliente com o end. da minha página e dados de cadastro para confirmação --//
					
					
					//-- enviar msg de sucesso para o usuário --//
					this.msg = "Atenção! ("+nomeCompleto+"), o seu cadastro foi realizado com sucesso.\nPara entrar na área do cliente,\n infrome seu email e sua senha.";
				}
			}
			
		}catch(Exception e){	
			this.msg = "Atenção! Não foi possível cadastrar, ERRO:\n"+e.getMessage();
			System.out.println(e.getLocalizedMessage());
		}
		
		return this.msg;		
		
	}
	
	/**
	 * Salvar resultado da pesquisa de satisfação Enquete
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
			  this.msg = "Atenção! Obrigado por responder a este questionamento.\nA sua opnião é muito importante para nós.";	
			}
			
		}catch(Exception e){
			this.msg = "Atenção! Não foi possível cadastrar a sua resposta, erro:\n"+e.getMessage();
			System.out.println(e.getMessage());
		}
		return this.msg;
	}
	
	/**
	 * Salvar nova solicitação de orçamento de criação e ou manutenção de software
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
				this.msg = "Atenção! ("+nome+"),\nA sua solicitação de orçamento foi registrada.\nPor favor aguarde nosso retorno, obrigado.";
			}
			
		}catch(Exception e){
			this.msg = "Atenção! ("+nome+").\nNão foi possível gravar sua solicitação, erro:\n"+e.getMessage();
		}
		
		return this.msg;
	}

}
