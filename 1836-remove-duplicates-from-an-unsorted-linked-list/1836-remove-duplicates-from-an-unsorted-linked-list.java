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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if(head.next ==null) {
            return head;
        }
        
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set0 = new HashSet<>();
        
        ListNode curr = head;
        
        while(curr!=null) {
            if(!set0.contains(curr.val)) {
                set0.add(curr.val);
            } else {
                 set.add(curr.val);
            }
           
            curr = curr.next;
        }
        
        while(head != null && set.contains(head.val) ) {
            head = head.next;
        }
        
        curr = head;
        ListNode next;
        ListNode prev = null;
        
        while(curr!=null && curr.next!=null) {
            next = curr.next;
            while(next != null && set.contains(next.val)){
                next = next.next;
            }
            curr.next = next;
            curr = next;
            

        }
        
        return head;
    }
}