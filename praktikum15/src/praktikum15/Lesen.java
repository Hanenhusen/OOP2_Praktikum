package praktikum15;

import java.io.IOException;
import java.io.Reader;

public class Lesen implements Runnable{
	private Wortsammlung sammlung;
	private Reader reader;
	
	public Lesen(Wortsammlung sammlung, Reader in) {
		this.sammlung = sammlung;
		this.reader = new FilterReaderWort(new FilterReaderKlein(in));
	}
	@Override
	public void run() {
		// TODO Automatisch generierter Methodenstub
		try {

			
			int off = 0;
			int len = 30;
			int anz = 0;
			
			char[] buffer = new char[len+off];
			
			System.out.println("\nWortsammlung: ");
			while(anz != -1 && Thread.interrupted()) {
				anz = reader.read(buffer, off, len);
				if(anz != -1) {
					sammlung.wortHinzufuegen(buffer, off, anz);
					Thread.sleep(10);
				} else {
					System.out.println("ABC");
				}
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
	}

}
