import java.util.*;
public class RunningMedian{
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public RunningMedian(){
	minHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
		public int compare (Integer a, Integer b){
		    return (new Integer(a.intValue()*-1)).compareTo(b);
		}
	    });
    	maxHeap = new PriorityQueue<Integer>();
    }
    
    public int size(){
	return minHeap.size() + maxHeap.size();
    }

    public void add (int x){
	if (minHeap.size() == 0 &&
	    maxHeap.size() == 0)
	    minHeap.add(x);
	else{
	    if (x < findMedian()){
		minHeap.add(x);
		if (minHeap.size() - maxHeap.size() >= 2)
		    maxHeap.add(minHeap.poll());
	    }
	    else if (x == findMedian()){
		if (minHeap.size() > maxHeap.size())
		    maxHeap.add(x);
		else 
		    minHeap.add(x);
	    }
	    else{
		maxHeap.add(x);
		if (maxHeap.size() - minHeap.size() >= 2)
		    minHeap.add(maxHeap.poll());
	    }
	}
    }

    public double findMedian(){
	if (minHeap.size() > maxHeap.size())
	    return minHeap.peek();
	else if (maxHeap.size() > minHeap.size())
	    return maxHeap.peek();
	else
	    return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public double removeMedian(){
	if (minHeap.size() > maxHeap.size())
	    return minHeap.poll();
	else if (maxHeap.size() > minHeap.size())
	    return maxHeap.poll();
	else
	    return (minHeap.poll() + maxHeap.poll()) / 2.0;
    }
}