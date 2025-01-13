package praktikum02;



public class DoliStudi implements java.lang.Iterable{
	
	 public static void main(String[] args) {
		 DoliStudi liste = new DoliStudi();
		 
		 java.util.Iterator it = liste.iterator();
		 
		 System.out.println("Leere Liste iterieren::");
		 while(it.hasNext()) {
			 System.out.println("#" + it.next().toString());
		 }

		 liste.insertInOrder(new Studi("studi1", 1));
		 liste.insertInOrder(new Studi("studi2", 2));
		 liste.insertInOrder(new Studi("studi3", 3));
		 
		 System.out.println("Iterieren mit for-each-Schleife::");
		 for(Object o : liste) {
			 System.out.println("--" + o.toString());
		 }

		 System.out.println("Iterieren mit while-Schleife::");
		 java.util.Iterator it1 = liste.iterator();

		 while(it1.hasNext()) {
			 System.out.println("#" + it1.next().toString());
		 }
		 
		 System.out.println("Aufgabe 4::");
		 System.out.println(liste.toString());
		 
		 
		 DoliStudi listeA = new DoliStudi();
		 listeA.insertInOrder(new Studi("A_E1",1));
		 listeA.insertInOrder(new Studi("A_E2",2));
		 listeA.insertInOrder(new Studi("A_E3",2));

		 DoliStudi listeB = new DoliStudi();
		 listeB.insertInOrder(new Studi("B_E1",1));
		 listeB.insertInOrder(new Studi("B_E2",2));
		 listeB.insertInOrder(new Studi("B_E3",2));
		 
		 java.util.Iterator it01 = listeA.iterator();
		 java.util.Iterator it02 = listeB.iterator();

		 System.out.println("Zugriff auf Zwei Listen");
		 while(it01.hasNext() || it02.hasNext()) {
			 if(it01.hasNext()) {
			 System.out.println("ListeA: " + it01.next().toString());
			 }
			 if(it02.hasNext()) {
			 System.out.println("ListeB: " + it02.next().toString());
			 }
		 }
		 
	}// ende main 
	 
	private Node first, last;
	 /**
	  * Konstruktor für Erzeugen einer leeren List
	  */
	public DoliStudi(){
		first = null;
		last = null;
	}
	
	/**
	 * Knoten liste als String ausgeben
	 * @param node
	 * @return String Ausgabe
	 */
    private String nodesToString(Node node) {
        if (node == null) {
            return "";
        } else if (node.next == null) {
            return node.toString();
        } else {
            return node.toString() + "; " + nodesToString(node.next);
        }
    }
	
	/**
	 * String Ausgabe von Node
	 */
    
    public String toString() {
    	String ausgabe= "[";
    	java.util.Iterator it = this.iterator();
    	while(it.hasNext()) {
    		ausgabe = ausgabe + it.next().toString() +"; ";
    	}
        return ausgabe + "]";
    }
    
    /*
    //TOString mit for-Schleife
    public String toString() {
    	String ausgabe= "[";
    	for(Object o : this) {
			 ausgabe = ausgabe + o.toString() + ", ";
		 }
        return ausgabe + "]";
    }
    */
    
    /*
    @Override
    public String toString() {
    	String ausgabe= "[";
    	for(Object o : this ){
    		ausgabe = ausgabe + o.toString() + "; ";
    	}
        return ausgabe + "]";
    }
	*/
    
    /**
     * das erste Element der Liste aufrufen
     * und die IVen first und last aktualisieren
     * @param studi wird eingefügt
     */
    public void insert(Studi studi) {
        Node newNode = new Node(studi); // erstellt einen neuen Knoten mit dem gegebenen Studi-Objekt
        if (first == null) { // Wenn die Liste leer ist
            first = newNode;
            last = newNode;
        } else {
            newNode.insert(first); // Fügt den neuen Knoten vor dem ersten Knoten ein
            first = newNode; // Setzt den neuen Knoten als das erste Element der Liste
        }
    }
    
    /**
     * Studi objekt anhängen 
     * @param studi wird angehängt
     */
    public void append(Studi studi) {
       Node newNode = new Node(studi); // einen neuen Knoten mit dem gegebenen Studi-Objekt erstellen
       if (first == null) { // Wenn die Liste leer ist
         first = newNode;
         last = newNode;
       } else {
         last.append(newNode); // den neuen Knoten am Ende der Liste anhängen
         last = newNode; // den neuen Knoten als das letzte Element der Liste setzen
       }
     }
    
    /**
     * erste node aktualisieren
     * @param alt alte node
     * @param neu neue node
     */
    public void updateFirst(Node alt, Node neu) {
    	if(alt == first) {
    		first = neu;
    	}
    }
    
    /**
     * letzte node aktualisieren
     * @param alt alte node
     * @param neu neue node
     */
    public void updateLast(Node alt, Node neu) {
    	if(alt == last) {
    		last = neu;
    	}
    }
    
    /**
     * Studi objekt in der Liste sortiert einfügen
     * @param studi, übergebene Studi objekt
     */
    public void insertInOrder(Studi studi) {
    	if(first == null) {
    		first = new Node(studi);
    		last = first;
    	}
    	else {
    		first.insertInOrder(new Node(studi));
    	}
    }
    
    /**
     * methode gibt zurück ob ein studi objekt in der liste enthalten ist
     * @param s gesuchte studi objekt
     * @return obekt enthalten oder nicht
     */
    public boolean enthalten(Studi s) {
    	boolean gefunden = false;
    	if(first != null) {
    		if(first.nodeOf(s) != null) {
    			gefunden = true;
    		}
    	}
    	return gefunden;
    }
    
    /**
     * Knoten aus der Liste löschen
     * @param s, studi obejkt was gelöscht wird
     */
    public void remove(Studi s) {
    	Node nodeToRemove;
    	if(first != null) {
    		nodeToRemove = first.nodeOf(s);
	    	if(nodeToRemove != null) {
	    		nodeToRemove.remove();
	    	}
    	}
    }


	public DoliIterator iterator() {
		DoliIterator dit = new DoliIterator(first);
		return dit;
	}


   
	private class Node{
		
		//instanzvariablen //Verkettung
		private Node next, prev;
		
		//Nutzlast
		private Studi nutzlast;
		
		
		/**
		 * Konstruktor 
		 * @param ds, der in einer Liste verkettet werden soll
		 */
		public Node(Studi s) {
			next = null;
			prev = null;
			nutzlast = s;
		}
		
		/**
		 * String Ausgabe
		 */
		public String toString() {
			return nutzlast.toString();
		}
		
		/**
		 * neuen Knoten vor this einfügen
		 * @param newNode, wird eingefügt
		 */
		public void insert(Node newNode) {
			updateFirst(this, newNode); 
			newNode.next = this;
		     newNode.prev = this.prev;
		     if (this.prev != null) {
		    	 this.prev.next=newNode;  
		     }
		     this.prev = newNode;
		}
		
		/**
		 * Knoten an this anhängen
		 * wenn this einen Nachfolfger hat, wird newNode zwischen this und seinen Nachfolger angehängt
		 * @param newNode, der an this angehängt
		 */
		public void append(Node newNode) {
			updateLast(this, newNode); 
			newNode.next = this.next;
			 if(this.next!= null) {
			     this.next.prev = newNode; 
		     } 
			this.next = newNode;
		     newNode.prev=this;
		    
		 }
		
		/**
		 * Knoten sortiert in die Liste einfügen
		 * @param neu node wird eingefügt
		 */
		public void insertInOrder(Node neu) {
			
			if(this.nutzlast.compareTo(neu.nutzlast)< 0) {				
				if(this.next != null) {
					this.next.insertInOrder(neu);
				}
				else {
					this.append(neu);
				}					
			}
			
			if(this.nutzlast.compareTo(neu.nutzlast)> 0) {
				this.insert(neu);
			}
		}
		
		/**
		 * Knotten aus der Liste suchen
		 * @param s studi objekt wird gegeben
		 * @return node gesuchte node zurückgeben
		 */
		private Node nodeOf(Studi s) {
			Node n = this;
			while(n!=null){
				if (n.nutzlast.compareTo(s)==0) {
					return n;
				}
				else {
					n = n.next;
				}
			}
			return null;
		}
		
		/**
		 * Knoten aus der Liste löschen
		 */
		private void remove() {
			if (this.prev != null) {
				this.prev.next = this.next;
			}
			else {
				updateFirst(this, this.next);
			}
			
			if(this.next != null) {
				this.next.prev = this.prev;
			}
			else {
				updateLast(this, this.prev);
			}
		}
		
		/**
		 * nächsten Knoten zurückgeben
		 * @return näschte Knoten
		 */
		private Node nextNode() {
			return this.next;
		}
		
		/**
		 * nutzlast zurückgeben
		 * @return nutzlast
		 */
		private Studi payload(){
			return this.nutzlast;
		}
		
	}
	
	private class DoliIterator implements java.util.Iterator{
		
		//auf den nächsten Knoten zeigen
		private Node naechster;
		
		/**
		 * Constructor , ab start über die Liste iterieren
		 * @param start, ersten Knoten der Liste
		 */
		DoliIterator(Node start){
			this.naechster = start;
		}
		
		/**
		 * methode sagt ob es ein nächstes Elment gibt
		 * @return gibt es element oder nicht
		 */
		public boolean hasNext() {
			return ( naechster != null);
		}
		
		/**
		 * nächsten Nutzlast zurückgeben und weitergehen
		 * @return nutzlast des aktuellen Knotens
		 */
		public Studi next() {
			if(hasNext()) {
				Studi s =naechster.payload();
				naechster = naechster.nextNode();
				return s;
			}
			else {
				return null;
			}
		}
	}


	
}
