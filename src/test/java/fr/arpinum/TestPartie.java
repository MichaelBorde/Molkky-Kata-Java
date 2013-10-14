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
		partie.metsAJourLePointagePourLeLancer("Michael", 8);

		int pointage = partie.pointage("Michael");

		alors().le(pointage).est(8);
	}

	@Test
	public void siUnJoueurFaitTomberPlusieursQuillesIlMarqueLeNombreDeQuilles() {
		partie.metsAJourLePointagePourLeLancer("Michael", 3, 6);

		int pointage = partie.pointage("Michael");

		alors().le(pointage).est(2);
	}

	@Test
	public void lePointageDuJoueurEstLeCumulDePlusieursLancers() {
		partie.metsAJourLePointagePourLeLancer("Michael", 1);
		partie.metsAJourLePointagePourLeLancer("Michael", 3);

		int pointage = partie.pointage("Michael");

		alors().le(pointage).est(4);
	}

	@Test
	public void siLeJoueurAtteint50PointsIlAGagnéLaPartie() {
		partie.metsAJourLePointagePourLeLancer("Michael", 50);

		boolean partieGagnée = partie.gagnéePour("Michael");

		alors().ceci(partieGagnée).estVrai();
	}

	@Test
	public void siLeJoueurAMoinsDe50PointsIlNAPasGagnéLaPartie() {
		partie.metsAJourLePointagePourLeLancer("Michael", 1);

		boolean partieGagnée = partie.gagnéePour("Michael");

		alors().ceci(partieGagnée).estFaux();
	}

	@Test
	public void siLeJoueurDepasse50PointsIlRedescendA25Points() {
		partie.metsAJourLePointagePourLeLancer("Michael", 51);

		int pointage = partie.pointage("Michael");

		alors().le(pointage).est(25);
	}

	@Test
	public void leJeuEstMultijoueur() {
		partie.metsAJourLePointagePourLeLancer("Michael", 1);
		partie.metsAJourLePointagePourLeLancer("Charles", 4);

		alors().le(partie.pointage("Michael")).est(1);
		alors().le(partie.pointage("Charles")).est(4);
	}

	private Partie partie;
}
