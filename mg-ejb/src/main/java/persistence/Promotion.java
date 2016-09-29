package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity
@Table(name="t_promotion")
@NamedQuery(name="ex8",
			query = "select p from Promotion p join p.periodes per join treat(per.marchandise as ProduitMenager) pm where :x member of pm.compositionChimiques"
)
public class Promotion implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	private int id;
	private float taux;
	@OneToMany(mappedBy="promotion")
	private List<Periode> periodes;

	public Promotion() {
	}
	
	
	
	public Promotion(int id, float taux) {
		this.id = id;
		this.taux = taux;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getTaux() {
		return this.taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}


	public List<Periode> getPeriodes() {
		return periodes;
	}


	public void setPeriodes(List<Periode> periodes) {
		this.periodes = periodes;
	}



	public String toString() {
		return "Promotion [id=" + id + ", taux=" + taux + "]";
	}
	
	
	
	
   
}
