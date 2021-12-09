package ma.octo.assignement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.ArgentTransfertDto;

import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.exceptions.TransactionException;

import ma.octo.assignement.service.VirementService;

@RestController(value = "/virements")
public class VirementController implements Controller<Virement,ArgentTransfertDto>{
	@Autowired
	private VirementService virementService;
	

	
    @GetMapping("lister_virements")
	@Override
	public List<Virement> loadAll() {
		try {
			return virementService.getAll();			
		}catch(Exception e) {
			return null;
		}
	}
    @PostMapping("/executerVirements")
    @ResponseStatus(HttpStatus.CREATED)
	@Override
	public void store(ArgentTransfertDto dto) throws SoldeDisponibleInsuffisantException, CompteNonExistantException, TransactionException , Exception {
        
        virementService.transferer(dto);
		
    }

	

	
}