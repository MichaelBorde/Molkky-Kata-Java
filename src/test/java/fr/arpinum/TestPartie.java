package fr.arpinum;

import static org.fest.assertions.Assertions.*;

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

		assertThat(pointage).isEqualTo(8);
	}

	@Test
	public void siUnJoueurFaitTomberPlusieursQuillesIlMarqueLeNombreDeQuilles() {
		partie.ajouteLancer(3, 6);

		int pointage = partie.pointage();

		assertThat(pointage).isEqualTo(2);
	}

	@Test
	public void lePointageDuJoueurEstLeCumulDePlusieursLancers() {
		partie.ajouteLancer(1);
		partie.ajouteLancer(3);

		int pointage = partie.pointage();

		assertThat(pointage).isEqualTo(4);
	}

	@Test
	public void siLeJoueurAtteint50PointsIlAGagnéLaPartie() {
		leJoueurMarque50Points();

		boolean partieGagnée = partie.gagnée();

		assertThat(partieGagnée).isTrue();
	}

	private void leJoueurMarque50Points() {
		leJoueurMarque48Points();
		partie.ajouteLancer(2);
	}

	@Test
	public void siLeJoueurAMoinsDe50PointsIlNAPasGagnéLaPartie() {
		partie.ajouteLancer(1);

		boolean partieGagnée = partie.gagnée();

		assertThat(partieGagnée).isFalse();
	}

	@Test
	public void siLeJoueurDepasse50PointsIlRedescendA25Points() {
		leJoueurMarque51Points();

		int pointage = partie.pointage();

		assertThat(pointage).isEqualTo(25);
	}

	private void leJoueurMarque51Points() {
		leJoueurMarque48Points();
		partie.ajouteLancer(3);
	}

	private void leJoueurMarque48Points() {
		partie.ajouteLancer(12);
		partie.ajouteLancer(12);
		partie.ajouteLancer(12);
		partie.ajouteLancer(12);
	}

	private Partie partie;
}
