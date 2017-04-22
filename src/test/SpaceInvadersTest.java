package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.SpaceInvaders;

public class SpaceInvadersTest {

   @Test
   public void test_AuDebut_JeuSpaceInvaderEstVide() {
	    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
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
	    "...............\n" , spaceinvaders.toString());
        }

   }