package ma.octo.assignement.domain;

import javax.persistence.*;


@Entity
@Table(name = "VIREMENT")
public class Virement  extends AbstractArgentTransfert{
  
  @ManyToOne
  private Compte compteEmetteur;

  

  public Compte getCompteEmetteur() {
    return compteEmetteur;
  }

  public void setCompteEmetteur(Compte compteEmetteur) {
    this.compteEmetteur = compteEmetteur;
  }
  public String toString() {
		return this.getClass().getName()+" depuis "+this.compteEmetteur.getNrCompte()+" "+super.toString();
  }

  
}
