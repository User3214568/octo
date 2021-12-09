package ma.octo.assignement.service;

import org.springframework.beans.factory.annotation.Autowired;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.domain.Virement;

public abstract class AbstractArgentTransfertService<Operation , Source,Destination> implements ArgentTransfert<Source,Destination> , CrudOperations<Operation,Long>  {
	@Autowired
	protected AutiService auti;

	public void auti(Operation operation) {
		if(operation instanceof Versement) {
			auti.auditVersement(operation.toString());
		}
		if(operation instanceof Virement) {
			auti.auditVirement(operation.toString());	
		}
		
	}
	
	
}
