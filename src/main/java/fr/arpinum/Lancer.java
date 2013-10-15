package fr.arpinum;

class Lancer {

	public Lancer(int[] quilles) {
		this.quilles = quilles;
	}

	public int calculePointage() {
		return uneSeuleQuilleTombée() ? valeurQuilleTombée() : nombreDeQuillesTombées();
	}

	private int valeurQuilleTombée() {
		return quilles[0];
	}

	private boolean uneSeuleQuilleTombée() {
		return nombreDeQuillesTombées() == 1;
	}

	private int nombreDeQuillesTombées() {
		return quilles.length;
	}

	private final int[] quilles;
}