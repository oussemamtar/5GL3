package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProduitMenager
 *
 */
@Entity

public class ProduitMenager extends Marchandise implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean toxique;
	@ManyToMany
	@JoinTable(name = "t_pm_cc",
		joinColumns = @JoinColumn(name="pm_fk"),
		inverseJoinColumns = @JoinColumn(name="cc_fk"),
		uniqueConstraints = @UniqueConstraint(columnNames = {"pm_fk", "cc_fk"})
	)
	private List<CompositionChimique> compositionChimiques;

	public ProduitMenager() {
	}   
	
	
	public ProduitMenager(int id, String marque, String nomMarchandise, double prix, boolean toxique) {
		super(id, marque, nomMarchandise, prix);
		this.toxique = toxique;
	}


	public boolean getToxique() {
		return this.toxique;
	}

	public void setToxique(boolean toxique) {
		this.toxique = toxique;
	}


	public List<CompositionChimique> getCompositionChimiques() {
		return compositionChimiques;
	}


	public void setCompositionChimiques(List<CompositionChimique> compositionChimiques) {
		this.compositionChimiques = compositionChimiques;
	}
   
}
