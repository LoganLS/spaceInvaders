package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

public class DessinSpaceInvaders implements DessinJeu {

	private SpaceInvaders jeu;
	
	public DessinSpaceInvaders(SpaceInvaders jeu) {
		this.jeu = jeu; 
	}
	
	@Override
	public void dessiner(BufferedImage image) {
		if (jeu.aUnVaisseau()) {
			Vaisseau v = jeu.recupererVaisseau();
			dessinerUnVaisseau(v, image);
		}
		if (jeu.aUnMissile()) {
			Missile m = jeu.recupererMissile();
			dessinerUnMissile(m, image);
		}
		
	}

	private void dessinerUnVaisseau(Vaisseau v, BufferedImage image) {
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		crayon.setColor(Color.GRAY);
		crayon.fillRect(v.abscisseLaPlusAGauche(), v.ordonneeLaPlusBasse(), v.longueur(), v.hauteur());
	}
	
	private void dessinerUnMissile(Missile m, BufferedImage image) {
		Graphics2D crayon = (Graphics2D) image.getGraphics();
		crayon.setColor(Color.BLUE);
		crayon.fillRect(m.abscisseLaPlusAGauche(), m.ordonneeLaPlusBasse(), m.longueur(), m.hauteur());
	}
	

}
