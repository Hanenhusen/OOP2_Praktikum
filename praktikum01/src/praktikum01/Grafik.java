package praktikum01;

public abstract class Grafik {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private int x;
	private int y;
	private String farbe;
	
	/**
	 * methode positioniert x, y Koordinaten der Grafik
	 * @param _x x Koordinaten 
	 * @param _y Y Koordinaten 
	 */
	private void positioniere(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	/**
	 * methode setzt die Farbe der Grafik
	 * @param _farbe 
	 */
	private void setzeFarbe( String _farbe) {
		farbe = _farbe;
	}
	
	/**
	 * Eigenschaften der Grafik ausgeben
	 */
	public String toString() {
		String ausgabe = "X= " + this.x + ", Y= " + this.y + ", Farbe= " + this.farbe ;
		return ausgabe;
	}
	
	/**
	 * Konstruktor der Klasse Grafik
	 * @param _x
	 * @param _y
	 * @param _farbe
	 */
	Grafik(int _x, int _y , String _farbe){
		this.positioniere(_x, _y);
		this.setzeFarbe(_farbe);
	}
	
	/**
	 * MEthode soll etwas zeichnen 
	 */
	abstract void draw();
		//Abstrakte Methode darf nur in einer abstrakter Klasse enthalten sein
		//und ohne implementierung, ohne Body
	
}
