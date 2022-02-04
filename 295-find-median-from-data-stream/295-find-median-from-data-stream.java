 class MedianFinder {
 	PriorityQueue<Integer> pq1;
 	PriorityQueue<Integer> pq2;
 	/** initialize your data structure here. */
 	public MedianFinder() {
 		pq2 = new PriorityQueue<>();
 		pq1 = new PriorityQueue<>(new Comparator<Integer>(){
 			@Override
 			public int compare(Integer a, Integer b){
 				return b - a;
 			}
 		});
 	}
 	
 	public void addNum(int num) {
 		pq1.offer(num);
 		pq2.offer(pq1.poll());
 		if(pq1.size() < pq2.size())
 			pq1.offer(pq2.poll());
 	}
 	
 	public double findMedian() {
 		if(pq1.size() == pq2.size()){
 			return (double)(pq1.peek() + pq2.peek()) / 2;
 		}else{
 			return (double) pq1.peek();
 		}
 	}
 }

 /**
  * Your MedianFinder object will be instantiated and called as such:
  * MedianFinder obj = new MedianFinder();
  * obj.addNum(num);
  * double param_2 = obj.findMedian();
  */