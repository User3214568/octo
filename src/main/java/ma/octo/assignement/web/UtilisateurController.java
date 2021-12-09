package ma.octo.assignement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.service.CompteService;

@RestController(value = "/comptes")
public class UtilisateurController implements Controller<Compte,Void>{
	@Autowired
	private CompteService compteService;
	
    @GetMapping("lister_utilisateurs")
	@Override
	public List<Compte> loadAll() {
		try {
			return compteService.getAll();			
		}catch(Exception e) {
			return null;
		}
	}

	
	

	
}
