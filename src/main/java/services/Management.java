package services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.CompositionChimique;
import persistence.ConditionDeConservation;
import persistence.Marchandise;
import persistence.Periode;
import persistence.ProduitAlimentaire;
import persistence.ProduitMenager;
import persistence.Promotion;

@Stateless
public class Management implements ManagementRemote {
	
	@PersistenceContext
	private EntityManager em;

    public Management() {
    }

	public void ajouterProduitAlimentaire(ProduitAlimentaire pAlimentaire) {
		em.persist(pAlimentaire);
	}

	public void ajouterCompositionChimique(CompositionChimique composition) {
		em.persist(composition);
	}

	public void assignerConditionAProduit(ConditionDeConservation condition, ProduitAlimentaire produit) {
		produit = em.find(ProduitAlimentaire.class, produit.getId());
		em.persist(condition);
		produit.setConditionDeConservation(condition);
	}

	public void assignerProduitACondition(ConditionDeConservation condition, ProduitAlimentaire produit) {
		produit.setConditionDeConservation(condition);
		em.persist(produit);
	}

	public void assignerComposantAProduitMenager(ProduitMenager pm, List<CompositionChimique> composants) {
		em.persist(pm);
		pm.setCompositionChimiques(composants);
	}

	public void ajouterPromotion(Promotion promo) {
		em.persist(promo);
		for (Periode periode : promo.getPeriodes()) {
			em.merge(periode);
		}
		
	}

	public Long nbreProduitParTemperature(int temperature) {
		return em
				.createQuery("select count(pa) from ProduitAlimentaire pa where pa.conditionDeConservation.temperarture > :x", Long.class)
				.setParameter("x", temperature)
				.getSingleResult();
	}

	public List<Promotion> nbrePromoParComposant(CompositionChimique composition) {
		List<Promotion> promotions = new ArrayList<>();
		List<Promotion> allPromotions = em
										.createQuery("from Promotion", Promotion.class)
										.getResultList();
		for (Promotion promotion : allPromotions) {
			for (Periode periode : promotion.getPeriodes()) {
				Marchandise marchandise = periode.getMarchandise();
				if(marchandise instanceof ProduitMenager){
					ProduitMenager pm = (ProduitMenager) marchandise;
					List<CompositionChimique> compositionChimiques = pm.getCompositionChimiques();
					for (CompositionChimique compositionChimique : compositionChimiques) {
						if (compositionChimique.getComposant().equals(composition.getComposant())){
							promotions.add(promotion);
						}
					}
				}
			}
		}
		
		return promotions;
	
		
//another solution (one shot) with NamedQuery ex8 (see Promotion entity)		
//		return em
//				.createNamedQuery("ex8", Promotion.class)
//				.setParameter("x", composition)
//				.getResultList();
	}
	
	
    
    

}
