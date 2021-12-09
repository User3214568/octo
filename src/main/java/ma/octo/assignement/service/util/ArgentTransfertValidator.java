package ma.octo.assignement.service.util;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ma.octo.assignement.domain.AbstractArgentTransfert;
import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.dto.ArgentTransfertDto;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.web.VirementController;
@Service
public class ArgentTransfertValidator<Type> {
	Logger LOGGER = LoggerFactory.getLogger(VirementController.class);
	
	public void validerTransaction(Type src , Compte dest , ArgentTransfertDto dto) throws Exception {
		if(dest == null) throw new Exception("Compte destinataire est invalide.");
		this.validerCompte(src);			
		if(src instanceof Compte) {
			this.validerFinance((Compte)src, dto);
			this.validerMontant((Compte)src, dto);
		}
		this.validerMotif(dto);
		
	}
	public void validerCompte(Type src) throws Exception {
		if(src != null) throw new Exception("L'emetteur est invalide") ;
	}
	public  void validerFinance(Compte src , ArgentTransfertDto dto) throws TransactionException {
		if(dto.getMontantTransferer() == null ) throw new TransactionException("Montant à transferer est invalide");
		if(dto.getMontantTransferer().compareTo(new BigDecimal(AbstractArgentTransfert.MONTANT_MINIMAL))<=0) throw new TransactionException("Montant à transferer ne dépasse pas le montant minimale.");
		if(dto.getMontantTransferer().compareTo(new BigDecimal(AbstractArgentTransfert.MONTANT_MAXIMAL))>=0) throw new TransactionException("Montant à transferer dépasse le montant maximale");

	}
	public void validerMontant(Compte src , ArgentTransfertDto dto) {
		if(!(src.getSolde().compareTo(dto.getMontantTransferer())>= 0)) {
			 LOGGER.error("Solde insuffisant pour l'utilisateur");
		}
	}
	public void validerMotif(ArgentTransfertDto dto) throws TransactionException {
		if(! (dto.getMotif().length() <= 0)) throw new TransactionException("Motif Vide");
	}
}
