package praktikum12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test {

	public static void main(String[] args) throws Exception{
		//Aufgabe 2b)
		try {
			UpperLowerWriter ulw = new UpperLowerWriter(
					new BufferedWriter(
						new FileWriter(
						"C:\\Users\\hanee\\OneDrive\\Desktop\\OOP2\\praktikum12\\p12.txt")));
			
			//Aufgabe 2c)
			ulw.write("Hello World ");
			ulw.write('\n');
			ulw.write('P');
			ulw.write('n');
			ulw.write('\n');
			ulw.write('2');
			ulw.write('\n');
			
			char[] input = {'P', 'r' ,'a', 'K', 't', 'I', 'k', 'u','M', '\n', '1' , '2'};
			ulw.write(input, 0, 1);
			ulw.write(input, 1, 1);
			ulw.write(input, 2, 2);
			ulw.flush();
			ulw.close();
			/*
			pN
			2
			pRAk
			*/
			
			//Aufgabe 2f)
			/*
			UpperLowerWriter ulw2 = new UpperLowerWriter(
									new BufferedWriter(
									new FileWriter("C:\\gibtesnicht\\file.txt")));
			*/
			//FileNotFoundException
			
			//Aufgabe 3
			
			UpperLowerWriter consoleWriter = new UpperLowerWriter(
											new OutputStreamWriter(System.out));
			
			consoleWriter.write('A');
			consoleWriter.write('b');
			consoleWriter.write('!');
			consoleWriter.write('\n');
			consoleWriter.write(input, 4, 2);
			consoleWriter.flush();
			consoleWriter.close();
			System.out.println();
			System.out.println("vv");
			System.out.println("ss");

			//Aufgabe 3d)
			
			System.err.println("\n TEst");

					
		}
		catch(Exception e) {
			System.err.println(e);
			throw e;
		}
	}

}
