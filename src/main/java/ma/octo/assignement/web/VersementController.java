package ma.octo.assignement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.ArgentTransfertDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.service.VersementService;

@RestController(value = "/versements")
public class VersementController implements Controller<Versement,ArgentTransfertDto>{
	@Autowired
	private VersementService versementService;

	
    @GetMapping("lister_versements")
	@Override
	public List<Versement> loadAll() {
		try {
			return versementService.getAll();			
		}catch(Exception e) {
			return null;
		}
	}
    @PostMapping("/executerVersements")
    @ResponseStatus(HttpStatus.CREATED)
	@Override
	public void store(ArgentTransfertDto dto) throws SoldeDisponibleInsuffisantException, CompteNonExistantException, TransactionException , Exception {
        
        versementService.transferer( dto);
		
    }

	

	
}