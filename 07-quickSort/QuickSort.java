import java.util.*;
public class QuickSort{

    public static void swap(int[] nums, int i1, int i2){
	int temp = nums[i1];
	nums[i1] = nums[i2];
	nums[i2] = temp;
    }

    public static void quickSortHelp (int[] nums, int low, int high){
	if (low >= high)
	    return;
	int p = low + (int)(Math.random() * (high+1-low));
	int pivot = nums[p];
	swap(nums, p, high);
	int n = low;
	for (int i = low; i < high; i++){
	    if (nums[i] <= pivot){
		swap(nums, n, i);
		n++;
	    }
	}
	swap(nums, n, high);
	quickSortHelp(nums, low, n-1);
	quickSortHelp(nums, n+1, high);
    }
    
    public static void quickSort(int[] nums){
	quickSortHelp(nums, 0, nums.length-1);
    }
    public static void main(String[]args){
	int[] test = new int[15];
	for (int i = 0; i < test.length; i++){
	    test[i] = (int)(Math.random() * 20);
	}
	System.out.println(Arrays.toString(test));
	quickSort(test);
	System.out.println(Arrays.toString(test));
    }
}