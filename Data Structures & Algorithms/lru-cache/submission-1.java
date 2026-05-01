class LRUCache {

    Map<Integer, Node> map;
    LinkedList<Node> dll;
    int size = 0;
    int capacity = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        dll = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node nn = map.get(key);
            dll.remove(nn);
            dll.addLast(nn);

            return nn.val;
        }

        return -1;        
    }
    
    public void put(int key, int value) {
        Node nn = new Node(key, value);
        if(size < capacity) {
            if(!map.containsKey(key)) {
                map.put(key, nn);
                dll.addLast(nn);
                size++;
            } else {
                Node r = map.get(key);
                map.put(key, nn);
                dll.remove(r);
                dll.addLast(nn);
            }
        } else {
            if(map.containsKey(key)) {
                Node r = map.get(key);
                dll.remove(r);
                map.put(key, nn);    
                dll.addLast(nn);
            } else {
                Node r = dll.removeFirst();
                map.remove(r.key);
                map.put(key, nn);
                dll.addLast(nn);
            }
        }
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}