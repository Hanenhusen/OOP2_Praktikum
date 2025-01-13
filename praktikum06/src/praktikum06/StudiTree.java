
package praktikum06;

public class StudiTree {

	public static void main(String[] args) {
		StudiTree baum01 = new StudiTree();
		Studi s1=new Studi("George",7);
		Studi s2 = new Studi("Dora",4);
		Studi s3= new Studi("Omikron",15);
		Studi s4 =new Studi("Bob",2);
		Studi s5 = new Studi("Fred",6);
		Studi s6 = new Studi("Egon",5);
		Studi s7 = new Studi("Charles",3);
		Studi s8 = new Studi("Ludwig",12);
		Studi s9 = new Studi("Karl",11);
		Studi s10 = new Studi("Martin",13);
		Studi s11 = new Studi("Paul",16);
		baum01.add(s1);
		baum01.add(s2);
		baum01.add(s3);
		baum01.add(s4);
		baum01.add(s5);
		baum01.add(s6);
		baum01.add(s7);
		baum01.add(s8);
		baum01.add(s9);
		baum01.add(s10);
		baum01.add(s11);
		
		System.out.println(":::::Pre-Order:::::");
		System.out.println(baum01.preOrder()+"\n");
		
		System.out.println(":::::Post-Order:::::");
		System.out.println(baum01.postOrder()+"\n");
		
		System.out.println("Der Node mit der kleinsten Nutzlast: " + baum01.getSmallest());
		System.out.println("Der Node mit der groessten Nutzlast: " + baum01.getBiggest()+"\n");
		
		System.out.println("-----Charles entfernen-----");
		baum01.entfernen(s7);
		System.out.println(baum01.toString()+"\n");
		
		System.out.println("-----Fred entfernen-----");
		baum01.entfernen(s5);
		System.out.println(baum01.toString()+"\n");
		
		System.out.println("-----Omikron entfernen-----");
		baum01.entfernen(s3);
		System.out.println(baum01.toString()+"\n");
		
		System.out.println("::::::::BAUM NACH DEM LOESCHEN:::::::");
		baum01.einruecken();
		/*
		System.out.println("baum0101 ausgeben:");
		System.out.println(baum0101.toString());
		
		System.out.println("Ist S1 in dem baum0101 enthalten? " + baum0101.contains(s1));
		System.out.println("Ist S2 in dem baum0101 enthalten? " + baum0101.contains(s2));

		System.out.println("Eingerueckter baum0101");
		baum0101.einruecken();
		 */
	}
	
	//Wurzel des gesamten baum0101
	Node wurzel;
	
	/**
	 * Nodes in baum0101 einfügen
	 * @param neu, nutzlast in den baum0101 eingefügt wird
	 */
	public void add(Studi neu) {
		//ist der baum0101 leer?
		if(wurzel == null) {
			//Wenn ja, der neue Knotrn als Wurzel setzen
			this.wurzel = new Node(neu);
		}
		//Wenn nein, wird der Node ab der Wurzel eingefügt
		else {
			wurzel.add(neu);
		}
	}
	
	public String toString() {
		return this.inOrder();
	}
	/**
	 * gibt die Elemente des baum0101s sortiert als String aus
	 * @return sortierte Reihenfolge der baum0101
	 */
	public String inOrder() {
		if(wurzel != null) {
			return wurzel.inOrder();
		}
		return null;
	}
	

	/**
	 * Methode contains, die zurückgeben, ob der übergebene String bereits als Nutzlast 
	 * im baum0101 enthalten ist
	 * @param s
	 * @return true, wenn in String im baum0101 vorhanden ist
	 */
	public boolean contains (Studi s) {
		/*
		boolean gefunden = true;
		if(wurzel != null)
			
			gefunden = wurzel.contains(s);
		return gefunden;
		*/
		if(wurzel != null) {
			return wurzel.contains(s);
		}
		return false;
	}
	
	/**
	 * Methode einruecken, baum0101 soll eingerückt ausgegeben werden
	 */
	public void einruecken() {
		if(wurzel != null)
			wurzel.einruecken(0);
	}
	
	/**
	 * Methode Pre-Order , diese gibt einen String zurück, der die String-Darstellung 
	 * aller Nutzlasten in der jeweiligen Reihenfolge ausgibt 
	 * @return Null
	 */
	
	public String preOrder() {
		if(wurzel != null)
			return wurzel.preOrder();
		return null;
	}
	
	/**
	 * Methode Post-Order, diese gibt einen String zurück, der die String-darstellung
	 * aller Nutzlasten in der jeweiligen Reihenfolge ausgibt
	 * @return null
	 */
	public String postOrder() {
		if(wurzel != null)
			return wurzel.postOrder();
		return null;
		
	}
	
	/**
	 * Es soll der Node mit der kleinsten Nutzlast zurückgegeben
	 * @return Node mit der kleinsten Nutzlast
	 */
	public Studi getSmallest() {
		if(wurzel != null)
			return wurzel.getSmallest().payload();
		return null;
	}
	
	
	/**
	 * Es soll der Node mit der größten Nutzlast zurückgegeben werden
	 * @return getBiggest
	 */
	public Studi getBiggest() {
		if(wurzel != null)
			return wurzel.getBiggest().payload();
		return null;
	}
	
	/** Entfernen eines Nodes aus dem baum0101
	 * @param s Der Node mit der Nutzlast s wird aus dem baum0101 entfernt
	*/
	void entfernen(Studi s) {
	    // nur entfernen, wenn es eine Wurzel gibt
	    if(wurzel != null)
	    	wurzel = wurzel.entfernen(s);  // entfernen() gibt den Node zurück der nach dem Entfernen von wurzel referenziert werden soll.
	}
	
	private class Node{
		//Referenz auf die Nutzlast
		Studi nutzlast;
		
		//Referenz auf die Teilbäume
		Node  smaller, bigger;
		
		/**
		 * Constructor
		 * @param s Nutzlast von Node
		 */
		Node(Studi s){
			nutzlast=s;
		}
		
		public String toString() {
			return nutzlast.toString();
		}
		
		/**
		 * nutzlast ab this einfügen
		 * @param neu, neue Studi nutzlast einfügen
		 */
		private void add(Studi neu) {
			int ergebnis = neu.compareTo(nutzlast);
			
			//Wenn kein unterschied, dann wird nichts gemacht
			if(ergebnis == 0)
				return;
			
			//neu<nutzlast
			if(ergebnis < 0) {
				if(smaller == null) {//teilbaum0101 ist leer?
					this.smaller = new Node(neu);
				} 
				else {//in kleinsten baum0101 einfügen
					smaller.add(neu);
				}
			}
			
			//s>nutzlast
			if(ergebnis > 0) {
				if(bigger == null) {
					this.bigger = new Node(neu);
				} else {
					bigger.add(neu);
				}
			}
		}
		
		/**
		 * Methode inOrder, baum0101 soll in geordneter Reihenfolge ausgegeben werden
		 * @return geordneter baum0101 wird ausgegeben
		 */
		private String inOrder() {
			String baum0101InOrder = "";
			if(smaller != null) {
				baum0101InOrder+= smaller.inOrder();
			}
			baum0101InOrder+= this.nutzlast;
			if(bigger !=null) {
				baum0101InOrder+= bigger.inOrder();
			}
			return baum0101InOrder;
		}
		
		/**
		 * Iteriert durch den baum0101 und vergleicht den übergebenen String mit der
		 * eigenen Nutzlast
		 * @param s
		 * @return true, wenn String vorhanden
		 */
		private boolean contains(Studi s) {
			int ergebnis = s.compareTo(nutzlast);
			
			if(ergebnis == 0)
				return true;
			
			if(ergebnis > 0)
				if(bigger != null)
					return bigger.contains(s);
				else 
					return false;
			if(ergebnis < 0 )
				if(smaller != null)
					return smaller.contains(s);
				else 
					return false;
				
			return false;
		}
		
		/**
		 * Der baum0101 soll eingerückt werden
		 * @param einruecken
		 */
		private void einruecken(int einruecken) {
			if(bigger != null) {
				bigger.einruecken(einruecken + 1);
			}
			
			String eingerueckterString = "";
			for(int i = 0; i < einruecken; i ++) {
				eingerueckterString += ".";
			}
			System.out.println(eingerueckterString + nutzlast);
			
			if(smaller != null) {
				smaller.einruecken(einruecken + 1);
			}
		}
		
		/**
		 * Methode PreOrder, die einen String zurückgibt
		 * Wurzel -> smallerern Teilbaum0101 -> größeren Teilbaum0101 
		 * @return baum0101PostOrder Der baum0101 wird in PreOrder zurückgegeben
		 */
		private String preOrder() {
			
			String baum0101PreOrder = "";
			baum0101PreOrder += this.nutzlast;

			if(smaller != null) {
				baum0101PreOrder += smaller.preOrder();
			}
			
			if(bigger != null) {
				baum0101PreOrder += bigger.preOrder();
			}
			return baum0101PreOrder;
		}
		
		/**
		 * Methode Post-Order, der einen String zurückgibt
		 * smallerern Teilbaum0101 -> größeren Teilbaum0101 -> Wurzel
		 * @return baum0101PostOrder
		 */
		private String postOrder() {
			String baum0101PostOrder = "";

			if(smaller != null) {
				baum0101PostOrder += smaller.postOrder();
			}
			
			if(bigger != null) {
				baum0101PostOrder += bigger.postOrder();
			}
			
			
			baum0101PostOrder += this.nutzlast;
			return baum0101PostOrder;

		}
		
		/**
		 * Es soll der Node mit der kleinsten Nutzlast zurückgegeben
		 * @return Node mit der kleinsten Nutzlast
		 */
		private Node getSmallest() {
			if(smaller != null)
				return smaller.getSmallest();
			return this;
		}
		
		/**
		 * Es soll der Node mit der größten Nutzlast zurückgegeben werden
		 * @return getBiggest
		 */
		private Node getBiggest() {
			if(bigger != null) 
				return bigger.getBiggest();
			return this;
		}
		
		/**
		 * Mit dieser Methode soll die Nutzlast eines Nodes zurückgegeben werden
		 * @return Nutzlast
		 */
		private Studi payload() {
			return nutzlast;
		}
		/**
		 * entfernen einen Node aus dem baum0101 ab diesem Node
		 * @param s
		 * @return
		 */
		Node entfernen(Studi s) {
		    //System.out.println("entfernen - s=" + s + " nutzlast = " + nutzlast);
		    
		    int vergleich = s.compareTo(nutzlast); // Fall: vergleich == 0 -> this ist der zeK, this soll entfernt werden
		    if(vergleich == 0) {
		        //System.out.println("entfernen - Diesen Node entfernen");
		        Node neu = this.entfernenMitFallunterscheidung();
		        return neu;
		    } 
		    else {// Hier: this ist nicht der zlk -> weiter suchen
		          // Fall vergleich < 0: this.nutzlast ist smaller als s
		       
				if(vergleich < 0) {
					if(smaller != null) {
						//System.out.println("entfernen - Node aus smalleren Teilbaum entfernen"); 
						smaller = smaller.entfernen(s);
		                return this; 
		            }
					else {
		                return this;
		            }
		        } 
				else {
		        // Fall vergleich > 0: this.nutzlast ist größer als s
					if(bigger != null) { 
						//System.out.println("entfernen - Node aus größeren Teilbaum entfernen");
						bigger = bigger.entfernen(s);
						return this; 
		            } 
					else {
		                return this;
					} 
		        }
		    }
		}
		
		/**
		* Genau dieser Node this wird aus dem baum0101 entfernt.
		*
		* Es wird jetzt nach den bekannten 3 Fällen unterschieden : 0,1,2 Nachfolger von this
		*
		* Nach dem Löschen von this wird an an die aufrufende Methode
		* der anstelle von this zu referenzierende Ersatz-Node zurückgegeben.
		*
		* @param s der Node mit der Nutzlast s wird gelöscht
		* @return Ersatz-Node, der nach dem Löschen anstelle von this referenziert werden soll
		*/
		Node entfernenMitFallunterscheidung() {
		    //Fall 0: kein Nachfolger
		    if(this.smaller == null && this.bigger == null) {
		        //System.out.println("entfernenMitFallunterscheidung - Blatt entfernen");
		        return null;
		    }
		    
		    //Fall 1a: Nur ein Nachfolger - smallerer Teilbaum
		    if(this.smaller != null && this.bigger == null) {
		    	//System.out.println("entfernenMitFallunterscheidung - durch smalleren Nachfolger ersetzen");   	
		    	return this.smaller;
		    }
		    
		    //Fall 1b: Nur ein Nachfolger - biggerer Teilbaum
		    if(this.smaller == null && this.bigger != null) {
		    	//System.out.println("entfernenMitFallunterscheidung - durch biggeren Nachfolger ersetzen"); 
		    	return this.bigger;
		    }
		    
		    //Fall 2: beide Nachfolger existieren
			
			    Node kleinster = bigger.getSmallest();
			    //System.out.println("entfernenMitFallunterscheidung - 2 Nachfolger ");
			    //System.out.println("  - ersetzen durch größeren Nachfolger " +  kleinster.nutzlast);
			   
			    Node weg = entfernen(kleinster.nutzlast);
			    kleinster.smaller = this.smaller;
			    kleinster.bigger= this.bigger;
			  
			    return kleinster;
			
		}
	}
}	
