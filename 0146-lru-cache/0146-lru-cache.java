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
    
    private void remove(Node node){
        Node nxtNode = node.next;
        Node prvNode = node.prev;
        
        nxtNode.prev = prvNode;
        prvNode.next = nxtNode;
    }
    
    private void add(Node node){ //new node is added next to head. 
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    
    public int get(int key) {
        int res = -1;
        Node node = map.get(key);
        if(node!=null){
            res = node.val;
            remove(node);
            add(node);
        }
        return res;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if(node!=null){ //node with this name is present. we are updating value
           remove(node);
            node.val = value;
            add(node);
        }
        else { //node with this name absent. Need to add new node. 
            if(map.size()==capacity){
                map.remove(tail.prev.key); //map se nikalo
                remove(tail.prev); //linkedList is nikalo
            }
            
                Node newNode = new Node();
                newNode.key = key;
                newNode.val = value;
                map.put(key, newNode); //map mai daalo

                add(newNode); //linkedlist mai daalo
        }
        

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */