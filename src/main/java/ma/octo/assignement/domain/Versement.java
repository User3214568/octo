package ma.octo.assignement.domain;

import javax.persistence.*;


@Entity
@Table(name = "VERSEMENT")
public class Versement extends AbstractArgentTransfert{
 
	@Column
	private String nameEmetteur;
	
	public String getNameEmetteur() {
		return nameEmetteur;
	}

	public void setNameEmetteur(String nameEmetteur) {
		this.nameEmetteur = nameEmetteur;
	}
	public String toString() {
		return this.getClass().getName()+" depuis "+this.nameEmetteur+" "+super.toString();
	}


 
}
