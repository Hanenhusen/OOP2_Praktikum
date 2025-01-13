package praktikum15;

import java.util.*;
public class Wortsammlung {
	/**
	 * Aufgabe 2
	 * Definieren Sie dafür eine eigene Klasse, in deren Instanzen Worte und ihre Häufigkeit in einer
		geeigneten generischen Datenstruktur gespeichert werden. Definieren Sie eine passende InstanzVariable.
	 */
	private TreeMap<String, Integer> sammlung;
	
	public Wortsammlung() {
		this.sammlung = new TreeMap<>();
	}
	
	/*b) Um Häufigkeiten zu zählen, definieren Sie in dieser Klasse eine Methode, der ein Wort übergeben
	wird. Ist das Wort bereits in der Wortsammlung vorhanden, wird seine Häufigkeit um 1 erhöht. Ist es
	noch nicht vorhanden, wird es mit der Häufigkeit 1 darin gespeichert.
	Das Wort wird der Methode in einem Array von char übergeben wird. Das Wort beginnt im Array an
	einem Startindex, außerdem wird die Länge des Wortes als dritter Parameter angegeben.*/ 
	
	synchronized void wortHinzufuegen(char[] wortArray, int off, int len) {
		
		String wort = new String(wortArray, off, len);
		
		if(sammlung.containsKey(wort)) {
			int anzahl = sammlung.get(wort);
			sammlung.put(wort, anzahl+1);
		} else {
			sammlung.put(wort, 1);
		}
	}
	

	synchronized String ergebnis(){
		String ergebnis ="";
		
		for(Map.Entry<String, Integer>entry : sammlung.entrySet()) 
			{
			 ergebnis+= (entry.getKey() + ":" + entry.getValue() );
		}
		return ergebnis;
	}
}
