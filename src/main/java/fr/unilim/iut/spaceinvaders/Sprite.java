package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.moteurJeu.Commande;

public abstract class Sprite {

	protected Position origine;
	protected Dimension dimension;
	protected int vitesse;

	
	public Sprite(Dimension dimension, Position origine, int vitesse) {
		super();
		this.dimension = dimension;
		this.origine = origine;
		this.vitesse = vitesse;
	}

	public Sprite() {
		super(); 
	}

	public void positionner(int x, int y) {
		  this.origine.changerAbscisse(x);
		  this.origine.changerOrdonnee(y);
	}

	public boolean occupeLaPosition(int x, int y) {
		return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
	}

	public int ordonneeLaPlusHaute() {
		return this.origine.ordonnee();
	}

	public int ordonneeLaPlusBasse() {
		return this.origine.ordonnee() - this.dimension.hauteur() + 1;
	}

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	public int abscisseLaPlusADroite() {
		return this.origine.abscisse() + this.dimension.longueur() - 1;
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	public int longueur() {
		return this.dimension.longueur;
	}

	public int hauteur() {
		return this.dimension.hauteur;
	}

	public void seDeplacer(Commande commande) {
		if (commande.gauche) {
			deplacerHorizontalementVers(Direction.GAUCHE);
		}
		
		if (commande.droite) {
			deplacerHorizontalementVers(Direction.DROITE);
		}
	}
	
	public void deplacerVerticalementVers(Direction direction) {
		this.origine.changerOrdonnee(this.origine.ordonnee() + direction.valeur()*vitesse);
	}
	
	public void deplacerHorizontalementVers(Direction direction) {
		this.origine.changerAbscisse(this.origine.abscisse() + direction.valeur()*vitesse);
	}
	
}
