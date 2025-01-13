package praktikum08;

public class Studi implements java.lang.Comparable {

	private String name;
	private int martikelnummer;
	
	Studi(String _name, int _martikelnummer){
		this.name = _name;
		this.martikelnummer = _martikelnummer;
	}
	
	public String toString() {
		return " Name: " + name + ", Martikelnummer: " + martikelnummer + ".";
	}
	
	public int compareTo (Object o) {
		return this.toString().compareTo(o.toString());
	}

	public void examineInCourse(String course) {
		System.out.println("Teste " +  this.name + " in " + course);
	}
}
