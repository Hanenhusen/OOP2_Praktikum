package praktikum13;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class UpperLowerReader extends FilterReader{

	public static void main(String[] args) {
		try {
			//Aufgabe 2b
			FilterReader reader = new UpperLowerReader(
								  new StringReader("aBc!"));
			//Aufgabe 2c
			System.out.println("---Aufgabe 2c---");
			int currentInt = 0;
			char currentCharacter = 0;
			
			while(currentInt != -1) {
				currentInt = reader.read();
				currentCharacter = (char) currentInt;
				if(currentInt != -1) {
					System.out.println("Auslesen: " + currentCharacter);
				} else {
					System.out.println("ABC");
				}
			}
			
			//Aufgabe 2d
			FilterReader readerArray = new UpperLowerReader(
									new StringReader("1234abCD&!"));
			
			System.out.println("\n---Aufgabe 2d---");
			int off = 0;
			int len = 5;
			int anz = 0;
			String ausgabe;
			
			char[] buf = new char [len + off];
			
			while(anz != -1) {
				anz = readerArray.read(buf, off, len);
				if(anz != -1) {
					ausgabe = new String(buf, off, len);
					System.out.println("Ausgabe: " + ausgabe);
				} else {
					System.out.println("ABC");
				}
			} 
			
			readerArray.close();
			//System.out.println("\n---Aufgabe 2e---");
			//anz = readerArray.read(buf, off, len);
			
			//Aufgabe 3b
			FilterReader fileReader = new UpperLowerReader(
									new FileReader("C:\\Users\\hanee\\OneDrive\\Desktop\\OOP2\\praktikum12\\p12.txt"));
					
			//Aufgabe 3c
			System.out.println("\n---Aufgabe 3c---");
			currentInt = 0;
			currentCharacter = 0;
			
			System.out.println("FileReader");
			while(currentInt != -1) {
				currentInt = fileReader.read();
				if(currentInt != 1) {
					currentCharacter = (char) currentInt;
					System.out.println("Auslesen: " + currentCharacter);
				} else {
					System.out.println("ABC");
				}
			}
			fileReader.close();
			
			//Aufgabe 3d
			//FilterReader fileReader1 = new UpperLowerReader(new FileReader("C:\\gibtesnicht\\file.txt"));
			//java.io.FileNotFoundException
			
			//Aufgabe4b

			BufferedReader bufferedReader = new BufferedReader(
											new UpperLowerReader (
											new FileReader("C:\\Users\\hanee\\OneDrive\\Desktop\\OOP2\\praktikum12\\p12.txt")));
			//Aufgabe 4c
			System.out.println("\n---Aufgabe 4c---");

			String output = "";
			String result = "";
			
			System.out.println("BufferedReader");
			while(output != null) {
				result += output;
				output = bufferedReader.readLine();
			}
			System.out.println(result);
			
		}
		catch (IOException exception) {
			System.err.println(exception);
		}
		
	}

	/**
	 * Constructor vom UpperLowerReader
	 * @param in
	 */
	protected UpperLowerReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * zeichen umwandeln
	 * @param myInt
	 * @return umgewandelte Char output
	 */
	public int charUmwandeln (int c) {
		//char output = Character.toChars(myInt)[0];
		char output = (char) c;
		if(Character.isLowerCase(output)) {
			output = Character.toUpperCase(output);
		} else {
			output = Character.toLowerCase(output);
		}
		int out = (int)output;
		return out;
	}
	
	/**
	 * Aufgabe 1c)
	 * Methode int read(), die ein gelesenes Zeichen umwandelt und im Datemstromweitergibt
	 */
	@Override
	public int read() throws IOException{
		
		try {
			int source = in.read();
			if(source != -1) {
				return charUmwandeln(source);	
			} else {
				return -1;
			}
		} catch (IOException exception) {
			System.err.println("Systemfehler beim Modifizieren in read()");
			throw exception;
		}
	}
	/**
	 * Aufgabe 1c)
	 * Methode int read(char[] buf, int off, int len),  die Parameter angegebene Anzahl
	 * von Zeichen im Datenstrom liest umwandelt und im Datemstrom weitergibt
	 */
	public int read(char[] buf, int off, int len) throws IOException{
		
		try {
			char [] buffer = new char [len];
			
			int anzahl = in.read(buffer, 0, len);
			if(anzahl == -1) {
				return -1;
			}
			for(int i = 0; i < anzahl; i++) {
				if(Character.isLowerCase(buffer[i])) {
					buf[i + off] = Character.toUpperCase(buffer[i]);
				} else {
					buf[i + off] = Character.toLowerCase(buffer[i]);
				}
			}
			return anzahl;
 		} catch (IOException exception) {
			System.err.println("Systemfehler beim Modifizieren in read()");
			throw exception;
		}
	}
}
