package ma.octo.assignement.service;

import java.util.List;

public interface CrudOperations<Type,IDType>{
	public void add(Type e) throws Exception;
	public Type getById(IDType id) throws Exception;
	public List<Type> getAll() throws Exception;
	public void update(Type e) throws Exception; 
	public void delete(IDType id) throws Exception;
	
}
