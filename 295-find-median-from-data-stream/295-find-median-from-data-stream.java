 class MedianFinder {
 	static PriorityQueue<Integer> maxHeap;
 	static PriorityQueue<Integer> minHeap;
 	/** initialize your data structure here. */
 	public MedianFinder() {
 		minHeap = new PriorityQueue<>();
 		maxHeap = new PriorityQueue<>((a,b)->b-a);
 	}
 	
 	public void addNum(int num) {
 		// pq1.offer(num);
 		// pq2.offer(pq1.poll());
 		// if(pq1.size() < pq2.size())
 		// 	pq1.offer(pq2.poll());
        if(maxHeap.size()==0 || maxHeap.peek()>num) maxHeap.add(num);
        else minHeap.add(num);
        
        rebalance();
 	}
 	
 	public double findMedian() {
 		// if(pq1.size() == pq2.size()){
 		// 	return (double)(pq1.peek() + pq2.peek()) / 2;
 		// }else{
 		// 	return (double) pq1.peek();
 		// }
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