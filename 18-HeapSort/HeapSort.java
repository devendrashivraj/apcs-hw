import java.util.*;
public class HeapSort{
    
    public static void swap (int[] nums, int a, int b){
	int temp = nums[a];
	nums[a] = nums[b];
	nums[b] = temp;
    }

    public static void heapify (int[] nums){
	for (int i = nums.length/2; i >= 0; i--){
	    allocate(nums,i);
	}
    }

    public static void allocate(int[] nums, int i){
	if (2*i+1 == nums.length-1){
	    if (nums[2*i+1] > nums[i])
		swap(nums,i,2*i+1);
	}
	else if (2*i+2 < nums.length &&
		 nums[2*i+1] > nums[i] &&
		 nums[2*i+1] > nums[2*i+2]){
	    swap(nums,i,2*i+1);
	    allocate(nums,2*i+1);
	}
	else if (2*i+2 < nums.length &&
		 nums[2*i+2] > nums[i] && 
		 nums[2*i+2] > nums[2*i+1]){
	    swap(nums,i,2*i+2);
	    allocate(nums,2*i+2);
	}
    }

    public static void removeMax (int[] nums, int end){
	swap(nums, 0, end);
	end -= 1;
	int i = 0;
	while ((2*i+1 < end || 2*i+2 < end) &&
	       (nums[i] < nums[2*i+1] || nums[i] < nums[2*i+2])){
	    if (nums[2*i+1] < nums[2*i+2]){
		swap(nums, i, 2*i+2);
		i = 2*i+2;
	    }
	    else{
		swap(nums,i,2*i+1);
		i  = 2*i+1;
	    }
	}
    }

    public static void sort(int[] nums){
	heapify(nums);
	for (int i = nums.length-1; i >= 0; i--){
	    removeMax(nums, i);
	}
    }
}