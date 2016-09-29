package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Periode
 *
 */
@Entity
@Table(name="t_periode")
public class Periode implements Serializable {

	private static final long serialVersionUID = 8217196088073186694L;
	
	
	@EmbeddedId
	private PeriodeId id;
	@ManyToOne
	@JoinColumn(name="marchandise_fk", insertable = false, updatable = false)
	private Marchandise marchandise;
	@ManyToOne
	@JoinColumn(name="promotion_fk", insertable = false, updatable = false)
	private Promotion promotion;

	public Periode() {
	}
	
	

	public Periode(Marchandise marchandise, Promotion promotion, Date dateDebut, Date dateFin) {
		this.id = new PeriodeId();
		this.id.setMarchandiseId(marchandise.getId());
		this.id.setPromotionId(promotion.getId());
		this.id.setDateDebut(dateDebut);
		this.id.setDateFin(dateFin);
		this.marchandise = marchandise;
		this.promotion = promotion;
	}



	public PeriodeId getId() {
		return id;
	}

	public void setId(PeriodeId id) {
		this.id = id;
	}

	public Marchandise getMarchandise() {
		return marchandise;
	}

	public void setMarchandise(Marchandise marchandise) {
		this.marchandise = marchandise;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
   
}
