package praktikum01;

public class Quadrat extends Grafik {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * implikation der abstrakte methode draw()
	 */
	public void draw() {
		System.out.println(this);
	}
	
	private int laenge;
	
	/**
	 * Konstruktor der Klasse Quadrat
	 * @param _x
	 * @param _y
	 * @param _laenge
	 * @param _farbe
	 */
	public Quadrat(int _x, int _y, int _laenge, String _farbe) {
		super(_x, _y ,_farbe);
		laenge = _laenge;
	}
	
	public String toString() {
		String ausgabe = super.toString() + ", Länge= " + laenge;
		return  ausgabe ;
	}

}
