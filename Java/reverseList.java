class reverseList {
    //递归反转整个链表
    ListNode recurReverseNode(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode last = recurReverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //递归反转链表前n个节点
    ListNode successor;
    ListNode recurReverseN(ListNode head, int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = recurReverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    //递归反转 m - n之间的链表
    ListNode recurReverseBetweem(ListNode head, int m, int n){
        if(m == 1){
            return recurReverseN(head, n);
        }
        head.next = recurReverseBetweem(head.next, m-1, n-1);
        return head;
    }

    /****************************************************************************/
    //循环反转链表全部节点
    ListNode loopReverseList(ListNode head){
        ListNode pre = null, cur = head, nxt = head;
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    //循环反转链表
    ListNode loopReverseNList(ListNode a, ListNode b){
        ListNode pre = null,cur = a, nxt = a;
        while(cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    //k个一组反转链表
    ListNode loopReverseKGroup(ListNode head, int k){
        ListNode a = head, b = head;
        for(int i=0;i<k;i++){
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = loopReverseNList(a, b);
        a.next = loopReverseKGroup(b, k);
        return newHead;
    }
}
