package praktikum08;


public class Test {
	public static void main(String[] args) {
		CompTree test = new CompTree();
		test.add(new Studi("Studi",1));
		test.add(new Studi("Studi",2));
		test.add(new Studi("Studi",3));
		System.out.println("------Baum mit Studi-Objekte-----");
		System.out.println(test.toString()+ "\n");
		
		/*
		//Studi cannot be cast to class java.lang.String 
	    //(praktikum08.Studi is in module praktikum08 of loader 'app';
	    // java.lang.String is in module java.base of loader 'bootstrap')
		System.out.println("------Baum mit Studi- und String-Objekte-----");
		CompTree test2 = new CompTree();
		test2.add(new Studi("Studi", 1));
		test2.add(new String("String_1"));
		test2.add(new Studi("Studi", 2));
		test2.add(new String("String_2"));
		*/
		
		System.out.println("-----Aufgabe 3c----");
		test.baumAusgeben();
		
		/*
		 //Aufgabe 3d
		java.util.Iterator iter = test.iterator();			
		while (iter.hasNext()) {
			iter.next().examineInCourse("OOP ");
		}
		 //Aufgabe 3e	
		java.util.Iterator iter2 = test.iterator();
		for (Object studi: test) {
			studi.examineInCourse("OOP");			
		}
		*/
		
		System.out.println("-----Aufgabe 4b-----");
		Integer wrapi = Integer.valueOf(3);
		System.out.println("Integer= " + wrapi + "\n");
		
		Double wrapi2 = Double.valueOf(5.3);
		System.out.println("Double= " + wrapi2 + "\n");

		System.out.println("-----Aufgabe 4c-----");
		//int i = wrapi;
		int i = wrapi.intValue();
		System.out.println("int= " + i + "\n");
		double d = wrapi2;
		System.out.println("double= " + d + "\n");

		//System.out.println("-----Aufgabe 4d-----");
		//wrapi = 3.8; // --> Funktioniert nicht da Integer initialisiert wurde und nicht double

	}
	
}
