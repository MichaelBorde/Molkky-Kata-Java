package fr.arpinum;

public class Partie {

	public void ajouteLancer(int... quilles) {
		pointage += calculePointageLancer(quilles);
		siLePointageDepasse50IlRedescendA25();
	}

	private void siLePointageDepasse50IlRedescendA25() {
		if (pointage > 50) {
			pointage = 25;
		}
	}

	private int calculePointageLancer(int[] quilles) {
		return quilles.length == 1 ? quilles[0] : quilles.length;
	}

	public int pointage() {
		return pointage;
	}

	public boolean gagnée() {
		return pointage == 50;
	}

	private int pointage;
}
