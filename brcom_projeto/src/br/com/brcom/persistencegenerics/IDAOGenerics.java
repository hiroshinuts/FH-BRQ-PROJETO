package br.com.brcom.persistencegenerics;

import java.util.List;

public interface IDAOGenerics<T, K> {
	
	void insert(T obj) throws Exception;
	
	void update(T obj) throws Exception;
	
	void delete(T obj) throws Exception;
	
	List<T> findAll() throws Exception;
	
	T findById(K id) throws Exception;
	
}
