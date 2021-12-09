package ma.octo.assignement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.repository.UtilisateurRepository;
@Service
public class UtilisateurService implements CrudOperations<Utilisateur,Long>{
	@Autowired
	private UtilisateurRepository repUtilisateurs;
	
	@Override
	public List<Utilisateur> getAll() {
		return repUtilisateurs.findAll();
	}

	@Override
	public void add(Utilisateur utilisateur) {
		repUtilisateurs.save(utilisateur);
		
	}

	@Override
	public void update(Utilisateur updates) {
		 this.add(updates);
	}

	@Override
	public void delete(Long id) throws Exception {
		Utilisateur utilisateur = repUtilisateurs.getById(id);
		if(utilisateur  == null ) throw new Exception("Utilisateur non existant");
		repUtilisateurs.delete(repUtilisateurs.getById(id));
	}

	@Override
	public Utilisateur getById(Long id) {
		return repUtilisateurs.getById(id);
		
	}

}
