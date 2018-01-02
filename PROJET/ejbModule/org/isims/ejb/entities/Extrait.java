package org.isims.ejb.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Extrait implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8211653219837043262L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExtrait;
	@Column(nullable=false)
	private String titre;
	@Column(nullable=true)
	private String description;
	@Column(nullable=false)
	private String src;
	private boolean activee;
	@ManyToOne
	private Formation formation;
	
	public Extrait() {
		super();
	}
	public Extrait(String titre, String description, String src, boolean activee) {
		super();
		this.titre = titre;
		this.description = description;
		this.src = src;
		this.activee = activee;
	}
	public Extrait(String titre, String description,
			String src, boolean activee, Formation formation) {
		super();
		this.titre = titre;
		this.description = description;
		this.src = src;
		this.activee = activee;
		this.formation = formation;
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
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public boolean isActivee() {
		return activee;
	}
	public void setActivee(boolean activee) {
		this.activee = activee;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Long getIdExtrait() {
		return idExtrait;
	}
	
}
