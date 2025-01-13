package praktikum11;
import java.util.Map;
import java.util.TreeMap;
public class Spiel {

	public static void main(String[] args) throws Exception{
		//Aufgabe 3c)
		System.out.println("::::::Aufgabe 3c ::::::");
		Spiel meinSpiel = new Spiel();
		meinSpiel.testeTreffer();
		System.out.println(meinSpiel.trefferBericht());
		
		//Aufgabe 4b)
		System.out.println("\n::::::Aufgabe 4 Exceptions testen::::::");
		meinSpiel.testExceptions(new Treffer(50));
		
		//Aufgabe 4c1) //Fehler: ClassCastException
		//meinSpiel.testExceptions("String");
		
		//Aufgabe 4c2) //Fehler: NullPointerException
		//meinSpiel.testExceptions(null);
		
		//Aufgabe 5b)
		System.out.println("\n:::::Aufgabe 5 Exceptions testen und fangen:::::");
		meinSpiel.catchExceptions(new Treffer(50));
		
		//Fehler: java.lang.ClassCastException
		meinSpiel.catchExceptions("String");
		//Fehler: java.lang.NullPointerException
		meinSpiel.catchExceptions(null);
		
		//Aufgabe 5i)
		System.out.println("\n:::::Aufgabe 5 Throw Exceptions:::::");
		try {
			meinSpiel.throwExceptions("String");
			meinSpiel.throwExceptions(null);
		}
		catch(ClassCastException e){
			System.err.println("ClassCastException");
			throw e;
		}catch(NullPointerException e) {
			System.err.println("NullPointerException");
			throw e;
		}
	} 

		/**
		 * Aufgabe 2a)
		 * Map mit den Treffern als Key und Anzhal der Treffer als Value gelten
		 */
		TreeMap<Treffer, Integer> anzahlTreffer;
		
		Spiel(){
			this.anzahlTreffer= new TreeMap<>();
		}

		/**
		 *AUfgbae 2b)
	     * Einen Treffer hinzufügen
	     * Gibt es bereits einen Eintrag in der Map für diesen Treffer?
	     * Nein: Füge einen Eintrag mit der Anzahl 1 in Map ein
	     * Ja: Ermittel aktuelle Anzahl in der Map zu diesem Treffer, neuer EIntrag einfügen
	     * alten ersetzen
	     * @param t neuer Treffer		 
	     */
		
		public void registrieren(Treffer t) {			
			if(anzahlTreffer.containsKey(t)) {
				int neueAnzahl = anzahlTreffer.get(t) + 1;
				anzahlTreffer.put(t, neueAnzahl);
			} else {
				anzahlTreffer.put(t, 1);
			}
		}
		
		/**
		 * Aufgabe 2c)
		 * Methode testeTreffer(), die 15 Treffer-Objekte(davon 2 nicht vorgesehen) mit 
		 * unterschiedlichen Punktzahlenerzeugt und diese im Spiel-Objekt registriert
		 */
		public void testeTreffer() {
			int [] werte = {50, 100, 200, 500, 750, 1000};
			
			java.util.Random zufall = new java.util.Random();
			
			//13 Treffer mit Random Werte
			for (int i = 0; i < 13; i++) {
				registrieren(new Treffer(werte[zufall.nextInt(6)]));
			}
			
			//nicht vorgesehene Treffer
			registrieren(new Treffer(55));
			registrieren(new Treffer(1000));
		}
		

		//Aufgabe 3a)
	    //Um über eine Map zu iterieren, ist es notwendig, 
		//vorher die Map in serialisiertes Entry-Set zu konvertieren
		
		/**
		 * Aufgbae 3b)
		 * Funktion String trefferBericht(), die gewünschten Bericht als Ergebnis zurückgibt
		 */
		public String trefferBericht() {
			String bericht= "";
			
			for(Map.Entry<Treffer, Integer> entry : anzahlTreffer.entrySet()) {
				bericht += "Punktzahl: " + entry.getKey() + " Anzahl: " + entry.getValue() + ", ";
			}
			return bericht;
			
			//In welcher Reihenfolge ist dieses Set sortiert?
			//aufsteigend nach der Punktzahl (compareTo-Methode)
			
			//Kann man über einen Set iterieren? Woaran erkennt man das?
			//Iterable<E> ist ein SuperInterface
		}
		
		/**
		 * Aufgabe 4
		 * methode testExceptions
		 */
		public void testExceptions(Object key) {
			Integer anzahl = anzahlTreffer.get(key);
			System.out.println(anzahl);
			System.out.println("###Ferig");
		}

		/**
		 * Aufgabe 5
		 * methode catchExceptions()
		 */
		public void catchExceptions(Object key) {
			try {
				Integer anzahl = anzahlTreffer.get(key);
				System.out.println(anzahl);
				System.out.println("###Ferig");
			}
			
			catch(NullPointerException e) {
				System.err.println("Null Pointer Exception: " + e);	
			}catch(ClassCastException e) {
			System.err.println("Class Cast Exception: " + e.getMessage());
			} catch(Exception e) {
				System.err.println("Allgemeiner Fehler: " + e);
			} finally {
				System.out.println("Test beendet");
			}
			
			//allgmeinen Catch verschiebung:Unreachable catch block for NullPointerException. It is already handled by the catch block for Exception
		}
		
		public void throwExceptions(Object key) throws Exception{
			try {
				Integer anzahl = anzahlTreffer.get(key);
				System.out.println(anzahl);
				System.out.println("###Ferig");
			}
			
			catch(NullPointerException e) {
				System.err.println("Null Pointer Exception: " + e);
				throw e;
			}catch(ClassCastException e) {
				System.err.println("Class Cast Exception: " + e);
				throw e;
			} catch(Exception e) {
				System.err.println("Allgemeiner Fehler: " + e);
				throw e;
			} finally {
				System.out.println("Test beendet");
			}
		}
}
