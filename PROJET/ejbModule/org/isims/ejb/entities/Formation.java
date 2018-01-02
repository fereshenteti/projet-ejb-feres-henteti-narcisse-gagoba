package org.isims.ejb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4752258690807994852L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFormation;
	@Column(nullable=false)
	private String titre;
	@Column(nullable=true)
	private String description;
	@Column(nullable=false)
	private int duree;
	@Column(nullable=false)
	private float ancienPrix;
	private float prixOffre;
	private int effectifGroupe;
	@Column(nullable=false)
	private int effectifMax;
	private int totalInscription;
	private boolean actif;
	@OneToMany(mappedBy="formation")
	private List<Extrait> extraits;
	
	public Formation(String titre, String description, int duree,
			float ancienPrix, float prixOffre, int effectifGroupe,
			int effectifMax, int totalInscription, boolean actif) {
		super();
		this.titre = titre;
		this.description = description;
		this.duree = duree;
		this.ancienPrix = ancienPrix;
		this.prixOffre = prixOffre;
		this.effectifGroupe = effectifGroupe;
		this.effectifMax = effectifMax;
		this.totalInscription = totalInscription;
		this.actif = actif;
	}

	public Formation(String titre, String description, int duree,
			float ancienPrix, float prixOffre, int effectifGroupe,
			int effectifMax, boolean actif) {
		super();
		this.titre = titre;
		this.description = description;
		this.duree = duree;
		this.ancienPrix = ancienPrix;
		this.prixOffre = prixOffre;
		this.effectifGroupe = effectifGroupe;
		this.effectifMax = effectifMax;
		this.actif = actif;
	}



	public Formation() {
		super();
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getAncienPrix() {
		return ancienPrix;
	}

	public void setAncienPrix(float ancienPrix) {
		this.ancienPrix = ancienPrix;
	}

	public float getPrixOffre() {
		return prixOffre;
	}

	public void setPrixOffre(float prixOffre) {
		this.prixOffre = prixOffre;
	}

	public int getEffectifGroupe() {
		return effectifGroupe;
	}

	public void setEffectifGroupe(int effectifGroupe) {
		this.effectifGroupe = effectifGroupe;
	}

	public int getEffectifMax() {
		return effectifMax;
	}

	public void setEffectifMax(int effectifMax) {
		this.effectifMax = effectifMax;
	}

	public int getTotalInscription() {
		return totalInscription;
	}

	public void setTotalInscription(int totalInscription) {
		this.totalInscription = totalInscription;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public List<Extrait> getExtraits() {
		return extraits;
	}

	public void setExtraits(List<Extrait> extraits) {
		this.extraits = extraits;
	}
}
