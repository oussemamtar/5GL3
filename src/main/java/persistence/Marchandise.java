package persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Marchandise
 *
 */
@Entity
@Table(name="t_marchandise")

public class Marchandise implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	private int id;
	private String marque;
	private String nomMarchandise;
	private double prix;
	@OneToMany(mappedBy="marchandise")
	private List<Periode> periodes;

	public Marchandise() {
	}
	
	
	
	public Marchandise(int id, String marque, String nomMarchandise, double prix) {
		this.id = id;
		this.marque = marque;
		this.nomMarchandise = nomMarchandise;
		this.prix = prix;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}   
	public String getNomMarchandise() {
		return this.nomMarchandise;
	}

	public void setNomMarchandise(String nomMarchandise) {
		this.nomMarchandise = nomMarchandise;
	}   
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}



	public List<Periode> getPeriodes() {
		return periodes;
	}



	public void setPeriodes(List<Periode> periodes) {
		this.periodes = periodes;
	}
   
}
