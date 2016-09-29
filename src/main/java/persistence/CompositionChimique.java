package persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompositionChimique
 *
 */
@Entity
@Table( name = "t_composition_chimique" )
public class CompositionChimique implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	private String composant;

	public CompositionChimique() {
	}   
	
	public CompositionChimique(String composant) {
		this.composant = composant;
	}


	public String getComposant() {
		return this.composant;
	}

	public void setComposant(String composant) {
		this.composant = composant;
	}
   
}
