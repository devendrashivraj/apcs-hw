import java.util.*;
import java.io.*;

public class TreeHashSpeed{

    public static void main(String[]args){
	HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
	TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();

	long start = System.currentTimeMillis();
	for (int i = 0; i < 2500000; i++){
	    hash.put(new Integer(i), new Integer(4)); 
	}
	long end = System.currentTimeMillis();
	System.out.println("HashMap put(): " + (end-start)/1000.0 + "s");

	start = System.currentTimeMillis();
	for (int i = 0; i < 2500000; i++){
	    tree.put(new Integer(i), new Integer(4)); 
	}
	end = System.currentTimeMillis();
	System.out.println("TreeMap put(): " + (end-start)/1000.0 + "s");

	start = System.currentTimeMillis();
	for (int i = 0; i < 2500000; i++){
	    hash.get(i);
	}
	end = System.currentTimeMillis();
	System.out.println("HashMap get(): " + (end-start)/1000.0 + "s");

	start = System.currentTimeMillis();
	for (int i = 0; i < 2500000; i++){
	    tree.get(i); 
	}
	end = System.currentTimeMillis();
	System.out.println("TreeMap get(): " + (end-start)/1000.0 + "s");
    }
}