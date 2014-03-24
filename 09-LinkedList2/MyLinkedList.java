public class MyLinkedList{
    private Node head;
    
    public MyLinkedList(){
	head = new Node("dummy");
    }

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(head.getNext()); //adds nodes to the start of the list
	head.setNext(tmp);
    }

    public String toString(){
	Node tmp = head.getNext();
	String str = "[";
	while (true){
 	    if (tmp == null)
		return str + "]";
	    str += tmp.toString() + " ";
	    tmp = tmp.getNext();
	}
    }
    public void add (int i, String s){
	Node thing = new Node(s);
	Node tmp = head;
	while (i > 0){
	    tmp = tmp.getNext();
	    i--;
	}
	thing.setNext(tmp.getNext());
	tmp.setNext(thing);
    }

    public String get(int i){
	Node tmp = head.getNext();
	while (i > 0){
	    tmp = tmp.getNext();
	    i--;
	}
	return tmp.getData();
    }
    
    public String set (int i, String s){
	Node thing = new Node(s);
	Node tmp = head;
	while (i > 0){
	    tmp = tmp.getNext();
	    i--;
	}
	Node tmp2 = tmp.getNext();
	thing.setNext(tmp.getNext().getNext());
	tmp.setNext(thing);
	return tmp2.getData();
    }

    public String remove (int i){
	Node tmp = head;
	while (i > 0){
	    tmp = tmp.getNext();
	    i--;
	}
	Node tmp2 = tmp.getNext();
	tmp.setNext(tmp.getNext().getNext());
	return tmp2.getData();
    }

    public int length(){
	int i = 0;
	Node tmp = head.getNext();
	while(true){
	    if (tmp == null)
		return i;
	    i++;
	    tmp = tmp.getNext();
	}
    }

    public int find (String s){
	int i = 0;
	Node tmp = head.getNext();
	while (true){
	    if (tmp.getData().equals(s))
		return i;
	    i++;
	    tmp = tmp.getNext();
	}
    }

    public static void main(String[]args){
	MyLinkedList L = new MyLinkedList();
	L.add("E");
	L.add("D");
	L.add("C");
	L.add("B");
	L.add("A");
	System.out.println(L);
	/*L.add(0,"Q");
	  System.out.println(L.set(0,"Q"));
	  System.out.println(L.remove(0));
	  System.out.println(L.length());
	  System.out.println(L.find("A"));
	  System.out.println(L.get(0));
	*/
    }
}