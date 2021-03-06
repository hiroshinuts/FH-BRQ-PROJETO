package br.com.brq.financialhealth.persistence;


import br.com.brq.financialhealth.entities.Usuario;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

/**
 * Classe DAO - DAOUsuario.class
 * 
 * Classe que � responsavel na comunica��o com o Banco de dados com informacoes do usuario
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */
public class DAOUsuario extends DAOGeneric<Usuario, Integer> {
	
	/**
	 * Construtor da Classe, que utiliza os metodos da superclasse (DAOGeneric)
	 */
	public DAOUsuario() {
		super(Usuario.class);
	}
	
	/**
	 * Metodo que busca o login e a senha do Usuario no banco de dados
	 * 
	 * @param cpf - parametro de login
	 * @param senha - senha criptografada
	 * @return - retorna o usuario
	 * @throws Exception
	 */
	public Usuario findByLoginSenha(String cpf, String senha) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Usuario.FIND_LOGIN);
		query.setString("p1", cpf);
		query.setString("p2", senha);
		
		Usuario u = (Usuario) query.uniqueResult();
		System.out.println(cpf+" "+senha);
		session.close();
		return u;
	
	}
	
	/**
	 * Sobre Escrita de metodo delete da Superclasse DAOGeneric
	 * 
	 */
	@Override
	public void delete(Usuario u) throws Exception {
		super.delete(u);
	}
	
	/**
	 * Metodo para editar as informa��es do Usuario, passando um usuario e identificando com um ID
	 * 
	 */
	public void saveOrUpdate(Usuario obj, Integer id) throws Exception {
		// TODO Auto-generated method stub
		super.saveOrUpdate(obj);
	}

}
