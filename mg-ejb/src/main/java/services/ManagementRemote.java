package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.CompositionChimique;
import persistence.ConditionDeConservation;
import persistence.ProduitAlimentaire;
import persistence.ProduitMenager;
import persistence.Promotion;

@Remote
public interface ManagementRemote {

	void ajouterProduitAlimentaire(ProduitAlimentaire pAlimentaire);

	void ajouterCompositionChimique(CompositionChimique composition);

	void assignerConditionAProduit(ConditionDeConservation condition, ProduitAlimentaire produit);
	
	void assignerProduitACondition(ConditionDeConservation condition, ProduitAlimentaire produit);
	
	void assignerComposantAProduitMenager(ProduitMenager pm, List<CompositionChimique> composants);
	
	void ajouterPromotion(Promotion promo);
	
	Long nbreProduitParTemperature (int temperature);
	
	List<Promotion> nbrePromoParComposant( CompositionChimique composition);

}
