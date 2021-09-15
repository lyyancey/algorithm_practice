class Problem19{
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(-1, head);
        ListNode node = findNthFromEnd(dummy, n+1);
        node.next = node.next.next;
        return dummy.next;
    }
    private ListNode findNthFromEnd(ListNode dummy, int i) {
        ListNode p1 = dummy, p2 = dummy;
        while(i>0){
            p1 = p1.next;
            i--;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
