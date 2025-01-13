package praktikum10;

public class Rotwein extends Wein {

	public static void main(String[] args) {
		// TODO Automatisch generierter Methodenstub

	}
	public Rotwein(float _alkoholGehalt) {
		super(_alkoholGehalt);
	}
	
	private static String weinTyp = "Rotwein";
	@Override
	public String toString() {
		return super.toString() + " Weintyp: " + weinTyp;
	}
}
