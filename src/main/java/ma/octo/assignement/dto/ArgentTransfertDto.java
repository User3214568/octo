package ma.octo.assignement.dto;

import java.math.BigDecimal;
import java.util.Date;

public abstract class ArgentTransfertDto {

	  private String nrCompteBeneficiaire;
	  private String motif;
	  private BigDecimal montantTransferer;
	  private Date date;

	  

	  public String getNrCompteBeneficiaire() {
	    return nrCompteBeneficiaire;
	  }

	  public void setNrCompteBeneficiaire(String nrCompteBeneficiaire) {
	    this.nrCompteBeneficiaire = nrCompteBeneficiaire;
	  }

	  public String getMotif() {
	    return motif;
	  }

	  public void setMotif(String motif) {
	    this.motif = motif;
	  }

	  public Date getDate() {
	    return date;
	  }

	  public void setDate(Date date) {
	    this.date = date;
	  }

	public BigDecimal getMontantTransferer() {
		return montantTransferer;
	}

	public void setMontantTransferer(BigDecimal montantTransferer) {
		this.montantTransferer = montantTransferer;
	}
}
