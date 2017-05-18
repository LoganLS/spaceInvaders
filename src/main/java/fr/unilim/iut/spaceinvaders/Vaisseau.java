package fr.unilim.iut.spaceinvaders;

import utils.MissileException;

public class Vaisseau extends Sprite {

	public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
		super(dimension, positionOrigine, vitesse); 
	}

	public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile);
		
		return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
	}

	private Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile) {
		
		if (dimensionMissile.longueur() > this.longueur())
			throw new MissileException("La longueur du missile est supérieure à celle du vaisseau.");
		
		int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
		int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);
		int ordonneeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
		
		return new Position(abscisseOrigineMissile, ordonneeOrigineMissile);
	}
} 
