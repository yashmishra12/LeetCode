class LRUCache {
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
    final Node head = new Node();
    final Node tail = new Node();
    
    Map<Integer, Node> map;
    final int capacity;

    
    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        this.capacity = capacity; 
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void remove(Node node) {
        Node nxtNode = node.next;
        Node prvNode = node.prev;
        
        nxtNode.prev = prvNode;
        prvNode.next = nxtNode;
    }
    
    public void add(Node node) {
        Node headNext = head.next; 
        node.next = headNext;
        headNext.prev = node;
        head.next=node;
        node.prev=head;        
    }
    
    public int get(int key) {
        int res = -1;
        Node node = map.get(key);
        if(node!=null) {
            res = node.val;
            remove(node);
            add(node);
        }
        
        return res;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if(node!=null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(map.size()==capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            
            map.put(key, newNode);
            add(newNode);
        } 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */