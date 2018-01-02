package org.isims.ejb.metier;

import java.util.List;

import javax.ejb.Remote;

import org.isims.ejb.entities.Extrait;
import org.isims.ejb.entities.Formation;

@Remote
public interface ExtraitFormationRemote {

	public Formation ajouterFormation(Formation formation);
	public Formation modifierFormation(Formation formation);
	public void deleteFormation(Long idFormation);
	public boolean desactiverFormation(Long idFormation);
	public Formation getFormationByID(Long idFormation);
	public List<Formation> listFormation();
	
	public Extrait ajouterExtrait(Extrait extrait);
	public Extrait modifierExtrait(Extrait extrait);
	public boolean changerFormationExtrait(Extrait extrait,Long idNewFormation);
	public void deleteExtrait(Long idExtrait);
	public boolean desactiverExtrait(Long idFormation);
	public Extrait getExtraitByID(Long idExtrait);
	public List<Extrait> listExtraitFormation(Long idExtrait);
}
