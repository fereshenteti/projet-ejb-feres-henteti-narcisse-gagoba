package org.isims.ejb.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.isims.ejb.entities.Extrait;
import org.isims.ejb.entities.Formation;

@Stateless(name="EF")
public class ExtraitFormationRemoteImpl implements ExtraitFormationRemote{

	@PersistenceContext(unitName="PROJET")
	private EntityManager em;
	
	@Override
	public Formation ajouterFormation(Formation formation) {
		em.persist(formation);
		return formation;
	}

	@Override
	public Formation modifierFormation(Formation formation) {
		em.merge(formation);
		em.flush();
		return formation;
	}

	@Override
	public void deleteFormation(Long idFormation) {
		em.remove(getFormationByID(idFormation));
	}

	@Override
	public boolean desactiverFormation(Long idFormation) {
		Formation f = getFormationByID(idFormation);
		f.setActif(false);
		em.merge(f);
		em.flush();
		return true;
	}

	@Override
	public Formation getFormationByID(Long idFormation) {
		return em.find(Formation.class, idFormation);
	}

	@Override
	public List<Formation> listFormation() {
		Query req = em.createQuery("select f from Formation f");
		return req.getResultList();
	}

	@Override
	public Extrait ajouterExtrait(Extrait extrait) {
		em.persist(extrait);
		return extrait;
	}

	@Override
	public Extrait modifierExtrait(Extrait extrait) {
		em.merge(extrait);
		em.flush();
		return extrait;
	}

	@Override
	public boolean changerFormationExtrait(Extrait extrait, Long idNewFormation) {
		Formation f = getFormationByID(idNewFormation);
		extrait.setFormation(f);
		em.merge(extrait);
		em.flush();
		return false;
	}

	@Override
	public void deleteExtrait(Long idExtrait) {
		em.remove(getExtraitByID(idExtrait));
	}

	@Override
	public boolean desactiverExtrait(Long idExtrait) {
		Extrait e = getExtraitByID(idExtrait);
		e.setActivee(false);
		em.merge(e);
		em.flush();
		return false;
	}

	@Override
	public List<Extrait> listExtraitFormation(Long idFormation) {
		Query req = em.createQuery("select e from Extrait e");
		return req.getResultList();
	}

	@Override
	public Extrait getExtraitByID(Long idExtrait) {
		return em.find(Extrait.class, idExtrait);
	}

}
