import java.util.PriorityQueue;
class Problem23{
    public ListNode mergeLists(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(), p = dummy;
        PriorityQueue<ListNode> pd = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for(ListNode head : lists){
            if(head != null){
                pd.add(head);
            }
        }
        while(!pd.isEmpty()){
            ListNode node = pd.poll();
            p.next = node;
            if(node.next!=null){
                pd.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
