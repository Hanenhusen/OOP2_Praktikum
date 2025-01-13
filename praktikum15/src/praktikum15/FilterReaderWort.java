package praktikum15;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 *  Aufgabe 1b) Der nach a) gefilterte Eingabestrom soll in
 *         einzelne Worte separiert werden Verwende die Methode read(char buf[],
 *         int off, int len)
 */
public class FilterReaderWort extends FilterReader{
	protected FilterReaderWort(Reader in) {
		super(in);
	}

	public int read(char buf[], int off, int len) throws IOException {
		try {
			if (len > 0 && off + len <= buf.length) {

				int c = in.read();

			

				if (c == -1) {
					return -1;
				}

				int i = off;
				
				while (c != ' ' && c != -1) {
					if (i <= off + len) {
						buf[i] = (char) c;
						i++;
						
					}
					c = in.read();
				}
				return i - off;
			}
			return -1;
		} catch (IOException exception) {
			throw exception;
		}
	}

}
