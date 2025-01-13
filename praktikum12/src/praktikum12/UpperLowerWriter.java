package praktikum12;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class UpperLowerWriter extends FilterWriter{

	/**
	 * Aufgabe 1a)
	 * Constructor der Klasse UpperLowerWriter
	 * @param out Writer-Object, dem der Stream übergeben wird
	 */
	protected UpperLowerWriter(Writer out) {
		super(out);
	}
	
	/**
	 * zeichen umwandeln
	 * @param myInt
	 * @return umgewandelte Char output
	 */
	public char charUmwandeln (int myInt) {
		//char output = Character.toChars(myInt)[0];
		char output = (char) myInt;
		if(Character.isLowerCase(output)) {
			output = Character.toUpperCase(output);
		} else {
			output = Character.toLowerCase(output);
		}
		return output;
	}
	
	/**
	 * Aufgabe 1c)
	 * Methode write(int c), die Zeichen wie beschrieben umwandelt und im Datenstrom weitergibt
	 */
	public void write(int c) throws IOException{
		try {
				char output = charUmwandeln(c);
				this.out.write(output);
		}
		catch(IOException e) {
			System.err.println("Systemfehler beim Modifizieren in UpperLowerWriter" + e);
			throw e;
		}
	}
	
	/**
	 * Aufgabe 1d)
	 * Diese Methode ist deutlich performanter als der wiederholte Aufruf des einfachen
	 * write(int i) vor allem dann, wenn man viele Zeichen gleichzeitig schreibt
	 */
	public void write(char[] buf, int off, int len) throws IOException{
		try {
			char[] output = new char[len];
			for(int i = 0; i < len; i++) {
				output[i] = charUmwandeln(buf[off+i]);
				//charUmwandeln(tempCharacter);
				//output[i] = tempCharacter;
			}
			this.out.write(output, 0, len);
		}
		catch(IOException e) {
			System.err.println("Systemfehler beim Modifizieren in UpperLowerCase");
			throw e;
		}
	}
}
