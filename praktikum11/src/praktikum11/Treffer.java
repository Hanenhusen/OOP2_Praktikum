package praktikum11;

public class Treffer implements Comparable<Treffer>{
	//Comparable damit Treffer nur mit Treffer verglichen wird
	private final static int[] erlaubteWerte = {50, 100, 200, 500, 750, 1000};
	
	//Punktzahl der Treffer
	private Integer punktzahl;

	/**
	 * Aufgabe 1a)
	 * Werte aller möglichen Punktzahlen
	 * Objekte der Klasse Treffer sollen Angaben der dabei erzielten Punktzahlen erzeugt werden  
	 */
	Treffer(int punkte){
		this.punktzahl = erlaubteWerte[0];
		for(int i = 0; i < erlaubteWerte.length; i++) {
			if(punkte == erlaubteWerte[i]) {
				this.punktzahl = punkte;
			}
		}
	}

	/**
	 * Methode compareTo 
	 * @return punktzahl, die verglichen werden
	 */
	@Override
	public int compareTo(Treffer o) {
		return this.punktzahl.compareTo(o.punktzahl);
		//return (this.punktzahl - o.punktzahl);
	}
	
}
