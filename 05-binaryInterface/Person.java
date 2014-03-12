import java.util.*;
public class Person implements Comparable{
    private int age;
    private String name;
    
    public Person (int age, String name){
	this.age = age;
	this.name = name;
    }
    
    public int getAge(){
	return age;
    }

    public String getName(){
	return name;
    }

    /* PART A: Compare by Age
    public int compareTo(Object other){
	return this.getAge() - ((Person)(other)).getAge();
    }
    */

    // PART B: Compare by Name
    public int compareTo(Object other){
	return (this.getName()).compareTo(((Person)(other)).getName());
    }

    public String toString(){
	return this.getName() + " - " + this.getAge();
    }
    
    public static void main(String[]args){
	ArrayList<Comparable> test = new ArrayList<Comparable>();
	for (int i = 0; i < 12; i++){
	    test.add(new Person((int)(Math.random() * 20), (char)((int)'a' + (int)((Math.random() * 26))) + ""));
	}
	System.out.println(test + "\n" + InterfaceSort.InterfaceSort(test));
    }
}