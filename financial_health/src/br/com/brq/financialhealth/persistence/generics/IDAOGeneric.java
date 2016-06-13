package br.com.brq.financialhealth.persistence.generics;

import java.io.Serializable;
import java.util.List;

/**
 * Interface para DAO Generico 
 * 
 * Interface que passa chamadas de metodo para o DAOGeneric
 * 
 * @author Hiro
 * @version 1.0
 * @since Treinamento/BRQ
 *
 * @param <T> - parametro generico
 * @param <K> - parametro generico
 */
public interface IDAOGeneric<T, K extends Serializable> {
	
	/**
	 * Chamada de metodo para o DAOGeneric - salva ou da update
	 * 
	 * @param obj
	 * @throws Exception
	 */
	void saveOrUpdate(T obj) throws Exception;
	
	
	/**
	 * Chamada de metodo para o DAOGeneric - delete
	 * 
	 * @param obj
	 * @throws Exception
	 */
	void delete(T obj) throws Exception;
	
	/**
	 * Chamada de metodo para o DAOGeneric - findall
	 * 
	 * @return
	 * @throws Exception
	 */
	List<T> findAll() throws Exception;
	
	/**
	 *Chamada de metodo para o DAOGeneric - findById
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	T findById(K id) throws Exception;
}
