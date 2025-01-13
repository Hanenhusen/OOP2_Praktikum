package praktikum09;
//Fall E
public class Studi implements java.lang.Comparable<Studi> {

	private String name;
	private int martikelnummer;
	
	Studi(String _name, int _martikelnummer){
		this.name = _name;
		this.martikelnummer = _martikelnummer;
	}
	
	public String toString() {
		return " Name: " + name + ", Martikelnummer: " + martikelnummer + ".";
	}
	
	public int compareTo (Studi o) {
		return this.name.compareTo(o.name);
	}

	public void examineInCourse(String course) {
		System.out.println( this.name + " in " + course);
	}
}
