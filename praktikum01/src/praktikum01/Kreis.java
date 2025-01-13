package praktikum01;

public class Kreis extends Grafik implements Rollbar, java.lang.Comparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Kreis(int _x, int _y, String _farbe){
		 super(_x,_y,_farbe);
	 }
	 
	@Override
	public int rollen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub

	}
	
	//instanzvariable
	 int radius;
	
	 @Override
	 public int compareTo(Object ob) {
		 return 0;
	 }
	 
	 
}
