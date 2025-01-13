package praktikum09;

import java.util.Iterator;

//Fall A,E
public class GenCompTree<T extends Comparable<T>>  implements Iterable<T>{
	Node wurzel;
	
	/**
	 * Nodes in baum0101 einfügen
	 * @param neu, nutzlast in den baum0101 eingefügt wird
	 *///Fall B
	public void add(T neu) {
		if(wurzel == null) {
			this.wurzel = new Node(neu);
		}
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
	 *///Fall B
	public boolean contains (T s) {
		
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
	 *///Fall C
	public T getSmallest() {
		if(wurzel != null)
			return wurzel.getSmallest().payload();
		return null;
	}
	
	
	/**
	 * Es soll der Node mit der größten Nutzlast zurückgegeben werden
	 * @return getBiggest
	 *///Fall C
	public T getBiggest() {
		if(wurzel != null)
			return wurzel.getBiggest().payload();
		return null;
	}
	
	/** Entfernen eines Nodes aus dem baum0101
	 * @param s Der Node mit der Nutzlast s wird aus dem baum0101 entfernt
	*///Fall B
	void entfernen(T s) {
	    if(wurzel != null)
	    	wurzel = wurzel.entfernen(s); 
	}
	//Fall F
	public Iterator<T> iterator(){
		Iterator<T> iterator = new GenIterator(this.wurzel);
		return iterator;
	}
	
	/**
	 * Gibt den größeren Teilbaum mit Hilfe eines einfachen Iterators aus
	 * @return String, mit dem Inhalt des Baumes
	 */
	public void baumAusgeben() {
		//Fall F
		Iterator<T> iter = this.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next().toString()+ "\n"); //Object zurückgeben, Iterator ist allgemein und hat keinen Typ
		}
	}
	
	private class Node{
		T nutzlast; //FallD
		
		Node  smaller, bigger;
		
		/**
		 * Constructor
		 * @param s Nutzlast von Node
		 *///Fall B
		Node(T s){
			nutzlast=s;
		}
		
		public String toString() {
			return nutzlast.toString();
		}
		
		/**
		 * nutzlast ab this einfügen
		 * @param neu, neue T nutzlast einfügen
		 *///Fall B
		private void add(T neu) {
			int ergebnis = neu.compareTo(nutzlast);//Fall D
			
			if(ergebnis == 0)
				return;
			
			if(ergebnis < 0) {
				if(smaller == null) {
					this.smaller = new Node(neu);
				} 
				else {
					smaller.add(neu);
				}
			}
			
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
		 *///Fall B
		private boolean contains(T s) {
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
		 *///Fall C
		private T payload() {
			return nutzlast;
		}
		/**
		 * entfernen einen Node aus dem baum0101 ab diesem Node
		 * @param s
		 * @return
		 *///Fall B
		Node entfernen(T s) {
		    
		    int vergleich = s.compareTo(nutzlast); //Fall H
		    if(vergleich == 0) {
		        Node neu = this.entfernenMitFallunterscheidung();
		        return neu;
		    } 
		    else {
				if(vergleich < 0) {
					if(smaller != null) {
						smaller = smaller.entfernen(s);
		                return this; 
		            }
					else {
		                return this;
		            }
		        } 
				else {
					if(bigger != null) { 
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
		    if(this.smaller == null && this.bigger == null) {
		        return null;
		    }
		    
		    if(this.smaller != null && this.bigger == null) {
		    	return this.smaller;
		    }
		    
		    if(this.smaller == null && this.bigger != null) {
		    	return this.bigger;
		    }
		    				
			    Node kleinster = bigger.getSmallest();
			 
			    Node weg = entfernen(kleinster.nutzlast);
			    kleinster.smaller = this.smaller;
			    kleinster.bigger= this.bigger;
			  
			    return kleinster;	
		}
		
		public Node getBigger() {
			return this.bigger;
		}
	}

	//Fall A
	private class GenIterator implements java.util.Iterator<T>{
		Node currentNode;
		
		GenIterator(Node wurzel){
			this.currentNode = wurzel;
		}
		
		/**
		 *Prüft,ob es einen nächst größeren Knoten gibt
		 *@return boolean- true wird zurück gegebn, wenn es einen weiteren Knoten mit next() gibt,
		 *false wenn es keinen Knoten mehr gibt
		 */
		public boolean hasNext() {
			return currentNode != null;
		}
		
		/**
		 * Es wird der nächst größere Knoten zurückgegeben
		 * @return Object nächst größster Knoten oder null, wenn kein Knoten vorhanden ist
		 *///Fall C
		public T next() {
			//einen Knoten weiter gehen
			if(hasNext()) {
				//Payload speichern
				Node temp = currentNode;
				//Hier wird in den größeren Teilbaum gegangen
				currentNode = currentNode.getBigger();
				return temp.payload();
			}
			//default
			return null;
		}
	}
}
