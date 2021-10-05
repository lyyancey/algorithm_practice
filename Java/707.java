class Node{
    int val;
    Node next;
    public Node(){}
    public Node(int val){
        this.val = val;
    }
}
class MyLinkedList{
    private Node head;
    private int size;
    public MyLinkedList(){
        this.head = new Node(0);
        this.size = 0;
    }
    public int get(int index){
        if(index<0 || index>=this.size){
            return -1;
        }
        Node cur = this.head;
        for(int i=0;i<=index;i++){
            cur = cur.next;
        }
        return cur.val;
    }
    public void addAtHead(int val){
        addAtIndex(0, val);
    }
    public void addAtTail(int val){
        addAtHead(this.size, val);
    }
    public void addAtIndex(int index, int val){
        if(index>this.size){
            return;
        }
        if(index<0){
            index=0;
        }
        this.size++;
        Node cur = this.head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
    }
    public void deleteAtIndex(int index){
        if(index<0||index>=this.size){
            return;
        }
        this.size--;
        Node cur = this.head;
        for(int i=0; i<index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
}