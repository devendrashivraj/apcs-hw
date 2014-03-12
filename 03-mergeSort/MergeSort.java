import java.util.*;
public class MergeSort{

    public static int[] merge (int[] nums1, int[] nums2){
	int[] ans = new int[nums1.length + nums2.length];
	int a = 0, b = 0;
	for (int i = 0; i < ans.length; i++){
	    if (a >= nums1.length){
		ans[i] = nums2[b];
		b++;
	    }
	    else if (b >= nums2.length){
		ans[i] = nums1[a];
		a++;
	    }
	    else{
		if (nums1[a] < nums2[b]){
		    ans[i] = nums1[a];
		    a++;
		}
		else{
		    ans[i] = nums2[b];
		    b++;
		}
	    }
	}
	return ans;
    }
    public static int[] mergeSort(int[] nums){
	if (nums.length <= 1)
	    return nums;
	int split = nums.length / 2;
	int[] left = new int[split];
	int[] right = new int[nums.length - split];
	for (int i = 0; i < nums.length; i++){
	    if (i < split)
		left[i] = nums[i];
	    else
		right[i-left.length] = nums[i];
	}
	return merge(mergeSort(left), mergeSort(right));
    }

    public static void main(String[]args){
        int[] a = new int[Integer.parseInt(args[1])];
	for (int i = 0; i < a.length; i++){
	    a[i] = (int)(Math.random() * 100);
	}
	long start = System.nanoTime();
	if (Integer.parseInt(args[0]) == 0)
	    Arrays.sort(a);
	else
	    a = mergeSort(a);
	long end = System.nanoTime();
	System.out.println("Run Time: " + (end - start) / (1.0*Math.pow(10,9)) + "s");
    }
}
