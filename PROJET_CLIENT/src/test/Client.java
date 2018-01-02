package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.isims.ejb.entities.Extrait;
import org.isims.ejb.entities.Formation;
import org.isims.ejb.metier.ExtraitFormationRemote;


public class Client {

	public static void main(String[] args) {
		try {
			Context ctx = new InitialContext();
			ExtraitFormationRemote proxy = (ExtraitFormationRemote)ctx.lookup("ejb:/PROJET/EF!org.isims.ejb.metier.ExtraitFormationRemote");
			
			System.out.println("Ajout de formations");
			Formation f1 = new Formation("Developpement SYNFONY 3", "Prendre en main le framwrok Synfony3", 30, 500, 300, 25, 25, true);
			proxy.ajouterFormation(f1);
			Formation f2 = new Formation("Blender", "Apprenez la modelisation 3D sous Blender", 10, 150, 150, 25, 25, true);
			proxy.ajouterFormation(f2);
			Formation f3 = new Formation("Soft Skills", "La developpement personnel", 3, 400, 400, 59, 100, true);
			proxy.ajouterFormation(f3);
			
			f3.setEffectifMax(80);
			f3.setPrixOffre(300);
			f3.setActif(false);
			
			System.out.println("Modification de formation");
			proxy.modifierFormation(f3);
			
			System.out.println("Ajout d'extraits de formations");
			Extrait e1 = new Extrait("Synfony Partie I", "La premiere partie de Synfony", "Developpement SYNFONY 3", true, f1);
			proxy.ajouterExtrait(e1);
			proxy.ajouterExtrait(new Extrait("Synfony Partie II", "La seconde partie de Synfony", "Developpement SYNFONY 3", true, f1));
			proxy.ajouterExtrait(new Extrait("Blender Partie I", "La premiere partie de Synfony", "Developpement SYNFONY 3", true, f1));
		
			System.out.println("Desactiver de extrait");
			proxy.desactiverExtrait(e1.getIdExtrait());
			
			System.out.println("Desactiver de extrait");
			proxy.changerFormationExtrait(e1, f2.getIdFormation());
		
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
	}

}
