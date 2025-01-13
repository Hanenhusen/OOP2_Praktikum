package praktikum15;

import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *  Aufgabe 1c) Teste die Filter, in dem entsprechende
 *         Eingabedatenstrom aufbauen, der am Ende Zeichen aus StringReader
 *         liest. Gebe alle gelesene Worte der Reihe nach auf die Konsole aus
 */
public class Test {

	public static void main(String[] args) throws IOException {
		String s = " Dokumente Dokumente  Dokumente ! ,, 32 sad  einem einem Eingabestrom gefiltert werden. ";

		FilterReader reader = new FilterReaderKlein(new StringReader(s));

		int i = 0;
		char c = 0;

		while (i != -1) {

			try {
				i = reader.read();
				c = (char) i;

				if (i != -1) {
					System.out.println(c);
				} else {
					System.out.println("Stream ist beendet klein ");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FilterReader arrayReader = new FilterReaderWort (new FilterReaderKlein(new StringReader(s)));
		
		
		int off = 0;
		int len = 20;
		int anz = 0;
		
		char [] buffer = new char [len+off];
		Wortsammlung w = new Wortsammlung();

		while(anz != -1) {
			anz = arrayReader.read(buffer, off, len);
			if(anz > 0) {
			
					System.out.println(new String(buffer, off, anz));
					w.wortHinzufuegen(buffer, off, anz);
				
			} else {
				System.out.println("Stream ist beendet Wort");
		}
		
		System.out.println(w.ergebnis());
		
		
	}
		System.out.println("Aufgabe 4");
		Wortsammlung ws = new Wortsammlung();
		Thread lesen1 = new Thread(new Lesen(ws, new StringReader("C:\\Users\\hanee\\OneDrive\\Desktop\\OOP2\\praktikum15 text.txt" )));
		Thread lesen2 = new Thread(new Lesen(ws, new StringReader("C:\\Users\\hanee\\OneDrive\\Desktop\\OOP2\\praktikum15 text.txt" )));
		Thread lesen3 = new Thread(new Lesen(ws, new StringReader("C:\\Users\\hanee\\OneDrive\\Desktop\\OOP2\\praktikum15 text.txt" )));
		
		lesen1.start();
		lesen2.start();
		lesen3.start();
			try {
			Thread.sleep(1000);
			
			lesen1.interrupt();
			lesen2.interrupt();
			lesen3.interrupt();
			
			System.out.println(ws);
		}catch(Exception e){
			System.err.println(e);
		}
	}
	
}
