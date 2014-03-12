import java.util.*;
public class InterfaceSort{

    public static ArrayList<Comparable> merge(ArrayList<Comparable> list1, ArrayList<Comparable> list2){
	ArrayList<Comparable> ans = new ArrayList<Comparable>();
	int a = 0, b = 0;
	for (int i = 0; i < (list1.size() + list2.size()); i++){
	    if (a >= list1.size()){
		ans.add(list2.get(b));
		b++;
	    }
	    else if (b >= list2.size()){
		ans.add(list1.get(a));
		a++;
	    }
	    else{
		if (list1.get(a).compareTo(list2.get(b)) < 0){
		    ans.add(list1.get(a));
		    a++;
		}
		else{
		    ans.add(list2.get(b));
		    b++;
		}
	    }
	}
	return ans;
    }

    public static ArrayList<Comparable> InterfaceSort (ArrayList<Comparable> list){
	if (list.size() <= 1)
	    return list;
	ArrayList<Comparable> left = new ArrayList<Comparable>();
	ArrayList<Comparable> right = new ArrayList<Comparable>();
	for (int i = 0; i < list.size(); i++){
	    if (i < list.size()/2)
		left.add(list.get(i));
	    else
		right.add(list.get(i));
	}
	return merge(InterfaceSort(left), InterfaceSort(right));
    }

    public static void main(String[]args){
	ArrayList<Comparable> test = new ArrayList<Comparable>();
	test.add("hello");
	test.add("bob");
	test.add("roar");
	test.add("tiger");
	test.add("charlie");
	test.add("zebra");
	test.add("");
	System.out.println(test + "\n" + InterfaceSort(test) + "\n");
	ArrayList<Comparable> test1 = new ArrayList<Comparable>();
	for (int i = 0; i < 20; i++){
	    test1.add(new Integer((int)(Math.random() * 100)));
	}
	System.out.println(test1 + "\n" + InterfaceSort(test1));
    }
}