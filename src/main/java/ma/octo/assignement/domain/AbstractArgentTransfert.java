package ma.octo.assignement.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractArgentTransfert {
	public static final int MONTANT_MINIMAL = 10;
	public static final int MONTANT_MAXIMAL = 10000;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Compte compteBeneficiaire;
	
	@Column(length = 200)
	private String motifTransfert;
	
	@Column(precision = 16, scale = 2, nullable = false)
	private BigDecimal montantTransfer;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateExecution;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compte getCompteBeneficiaire() {
		return compteBeneficiaire;
	}

	public void setCompteBeneficiaire(Compte compteBeneficiaire) {
		this.compteBeneficiaire = compteBeneficiaire;
	}

	
	public String getMotifTransfert() {
		return motifTransfert;
	}

	public void setMotifTransfert(String motifTransfert) {
		this.motifTransfert = motifTransfert;
	}

	public BigDecimal getMontantTransfer() {
		return montantTransfer;
	}

	public void setMontantTransfer(BigDecimal montantTransfer) {
		this.montantTransfer = montantTransfer;
	}

	public Date getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}
	public String toString() {
		return " vers " + this.getCompteBeneficiaire().getNrCompte() + " d'un montant de " + this.getMontantTransfer();
	}
}
