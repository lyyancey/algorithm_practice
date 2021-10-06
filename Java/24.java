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
class Problem24{
    public ListNode swapPairs(ListNode head){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur = head, next = head;
        while(pre.next!=null && pre.next.next!=null){
            next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            pre = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}