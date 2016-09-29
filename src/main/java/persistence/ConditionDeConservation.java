package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConditionDeConservation
 *
 */
@Entity
@Table(name="t_condition_conservation")

public class ConditionDeConservation implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	private int id;
	private float humidite;
	private int temperarture;
	@OneToMany(mappedBy="conditionDeConservation")
	private List<ProduitAlimentaire> produitsAlimentaires;

	public ConditionDeConservation() {
	}   
	
	
	
	public ConditionDeConservation(int id, float humidite, int temperarture) {
		this.id = id;
		this.humidite = humidite;
		this.temperarture = temperarture;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getHumidite() {
		return this.humidite;
	}

	public void setHumidite(float humidite) {
		this.humidite = humidite;
	}   
	public int getTemperarture() {
		return this.temperarture;
	}

	public void setTemperarture(int temperarture) {
		this.temperarture = temperarture;
	}



	public List<ProduitAlimentaire> getProduitsAlimentaires() {
		return produitsAlimentaires;
	}



	public void setProduitsAlimentaires(List<ProduitAlimentaire> produitsAlimentaires) {
		this.produitsAlimentaires = produitsAlimentaires;
	}
   
}
