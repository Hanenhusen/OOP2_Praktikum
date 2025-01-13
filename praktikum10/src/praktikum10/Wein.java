package praktikum10;

public class Wein {

	public static void main(String[] args) {
		// TODO Automatisch generierter Methodenstub
		
	}
	private float alkoholGehalt;
	/**
	 * Constructor Wein
	 * @param _alkoholGehalt
	 */
	public Wein(float _alkoholGehalt) {
		this.alkoholGehalt = _alkoholGehalt;
	}
	
	@Override
	public String toString() {
		return "Alkoholgehalt: " + this.alkoholGehalt;
	}
}
