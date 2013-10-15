package fr.arpinum;

public class Partie {

	public void metsAJourLePointagePourLeLancer(String joueur, int... quilles) {
		pointages.définisPour(joueur, calculeLeNouveauPointage(joueur, new Lancer(quilles)));
	}

	private int calculeLeNouveauPointage(String joueur, Lancer lancer) {
		return siLePointageEstSupérieurA50Retourne25(calculeLePointageCumulé(joueur, lancer));
	}

	private int calculeLePointageCumulé(String joueur, Lancer lancer) {
		return pointages.pointagePour(joueur) + lancer.calculePointage();
	}

	private int siLePointageEstSupérieurA50Retourne25(int pointageCumulé) {
		return pointageCumulé > 50 ? 25 : pointageCumulé;
	}

	public int pointagePour(String joueur) {
		return pointages.pointagePour(joueur);
	}

	public String vainqueur() {
		return pointages.recupèreLeJoueurAyant50Points();
	}

	private final Pointages pointages = new Pointages();
}
