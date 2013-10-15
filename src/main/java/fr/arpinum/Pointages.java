package fr.arpinum;

import java.util.HashMap;
import java.util.Map;

class Pointages {

	public Pointages() {
		pointages = new HashMap<>();
	}

	public void définisPour(String joueur, int pointage) {
		pointages.put(joueur, pointage);
	}

	public int pointagePour(String joueur) {
		initialiseLePointageSiBesoinPour(joueur);
		return pointages.get(joueur);
	}

	private void initialiseLePointageSiBesoinPour(String joueur) {
		if (!pointages.containsKey(joueur)) {
			définisPour(joueur, 0);
		}
	}

	public String recupèreLeJoueurAyant50Points() {
		for (Map.Entry<String, Integer> pointagePourJoueur : pointages.entrySet()) {
			if (pointagePourJoueur.getValue() == 50) {
				return pointagePourJoueur.getKey();
			}
		}
		return null;
	}

	private final Map<String, Integer> pointages;
}