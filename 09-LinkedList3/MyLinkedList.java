public class MyLinkedList{
    private Node head;
    private Node tail;
    
    public MyLinkedList(){
	head = new Node("dummy");
	tail = head;
    }

    public void add(String s){
	Node thing = new Node(s);
	tail.setNext(thing);
	tail = thing;
    }
    public String toString(){
	Node tmp = head.getNext();
	String str = "[";
	while (tmp != null){
	    str += tmp.toString() + " ";
	    tmp = tmp.getNext();
	}
	return str + "]";
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
	String data = tmp.getNext().getData();
	thing.setNext(tmp.getNext().getNext());
	tmp.setNext(thing);
	return data;
    }

    public String remove (int i){
	Node tmp = head;
	while (i > 0){
	    tmp = tmp.getNext();
	    i--;
	}
	String data = tmp.getNext().getData();
	tmp.setNext(tmp.getNext().getNext());
	return data;
    }

    public int length(){
	int i = 0;
	Node tmp = head.getNext();
	while (tmp != null){
	    i++;
	    tmp = tmp.getNext();
	}
	return i;	
    }

    public int find (String s){
	int i = 0;
	Node tmp = head.getNext();
	while (!tmp.getData().equals(s)){
	    i++;
	    tmp = tmp.getNext();
	}
	return i;
    }

    public static void main(String[]args){
	MyLinkedList L = new MyLinkedList();
	L.add("A");
	L.add("B");
	L.add("C");
	L.add("D");
	L.add("E");
	System.out.println(L);
	/*L.add(1,"Q");
	  System.out.println(L.set(3,"Q"));
	  System.out.println(L.length());
	  System.out.println(L.remove(0));
	  System.out.println(L.find("A"));
	  System.out.println(L.get(0));
	*/
    }
}
