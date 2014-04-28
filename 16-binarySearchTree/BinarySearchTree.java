public class BinarySearchTree{
    private class Node{
	private int data;
	private Node left,right;
	
	public Node (int n){
	    data = n;
	    left = null;
	    right = null;
	}
	public void setData (int n){
	    data = n;
	}
	public int getData(){
	    return data;
	}
	public void setLeft (Node n){
	    left = n;
	}
	public void setRight (Node n){
	    right = n;
	}
	public Node getLeft(){
	    return left;
	}
	public Node getRight(){
	    return right;
	}
	public String toString(){
	    return getData() + "";
	}
    }

    private Node root;

    public BinarySearchTree(){
	root = null;
    }
    
    public Node search(int x){
	Node p = root;
	while (p != null &&
	       p.getData() != x){
	    if (p.getData() > x)
		p = p.getLeft();
	    else
		p = p.getRight();
	}
	return p;
    }

    public Node search2(int x){
	return RsearchHelp(root, x);
    }

    public Node RsearchHelp(Node p, int x){
	if (p == null ||
	    p.getData() == x)
	    return p;
	else if(x < p.getData())
	    return RsearchHelp(p.getLeft(), x);
	else
	    return RsearchHelp(p.getRight(),x);
    }

    public void insert (int x){
	if (root == null)
	    root = new Node(x);
	else{
	    insertHelp(root, x);
	}
    }

    public void insertHelp(Node p, int x){
	if (x < p.getData()){
	    if (p.getLeft() == null)
		p.setLeft(new Node(x));
	    else
		insertHelp(p.getLeft(), x);
	}
	else if (x > p.getData()){
	    if (p.getRight() == null)
		p.setRight(new Node(x));
	    else
		insertHelp(p.getRight(), x);
	}
    }

    public static void main(String[]args){
	BinarySearchTree BST = new BinarySearchTree();
	BST.insert(1);
	BST.insert(2);
	BST.insert(-1);
	BST.insert(4);
	BST.insert(0);
	System.out.println(BST.search(1) + "\n" + BST.search(0) + "\n" + BST.search(10));
	System.out.println(BST.search2(1) + "\n" + BST.search2(0) + "\n" + BST.search2(10));
	System.out.println("1: " + BST.root.getLeft() + " " + BST.root.getRight());
	System.out.println(BST.root.getRight() + ": " + BST.root.getRight().getLeft() + " " + BST.root.getRight().getRight());
    }

}