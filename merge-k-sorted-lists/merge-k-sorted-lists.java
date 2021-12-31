/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists==null || lists.length==0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode n: lists) {
            if(n!=null) pq.offer(n);
        }
        
        ListNode dummy = new ListNode(-1);
        
        ListNode curr = dummy;
        
        while(!pq.isEmpty()) {
            ListNode n = pq.poll();
            curr.next = n;
            curr = n;
            
            if(n.next!=null) pq.offer(n.next);
        }
        
        return dummy.next;
    }
}