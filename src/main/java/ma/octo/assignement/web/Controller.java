package ma.octo.assignement.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.exceptions.TransactionException;



public interface Controller<Type,DTO> {
	public List<Type> loadAll() ;
	default public void store(@RequestBody DTO dto)throws SoldeDisponibleInsuffisantException, CompteNonExistantException, TransactionException , Exception {};
	
}
