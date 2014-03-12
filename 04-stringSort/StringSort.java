import java.util.*;
public class StringSort{

    public static ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2){
	ArrayList<String> ans = new ArrayList<String>();
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

    public static ArrayList<String> stringSort (ArrayList<String> list){
	if (list.size() <= 1)
	    return list;
	ArrayList<String> left = new ArrayList<String>();
	ArrayList<String> right = new ArrayList<String>();
	for (int i = 0; i < list.size(); i++){
	    if (i < list.size()/2)
		left.add(list.get(i));
	    else
		right.add(list.get(i));
	}
	return merge(stringSort(left), stringSort(right));
    }

    public static void main(String[]args){
	ArrayList<String> test = new ArrayList<String>();
	test.add("an");
	test.add("is");	
	test.add("zebra");
	test.add("elephant");
	test.add("bob");	
	test.add("hello ");
	System.out.println(test + "\n" + stringSort(test));
    }
}