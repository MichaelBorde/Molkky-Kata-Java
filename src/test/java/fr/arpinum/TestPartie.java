package fr.arpinum;

import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Before;
import org.junit.Test;

public class TestPartie {

	@Before
	public void avantChaqueTest() {
		partie = new Partie();
	}

	@Test
	public void siUnJoueurFaitTomberUneQuilleIlMarqueLaValeurDeLaQuille() {
		partie.ajouteLancer(8);

		int pointage = partie.pointage();

		alors().le(pointage).est(8);
	}

	@Test
	public void siUnJoueurFaitTomberPlusieursQuillesIlMarqueLeNombreDeQuilles() {
		partie.ajouteLancer(3, 6);

		int pointage = partie.pointage();

		alors().le(pointage).est(2);
	}

	@Test
	public void lePointageDuJoueurEstLeCumulDePlusieursLancers() {
		partie.ajouteLancer(1);
		partie.ajouteLancer(3);

		int pointage = partie.pointage();

		alors().le(pointage).est(4);
	}

	@Test
	public void siLeJoueurAtteint50PointsIlAGagnéLaPartie() {
		leJoueurMarque50Points();

		boolean partieGagnée = partie.gagnée();

		alors().la(partieGagnée).estVraie();
	}

	private void leJoueurMarque50Points() {
		leJoueurMarque40Points();
		partie.ajouteLancer(10);
	}

	@Test
	public void siLeJoueurAMoinsDe50PointsIlNAPasGagnéLaPartie() {
		partie.ajouteLancer(1);

		boolean partieGagnée = partie.gagnée();

		alors().la(partieGagnée).estFausse();
	}

	@Test
	public void siLeJoueurDepasse50PointsIlRedescendA25Points() {
		leJoueurMarque51Points();

		int pointage = partie.pointage();

		alors().le(pointage).est(25);
	}

	private void leJoueurMarque51Points() {
		leJoueurMarque40Points();
		partie.ajouteLancer(11);
	}

	private void leJoueurMarque40Points() {
		for (int i = 0; i < 4; i++) {
			partie.ajouteLancer(10);
		}
	}

	private Partie partie;
}
