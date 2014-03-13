import java.util.*;
public class QuickSort{

    public static Integer[] combine (Integer[] L, Integer[] less, int pivot, Integer[] large){
	int i = 0;
	for (; i < less.length; i++){
	    L[i] = less[i];
	}
	L[i] = new Integer (pivot);
	for (i = 0; i < large.length; i++){
	    L[i + less.length + 1] = large[i];
	}
	return L;
    }

    public static Integer[] quickSort(Integer[] nums){
	if (nums.length <= 1)
	    return nums;
	int p = (int)(Math.random() * nums.length);
	int pivot = nums[p];
	ArrayList<Integer> less = new ArrayList<Integer>();
	ArrayList<Integer> large = new ArrayList<Integer>();
	for (int i = 0; i < nums.length; i++){
	    if (i == p){}
	    else if (nums[i] < pivot)
		less.add(nums[i]);
	    else
		large.add(nums[i]);
	}
	Integer[] left = less.toArray(new Integer[less.size()]);
	Integer[] right = large.toArray(new Integer[large.size()]);
	left = quickSort(left);
	right = quickSort(right);
	return combine(nums, left, pivot,right);
    }
    
    public static void main(String[]args){
	Integer[] test = new Integer[15];
	for (int i = 0; i < test.length; i++){
	    test[i] = (int)(Math.random() * 30);
	}
	System.out.println(Arrays.toString(test) + "\n" + Arrays.toString(quickSort(test)));
    }
}