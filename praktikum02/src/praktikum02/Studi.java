package praktikum02;

public class Studi implements java.lang.Comparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

	}
	
	//a) Definieren Sie eine Klasse Studi mit den Eigenschaften Name (String) und Matrikelnummer
	//(int). Beide Eigenschaften werden im Konstruktor der Klasse gesetzt.
			
	private String name;
	private int martikelnummer;
	
	Studi(String _name, int _martikelnummer){
		this.name = _name;
		this.martikelnummer = _martikelnummer;
	}
	
	//b) Definieren Sie in der Klasse Studi die Standard-Methode public String toString(), die 
	//eine Darstellung des Objekts als String zurückgibt
	
	public String toString() {
		return "Name: " + name + ", Martikelnummer: " + martikelnummer;
	}
	
	public int compareTo (Object o) {
		return this.toString().compareTo(o.toString());
	}

}
