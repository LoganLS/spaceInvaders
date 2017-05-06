package main;

public class Vaisseau {

	Position origine;
	Dimension dimension;

	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
	}

	public Vaisseau(int longueur, int hauteur, int x, int y) {
		this(new Position(x, y), new Dimension(longueur, hauteur));
	}
	
	public Vaisseau(Position origine, Dimension dimension) {
		this.origine = origine;
		this.dimension = dimension;
	}

	public boolean occupeLaPosition(int x, int y) {
		return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
	}

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	private int ordonneeLaPlusHaute() {
		return this.origine.ordonnee();
	}

	private int ordonneeLaPlusBasse() {
		return this.origine.ordonnee() - this.dimension.hauteur() + 1;
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	public int abscisseLaPlusADroite() {
		return this.origine.abscisse() + this.dimension.longueur() - 1;
	}

	public void seDeplacerVersLaDroite() {
	    this.origine.changerAbscisse(this.origine.abscisse() + 1);
   }

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public void seDeplacerVersLaGauche() {
		 this.origine.changerAbscisse(this.origine.abscisse() - 1);
	}

	public void positionner(int x, int y) {
		  this.origine.changerAbscisse(x);
		  this.origine.changerOrdonnee(y);
    }

}
