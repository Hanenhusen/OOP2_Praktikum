package praktikum14;

public class Lampe implements Runnable{

	public static void main(String[] args) {
		// TODO Automatisch generierter Methodenstub

	}

	Boolean zustand = false;	//boolean 
	String farbe;
	int verweildauer;
	int durchlaeufe;
	
	public Lampe(String _farbe, int _verweildauer, int _durchlaeufe) {
		this.farbe = _farbe;
		this.verweildauer = _verweildauer;
		this.durchlaeufe = _durchlaeufe;
	}


	@Override
	public void run() {
		//run1();
		run2();
	}
	
	public void run1() {
		// TODO Automatisch generierter Methodenstub
		System.out.println("Lampe ist nun aktiv");
		for(int i=0 ; i< this.durchlaeufe ; i++) {
			zustand = !zustand;
			System.out.println("Zustand der Lampe: " + zustand + "\n Die Farbe ist: " + farbe +"\n");
			try {
				Thread.sleep(verweildauer);
			} catch(Exception e) {
				System.err.println(e);
			}
		}
		System.out.println("Lampe ist nun inaktiv");
	}
	
	/**
	 * Aufgabe 4a)
	 * @return GROßBUCHSTABEN wenn Lampe ein ist, kleinbuchstabe wenn Lampe aus ist
	 */
	public String state() {
		if(this.zustand) {
			return this.farbe.toUpperCase();
		} else {
			return this.farbe.toLowerCase();
		}
	} 
	/**
	 * Aufgabe 5
	 * Lampe soll kanonisch unterbrochen werden können
	 */
	private void run2() {

		System.out.println("Lampe ist nun aktiv");
		
		int counter = 0;
		while(counter < this.durchlaeufe && !Thread.currentThread().isInterrupted()) {
			
			zustand = !zustand;
			System.out.println("Zustand der Lampe: " + zustand);
			try {
				Thread.sleep(verweildauer);
			} catch(InterruptedException e) {
				System.err.println(e);
				System.out.println("Lampe wurde aus dem Schlaf geweckt");
				Thread.currentThread().interrupt();
			}
			counter++;
		}
		System.out.println("Lampe ist nun inaktiv");
	}
	
}
