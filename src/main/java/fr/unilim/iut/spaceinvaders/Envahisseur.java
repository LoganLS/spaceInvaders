package fr.unilim.iut.spaceinvaders;

public class Envahisseur extends Sprite {

	public Envahisseur(Position position) {
		super(new Dimension(1,1),position,1);
	}

	public Envahisseur(Dimension dimension, Position position) {
		super(dimension,position,1);
	}

}
