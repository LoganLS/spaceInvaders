package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpaceInvadersTest {
	
    private SpaceInvaders spaceinvaders;

    @Before
    public void initialisation() {
	    spaceinvaders = new SpaceInvaders(15, 10);
    }

    @Test
	public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {
		
		spaceinvaders.positionnerUnNouveauVaisseau(7,9);

		spaceinvaders.deplacerVaisseauVersLaDroite();
		
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"........V......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
    
	@Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
		
		spaceinvaders.positionnerUnNouveauVaisseau(14,9);

		spaceinvaders.deplacerVaisseauVersLaDroite();
		
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"..............V\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
    
    
	
    @Test(expected = HorsEspaceJeuException.class)
	public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropADroite_UneExceptionEstLevee() throws Exception {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		spaceinvaders.positionnerUnNouveauVaisseau(15,9);
	}

    @Test(expected = HorsEspaceJeuException.class)
	public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		spaceinvaders.positionnerUnNouveauVaisseau(14,10);
	}
    
	@Test
	public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(15,9);
			fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(-1,9);
			fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(14,10);
			fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(14,-1);
			fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
			
	}
}