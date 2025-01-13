package praktikum15;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Aufgabe1 a) Buchstabern werden in Kleinbuchstaben umgewandelt, alle anderen
 * Zeichen sollen als Leerzeichen weitergegeben werden. Hier int read()-Methode
 * nutzen
 */

public class FilterReaderKlein extends FilterReader{
	/*
	 * Constructor
	 */
	protected FilterReaderKlein(Reader in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		try {
			int c = in.read();
			if (c != -1) {
				if (Character.isLetter(c)) {
					return Character.toLowerCase(c);
				} else {
					return ' ';
				}
			} else {
				return -1;
			}
		} catch (IOException exception) {
			System.err.println("Fehler beim FilterReaderKlein in der read()-Methode");
			throw exception;
		}
	}
}
