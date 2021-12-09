package ma.octo.assignement.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.ArgentTransfertDto;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.repository.VirementRepository;
import ma.octo.assignement.service.util.ArgentTransfertValidator;
@Service
public class VirementService extends AbstractArgentTransfertService<Virement , Compte , Compte>{
	
	@Autowired
	private ArgentTransfertValidator<Compte> validator;
	
	@Autowired
	private VirementRepository repVirements;
	@Autowired
	private CompteService compteService;
	
	@Override
	public boolean transferer(ArgentTransfertDto dto) throws Exception {
        Compte src = compteService.getById(((VirementDto)dto).getNrCompteEmetteur());
        Compte dst = compteService.getById(dto.getNrCompteBeneficiaire());
		validator.validerTransaction(src, dst, dto);
		dst.setSolde(dst.getSolde().add(dto.getMontantTransferer()));
		compteService.update(dst);
		
		Virement virement = new Virement();
		virement.setCompteBeneficiaire(dst);
		virement.setCompteEmetteur(src);
		virement.setDateExecution(dto.getDate());
		virement.setMontantTransfer(dto.getMontantTransferer());
		virement.setMotifTransfert(dto.getMotif());
		
		repVirements.save(virement);
		
		 super.auti(virement);
		
		return true;
	}

	@Override
	public void add(Virement e) throws Exception {
		repVirements.save(e);
	}

	@Override
	public Virement getById(Long id) throws Exception {
		return repVirements.getById(id);
	}

	@Override
	public List<Virement> getAll() throws Exception {
		return repVirements.findAll();
	}

	@Override
	public void update(Virement e) throws Exception {
		repVirements.save(e);
		
	}

	@Override
	public void delete(Long id) throws Exception {
		repVirements.delete(repVirements.getById(id));
	}

	
	
	
	

}
