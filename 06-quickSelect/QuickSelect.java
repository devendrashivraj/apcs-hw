import java.util.*;
public class QuickSelect{
    
    public static int quickSelect(int[] nums, int k, int low, int high){
	if (low >= high)
	    return nums[low];
	int p = (int)(Math.random() * (high - low)) + low;
	int[] cop = new int[nums.length];
	int b = 0, e = nums.length-1;
	for (int i = 0; i < nums.length; i++){
	    if (i == p){}
	    else if (nums[i] < nums[p]){
		cop[b] = nums[i];
		b++;
	    }
	    else{
		cop[e] = nums[i];
		e--;
	    }
	}
	cop[b] = nums[p];
	nums = Arrays.copyOf(cop,cop.length);
	if (k - 1 == b)
	    return nums[b];
	else if (k - 1 < b)
	    return quickSelect(nums,k,low,b-1);
	else
	    return quickSelect(nums,k,b+1,high);
    }

    public static void main(String[]args){
	int[] nums = new int[15];
	for (int i = 0; i < nums.length; i++){
	    nums[i] = (int)(Math.random() * 30);
	}
	int k =  (int)(Math.random() * 15);
	System.out.println(Arrays.toString(nums) + "\n" + k + " smallest number: " + 
			   quickSelect(nums,k,0,nums.length-1));
    }
}