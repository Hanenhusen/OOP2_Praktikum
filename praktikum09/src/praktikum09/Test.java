package praktikum09;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		//Fall F,G
		GenCompTree<String> tree = new GenCompTree<String>();
		//Fall H
		tree.add("07");
		tree.add("04");
		tree.add("15");
		tree.add("02");
		tree.add("06");
		tree.add("05");
		tree.add("03");
		
		//System.out.println(tree.toString());
		System.out.println("-----AUFGABE 2-----");
		System.out.println("-----Baum ausgeben-----");
		tree.baumAusgeben();
		
		//Fall F
		Iterator<String> iterator = tree.iterator();
		while (iterator.hasNext()) {
			String temp = iterator.next();
			System.out.println(temp + "-->");
			System.out.println("Ist 5 enthalten?  "+ temp.contains("5"));//Fall I
		}
		

		/*
		//For each Schleife
		for(String current : tree) {
			System.out.println(current + "-->");
			System.out.println("Ist 5 enthalten?  " + current.contains("5"));
		}*/
		
		
		System.out.println("\n"+"-----AUFGABE 3-----");
		//Fall F
		GenCompTree<Integer> intTree = new GenCompTree<>();	
		GenCompTree<Studi> studiTree = new GenCompTree<>();
		//Fall G
		studiTree.add(new Studi("Georg", 7));
		studiTree.add(new Studi("Dora", 4));
		studiTree.add(new Studi("Oskar", 15));
		studiTree.add(new Studi("Bob", 2));
		studiTree.add(new Studi("Fred", 6));
		studiTree.add(new Studi("Egon", 5));
		studiTree.add(new Studi("Charles", 3));
		
		intTree.add(7);
		intTree.add(4);
		intTree.add(15);
		intTree.add(2);
		intTree.add(6);
		intTree.add(5);
		intTree.add(3);
		
		System.out.println("-----StudiTree ausgeben-----");
		System.out.println(studiTree.toString());
		System.out.println("-----IntegerTree ausgeben-----");
		System.out.println(intTree.toString());
		
		
		System.out.println("\n"+"-----StudiTree iterieren-----");

		//Fall F
		Iterator<Studi> studiIterator = studiTree.iterator();
		while (studiIterator.hasNext()) {
			Studi temp = studiIterator.next(); //Fall I
			temp.examineInCourse("OOP" );
		}
		
		/*
		//For each Schleife
		for(Studi current : studiTree) {
			current.examineInCourse("OOP");
		}*/
		
		System.out.println("\n"+"-----IntegerTree iterieren-----");

		//Fall F, I
		Iterator<Integer> intIterator = intTree.iterator();
		while  (intIterator.hasNext()) {
			Integer temp = intIterator.next();
			System.out.println(temp.intValue());
		}
		/*
		for (Integer current : intTree) {
			System.out.println(current.intValue());
		}*/
		
		//Aufgabe 3d)
		//The method add(Studi) in the type GenCompTree<Studi> is not applicable for the arguments (int)
		//The method add(Integer) in the type GenCompTree<Integer> is not applicable for the arguments (Studi)

		//studiTree.add(3);	//Change method; Typsicherer Baum, nur Integer
		
		//intTree.add(new Studi("7", 4));
		
	}

}
