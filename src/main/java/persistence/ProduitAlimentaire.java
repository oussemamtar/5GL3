package persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProduitAlimentaire
 *
 */
@Entity
public class ProduitAlimentaire extends Marchandise implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean bio;
	@ManyToOne @JoinColumn(name="condition_fk")
	private ConditionDeConservation conditionDeConservation;

	public ProduitAlimentaire() {
	}   
	
	
	public ProduitAlimentaire(int id, String marque, String nomMarchandise, double prix, boolean bio) {
		super(id, marque, nomMarchandise, prix);
		this.bio = bio;
	}


	public boolean getBio() {
		return this.bio;
	}

	public void setBio(boolean bio) {
		this.bio = bio;
	}


	public ConditionDeConservation getConditionDeConservation() {
		return conditionDeConservation;
	}


	public void setConditionDeConservation(ConditionDeConservation conditionDeConservation) {
		this.conditionDeConservation = conditionDeConservation;
	}
   
}
