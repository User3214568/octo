package ma.octo.assignement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.repository.CompteRepository;

@Service
public class CompteService implements CrudOperations<Compte,String>{
	@Autowired
	private CompteRepository repComptes;
	
	@Override
	public void add(Compte e) throws Exception {
		repComptes.save(e);
	}

	@Override
	public Compte getById(String id) throws Exception {
		return repComptes.findByNrCompte(id);
	}

	@Override
	public List<Compte> getAll() throws Exception {
		return repComptes.findAll();
	}

	@Override
	public void update(Compte e) throws Exception {
		repComptes.save(e);
	}

	@Override
	public void delete(String id) throws Exception {
		Compte compte = repComptes.findByNrCompte(id);
		repComptes.delete(compte);
	}
	
}
