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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0, dummy);
        
        int cumSum=0;
        
        while(head != null) {
            cumSum = cumSum + head.val;
            
            if(map.containsKey(cumSum)){
                ListNode start = map.get(cumSum).next;
                int tempSum = cumSum;
                
                while(start!=head) {
                    tempSum = tempSum + start.val;
                    map.remove(tempSum);
                    start = start.next;
                }
                
                map.get(cumSum).next = start.next;
                
            } else {
                map.put(cumSum, head);
            }
            
            head = head.next;
        }
        
        return dummy.next;
        
    }
}