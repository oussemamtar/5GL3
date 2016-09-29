package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PeriodeId implements Serializable{

	private static final long serialVersionUID = -5138493636798592609L;

	@Column(name = "marchandise_fk")
	private int marchandiseId;
	@Column(name = "promotion_fk")
	private int promotionId;
	private Date dateDebut;
	private Date dateFin;
	
	public PeriodeId() {
	}

	public int getMarchandiseId() {
		return marchandiseId;
	}

	public void setMarchandiseId(int marchandiseId) {
		this.marchandiseId = marchandiseId;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + marchandiseId;
		result = prime * result + promotionId;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeriodeId other = (PeriodeId) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (marchandiseId != other.marchandiseId)
			return false;
		if (promotionId != other.promotionId)
			return false;
		return true;
	}
	
	
	
}
