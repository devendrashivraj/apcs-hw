1) Tree Map: a method for displaying hierarchical data by using nested rectangles. Makes efficient use of space. It stores two objects that represent a key and value. Allows for duplicate objects.

   Tree Set: uses a tree structure such as a red-black tree. All of its elements are sorted and its methods all have O(log n) efficiency. It stores only one object. Does not allow duplicate objects.

   Hash Map: a data structure that uses an associative array to map keys to values. (uses a hash function to compute an index in the array). Its methods will have O(1) efficiency.

   Hash Set: uses a hash table. Its elements are not sorted, and its methods all have O(1) efficiency.

2) Speed Test: Hash Map: Average - O(1) constant-time
   	       	    	 Worst Case - O(n) linear-time
	       Tree Map: O(log n) logarithmic-time

3) Yes Java has something similar to a built-in heap called a priority queue. It functions like a heap because it has a natural ordering to it. (for example  a priority queue has its head as the lest element with respect to the specified ordering).
	       
