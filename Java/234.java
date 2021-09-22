class Problem234{
    ListNode left;
    public boolean isPalindrome(ListNode head){
        left = head;
        return traverse(head);
    }
    private boolean traverse(ListNode right){
        if(right == null) return true;
        boolean res = traverse(right.next);
        res = res&&(right.val == left.val);
        left = left.next;
        return res;
    }
    public boolean isPalindrome1(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        ListNode right = reverse(slow);
        ListNode left = head;
        while(right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode cur = head, nxt = head, pre = null;
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
