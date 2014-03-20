public class Node{
    private String data;
    private Node next;

    public Node (String s){
	data = s;
    }
    public void setData (String s){
	data = s;
    }
    public String getData(){
	return data;
    }
    public void setNext (Node n){
	next = n;
    }
    public Node getNext(){
	return next;
    }
    public String toString(){
	return "Data: " + data;// + " Next: " + next;
    }

    public static void main(String[] args){
	Node n1 = new Node("Tommy");
	Node n2 = new Node("Sammy");
	n2.setNext(new Node("Clyde"));
	//n1.setNext(n2.getNext()); //cut n2 out of the list
	System.out.println(n1 + "\n" + n2);
	

    }

}