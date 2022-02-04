 class MedianFinder {
 	static PriorityQueue<Integer> maxHeap;
 	static PriorityQueue<Integer> minHeap;
 	/** initialize your data structure here. */
 	public MedianFinder() {
 		minHeap = new PriorityQueue<>();
 		maxHeap = new PriorityQueue<>((a,b)->b-a);
 	}
 	
 	public void addNum(int num) {
        if(maxHeap.size()==0 || maxHeap.peek()>num) 
            {maxHeap.add(num);}
        else 
            {minHeap.add(num);}
        
        rebalance();
 	}
 	
 	public double findMedian() {
         if(minHeap.size()==maxHeap.size()) 
           return ((double)minHeap.peek() + (double)maxHeap.peek())/2;
        else if(minHeap.size()>maxHeap.size())
            return (double)minHeap.peek();
        else
            return (double)maxHeap.peek();
 	}
     
         public static void rebalance() {
        
        if(maxHeap.size()-minHeap.size()==2) 
            {minHeap.add(maxHeap.remove());}
        else if (minHeap.size()-maxHeap.size()==2) 
            {maxHeap.add(minHeap.remove());}
        
    }
 }

 /**
  * Your MedianFinder object will be instantiated and called as such:
  * MedianFinder obj = new MedianFinder();
  * obj.addNum(num);
  * double param_2 = obj.findMedian();
  */