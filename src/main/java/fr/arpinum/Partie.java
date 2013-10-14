package fr.arpinum;

import java.util.HashMap;
import java.util.Map;

public class Partie {

	public void metsAJourLePointagePourLeLancer(String joueur, int... quilles) {
		initialiseLePointageSiBesoinPour(joueur);
		pointages.put(joueur, calculeLePointageCumulé(joueur, quilles));
		siLePointageDepasse50IlRedescendA25(joueur);
	}

	private int calculeLePointageCumulé(String joueur, int[] quilles) {
		return pointages.get(joueur) + new Lancer(quilles).calculePointage();
	}

	private void initialiseLePointageSiBesoinPour(String joueur) {
		if (!pointages.containsKey(joueur)) {
			pointages.put(joueur, 0);
		}
	}

	private void siLePointageDepasse50IlRedescendA25(String joueur) {
		if (pointages.get(joueur) > 50) {
			pointages.put(joueur, 25);
		}
	}

	public int pointage(String joueur) {
		return pointages.get(joueur);
	}

	public boolean gagnéePour(String joueur) {
		return pointages.get(joueur) == 50;
	}

	private Map<String, Integer> pointages = new HashMap<>();
}
