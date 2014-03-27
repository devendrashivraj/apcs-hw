import java.util.*;
import java.io.*;
public class MyLLIterator<E> implements Iterator<E>{
    private Node current;
    
    public MyLLIterator(Node head){
	current = head;
    }
    public boolean hasNext(){
	return (current.getNext() != null);
    }

    public E next(){
	if (hasNext()){
	    current = current.getNext();
	    return (E)current;
	}
	return null;
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
