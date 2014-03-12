import java.util.Arrays;
public class BinarySearch{

    public static int rbsearch (int[] list, int n){
	if (list.length == 0)
	    return -1;
	return rbsearchHelper(list, n, 0);
    }

    public static int rbsearchHelper (int[] list, int n, int p){
	if (list.length == 1){
	    if (n != list[0])
		return -1;
	    else
		return p;
	}
	int mid = list.length/2;
	if (list[mid] == n)
	    return mid + p;
	else{
	    if (list[mid] < n){
		int[] upper = new int[list.length - mid - 1];
		for (int i = 0; i < upper.length; i++){
		    upper[i] = list[i + mid + 1];
		}
		return rbsearchHelper(upper, n, p + mid + 1);
	    }
	    else{
		int[] lower = new int[mid];
		for (int i = 0; i < lower.length; i++){
		    lower[i] = list[i];
		}
		return rbsearchHelper(lower, n, p);
	    }
	}
    }

    public static int ibsearch (int[] list, int n){
	if (list.length == 0)
	    return -1;
	int p = 0;
	do{
	    if (list.length == 1){
		if (n == list[0])
		    return p;
		else
		    return -1;
	    }
	    int mid = list.length / 2;
	    if (list[mid] == n)
		return mid + p;
	    else if(list[mid] < n){
		int[] upper = new int[list.length - mid - 1];
		for (int i = 0; i < upper.length; i++){
		    upper[i] = list[i + mid + 1];
		}
		list = upper;
		p += mid + 1;
	    }
	    else{
		int[] lower = new int[mid];
		for (int i = 0; i < lower.length; i++){
		    lower[i] = list[i];
		}
		list = lower;
	    }
	}    
	while (list.length >= 1);
	return p;
    }

    public static void main(String[]args){
	int[] test = new int[20];
	for (int i = 0; i < test.length; i++){
	    test[i] = (int)(Math.random() * 100);
	}
	Arrays.sort(test);
	int place = (int)(Math.random() * test.length);
	System.out.println(Arrays.toString(test) + "\nfind: " + test[place] + "\nrecursive: " + rbsearch(test,test[place]) + 
			   " iterative: " + ibsearch(test,test[place]));
    }
}