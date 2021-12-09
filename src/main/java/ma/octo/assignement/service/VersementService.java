package ma.octo.assignement.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.ArgentTransfertDto;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.repository.VersementRepository;
import ma.octo.assignement.service.util.ArgentTransfertValidator;

@Service
public class VersementService extends AbstractArgentTransfertService<Versement , String , Compte>{
	
	@Autowired
	private ArgentTransfertValidator<String> validator;
	
	@Autowired
	private VersementRepository repVersements;
	@Autowired
	private CompteService compteService;
	
	@Override
	public boolean transferer(ArgentTransfertDto dto) throws Exception {
		VersementDto versementDto = (VersementDto)dto;
        Compte dst = compteService.getById(dto.getNrCompteBeneficiaire());
        String src = versementDto.getNomEmetteur();
		validator.validerTransaction(src, dst, dto);
		dst.setSolde(dst.getSolde().add(dto.getMontantTransferer()));
		compteService.update(dst);
		
		Versement versement = new Versement();
		versement.setMontantTransfer(dto.getMontantTransferer());
		versement.setMotifTransfert(dto.getMotif());
		versement.setNameEmetteur(((VersementDto)dto).getNomEmetteur());
		versement.setDateExecution(dto.getDate());
		versement.setCompteBeneficiaire(dst);
		
		this.add(versement);
		super.auti(versement);

		return true;
	}

	@Override
	public void add(Versement e) throws Exception {
		repVersements.save(e);
	}

	@Override
	public Versement getById(Long id) throws Exception {
		return repVersements.getById(id);
	}

	@Override
	public List<Versement> getAll() throws Exception {
		return repVersements.findAll();
	}

	@Override
	public void update(Versement e) throws Exception {
		 repVersements.save(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		Versement versement = repVersements.getById(id);
		repVersements.delete(versement);
	}

	
	
	
	
	

}
