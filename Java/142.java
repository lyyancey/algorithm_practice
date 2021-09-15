
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
        ListNode p1 = head, p2 = head;
        while(p2 != null && p2.next !=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                break;
            }
        }
        if(p2 == null || p2.next == null){
            return null;
        }
        p1 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
