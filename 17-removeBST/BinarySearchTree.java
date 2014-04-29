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

    public void delete (int x){
	Node p = root;
	while (p.getRight().getData() != x &&
	       p.getLeft().getData() != x){
	    if (p.getData() > x)
		p = p.getLeft();
	    else
		p = p.getRight();
	}
	Node k = p.getRight();
	boolean oren = true;
	if (k != null &&
	    k.getData() != x){
	    k = p.getLeft();
	    oren = false;
	}
	if (k.getRight() == null &&
	    k.getLeft() == null){
	    if (oren)
		p.setRight(null);
	    else 
		p.setLeft(null);
	}
	else if ((k.getRight() == null && k.getLeft() != null) ||
		 (k.getRight() != null && k.getLeft() == null)){
	    if (oren){
		if (k.getRight() == null)
		    p.setRight(k.getLeft());
		else
		    p.setRight(k.getRight());
	    }
	    else{
		if (k.getRight() == null)
		    p.setLeft(k.getLeft());
		else
		    p.setLeft(k.getRight());
	    }
	}
	else{
	    Node d;
	    if (oren)
		d = p.getRight();
	    else
		d = p.getLeft();
	    Node l = d.getLeft();
	    while (l.getRight() != null)
		l = l.getRight();
	    int dat = l.getRight().getData();
	    l.setRight(null);
	    if (oren)
		p.getRight().setData(dat);
	    else
		p.getLeft().setData(dat);
	}
    }

    public static void main(String[]args){
	BinarySearchTree BST = new BinarySearchTree();
	BST.insert(5);
	BST.insert(7);
	BST.insert(2);
	BST.insert(1);
	BST.insert(8);
	BST.insert(6);
	BST.insert(3);
	BST.insert(0);
	System.out.println(BST.search(1) + "\n" + BST.search(0) + "\n" + BST.search(10));
	System.out.println(BST.search2(1) + "\n" + BST.search2(0) + "\n" + BST.search2(10));
	System.out.println("1: " + BST.root.getLeft() + " " + BST.root.getRight());
	System.out.println(BST.root.getRight() + ": " + BST.root.getRight().getLeft() + " " + BST.root.getRight().getRight());
	BST.delete(2);
	System.out.println(BST.root.getRight() + ": " + BST.root.getRight().getLeft() + " " + BST.root.getRight().getRight());
	//System.out.println(BST.root.getRight() + ": " + BST.root.getRight().getLeft() + " " + BST.root.getRight().getRight());
    }

}