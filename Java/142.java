class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
class Problem142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast=head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle0(ListNode head) {
        ListNode slow = head, fast=head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast!=null&&fast.next!=null){
            slow = head;
            while(slow!=fast){
                slow = slow.next;
                fast=fast.next;
            }
                return slow;
        }
        return null;
    }
}
