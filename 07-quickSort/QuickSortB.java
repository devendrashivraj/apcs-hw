import java.util.*;
public class QuickSort{

    public static void swap(int[] nums, int i1, int i2){
	int temp = nums[i1];
	nums[i1] = nums[i2];
	nums[i2] = temp;
    }

    public static int findPivot(int[] nums, int a, int b, int c){
	if (nums[a] > nums[b]){
	    int temp = a;
	    a = b;
	    b = temp;
	}
	if (nums[a] > nums[c]){
	    int temp = a;
	    a = c;
	    c = temp;
	}
	if (nums[b] > nums[c]){
	    int temp = b;
	    b = c;
	    c = temp;
	}
	return b;
    }

    public static void quickSortHelp (int[] nums, int low, int high){
	if (low >= high)
	    return;
	int p = findPivot(nums, low, (low+high)/2, high);
	int pivot = nums[p];
	swap(nums, p, high);
	int n = low;
	for (int i = low; i < high; i++){
	    if (nums[i] < pivot){
		swap(nums, n, i);
		n++;
	    }
	}
	int k = n + 1;
	for (int i = k; i < high; i++){
	    if (nums[i] == pivot){
		swap(nums,k,i);
		k++;
	    }
	}
	swap(nums, n, high);
	quickSortHelp(nums, low, n-1);
	quickSortHelp(nums, k, high);
    }
    
    public static void quickSort(int[] nums){
	quickSortHelp(nums, 0, nums.length-1);
    }
    public static void main(String[]args){
	int[] test = new int[12];
	for (int i = 0; i < test.length; i++){
	    test[i] = (int)(Math.random() * 20);
	}
	System.out.println(Arrays.toString(test));
	quickSort(test);
	System.out.println(Arrays.toString(test));
    }
}