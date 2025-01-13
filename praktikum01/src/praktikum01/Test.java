package praktikum01;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Grafik g1= new Grafik(2, 3, "Rot");
		//System.out.println(g1.toString());
		
		Quadrat q1 = new Quadrat (2,3, 5,"Blau");
		System.out.println(q1.toString());
		q1.draw();
		
		Rollbar meineRolle;
		//meineRolle auf kreis zeigen!! und methode rollen aufrufen??
		//meineRolle = new Kreis();
		//meineRolle.rollen();
		
		//meineRolle = new Tonne();
		//meineRolle.rollen();
		
		Comparable comp1;
		Comparable comp2;
		
		comp1 = "Hallo";
		comp2 = "World";
		System.out.println(comp1.compareTo(comp2));
		
		//comp1 = new kreis();
		//copm2 = new kreis();
		//comp1.compareTo(comp2);
		
	}

}
