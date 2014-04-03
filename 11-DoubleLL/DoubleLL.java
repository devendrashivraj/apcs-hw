<<<<<<< HEAD
=======
//Devendra Shivraj & Eric Cheang
>>>>>>> a8561bc46882d4e66d8d1e55433d3c264364fa7e
public class DoubleLL<E>{

    private class Node<E>{
	E data;
	Node<E> next,prev;
	public Node (E d){
	    this.data = d;
	}
	public String toString(){
	    return "" + data;
	}
	
	public void setData (E d){
	    data = d;
	}
	public E getData(){
	    return data;
	}
	public void setNext(Node<E> n){
	    next = n;
	}
	public Node<E> getNext(){
	    return next;
	}
	public void setPrev(Node<E> p){
	    prev = p;
	}
	public Node<E> getPrev(){
	    return prev;
	}
    }
    private Node<E> current;
<<<<<<< HEAD
    
    public void insert (E d){
	Node<E> n = new Node<E>(d);
	if(current == null)
	    current = n;
	else{
	    n.next = current;
	    if (current.getPrev() != null)
		current.prev.next = n;
	    n.setPrev(current.getPrev());
	    current = n;
	}
=======
    private int length;
   
    public void insert (E d){
	Node<E> n = new Node<E>(d);
	if(current == null){
	    current = n;
	    return;
	}
	Node<E> thing1 = current,thing2 = current;
	int i = 0;
	while (thing1.getPrev() != null &&
	       i < length){
	    thing1 = thing1.getPrev();
	    i++;
	}
	i = 0;
	while (thing2.getNext() != null &&
	       i < length){
	    thing2 = thing2.getNext();
	    i++;
	}
	thing2.setNext(thing1);
	thing1.setPrev(thing2);
	if(current == null)
	    current = n;
	n.next = current;
	if (current.getPrev() != null)
	    current.prev.next = n;
	n.setPrev(current.getPrev());
	current = n;
	length += 1;
>>>>>>> a8561bc46882d4e66d8d1e55433d3c264364fa7e
    }
    public E getCurrent(){
	return current.getData();
    }
<<<<<<< HEAD
=======
    
    public void delete(){
	//removes the currentNode
	if (current == null)
	    return;
	Node<E> thing = current.getNext();
	current.getPrev().setNext(current.getNext());
	current = thing;
    }

    public int find (String s){
	int  i = 0;
	Node<E> thing = current;
	while (thing.getPrev() != null &&
	       i < length){
	    thing = thing.getPrev();
	    i++;
	}
	i = 0;
	while (thing.getNext() != null &&
	       i < length){
	    if (thing.getData().equals(s))
		return i;
	    thing = thing.getNext();
	    i++;
	}
	return -1;
    }
>>>>>>> a8561bc46882d4e66d8d1e55433d3c264364fa7e

    public void forward(){
	if (current.getNext() != null){
	    current = current.getNext();
	}
    }

    public void back(){
	if (current.getPrev() != null)
	    current = current.getPrev();
    }

    public String toString(){
	if (current == null)
	    return "";
	Node<E> thing = current;
<<<<<<< HEAD
	while (thing.getPrev() != null)
	    thing = thing.getPrev();
	String s = "";
	while (thing != null){
	    s += thing.getData() + " ";
	    thing = thing.getNext();
=======
	int listCounter = 0; 
	while (thing.getPrev() != null &&
	       listCounter < length){
	    thing = thing.getPrev();
	    listCounter++;
	}
    	String s = "";
	listCounter = 0;
	while (thing != null &&
	       listCounter < length){
	    s += thing.getData() + " ";
	    thing = thing.getNext();
	    listCounter++;
>>>>>>> a8561bc46882d4e66d8d1e55433d3c264364fa7e
	}
	return s;
    }

    public static void main(String[] args){
	DoubleLL<String> L  = new DoubleLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("three");
	System.out.println(L);
	System.out.println(L.getCurrent());
	L.forward();
	System.out.println(L.getCurrent());
	L.insert("inserted");
	System.out.println(L);
<<<<<<< HEAD
=======
	System.out.println(L.length);
	System.out.println(L.getCurrent());
	L.delete();
	System.out.println(L);
	System.out.println(L.find("world"));
	System.out.println(L.find("monster"));//should give you -1 (not in the list)
>>>>>>> a8561bc46882d4e66d8d1e55433d3c264364fa7e
    }
}



