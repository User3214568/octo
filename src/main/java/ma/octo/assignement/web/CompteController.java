
package ma.octo.assignement.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.service.UtilisateurService;

@RestController(value = "/utilisateurs")
public class CompteController implements Controller<Utilisateur,Void>{
	@Autowired
	private UtilisateurService utilisateurService;
	@GetMapping("lister_comptes")
	@Override
	public List<Utilisateur> loadAll() {
		return utilisateurService.getAll();
	}

	
	

	
}
