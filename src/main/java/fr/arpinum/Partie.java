package fr.arpinum;

public class Partie {

	public void metsAJourLePointagePourLeLancer(int... quilles) {
		pointage += calculePointageDuLancer(quilles);
		siLePointageDepasse50IlRedescendA25();
	}

	private void siLePointageDepasse50IlRedescendA25() {
		if (pointage > 50) {
			pointage = 25;
		}
	}

	private int calculePointageDuLancer(int[] quilles) {
		return uneSeuleQuilleTombée(quilles) ? valeurQuilleTombée(quilles) : nombreDeQuillesTombées(quilles);
	}

	private boolean uneSeuleQuilleTombée(int[] quilles) {
		return nombreDeQuillesTombées(quilles) == 1;
	}

	private int valeurQuilleTombée(int[] quilles) {
		return quilles[0];
	}

	private int nombreDeQuillesTombées(int[] quilles) {
		return quilles.length;
	}

	public int pointage() {
		return pointage;
	}

	public boolean gagnée() {
		return pointage == 50;
	}

	private int pointage;
}
