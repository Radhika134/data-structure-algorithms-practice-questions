class Node{
    int id;
    int data;
    Node next = null;
    Node prev = null;

    public Node(int id, int data)
    {
        this.id = id;
        this.data = data;

    }
}

class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer,Node> mpp;
    int cap;

    public void deleteNode(Node nn)
    {
        nn.prev.next = nn.next;
        nn.next.prev = nn.prev;
    }
    
    public void insertAfterHead(Node nn)
    {
        head.next.prev = nn;
        nn.next = head.next;
        head.next = nn;
        nn.prev = head;
    }


    public LRUCache(int capacity) {
        cap = capacity;
        mpp = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        head.prev = null;

        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        if(mpp.containsKey(key))
        {
            deleteNode(mpp.get(key));
            insertAfterHead(mpp.get(key));
            return mpp.get(key).data;
        }
        else
        {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key))
        {
            mpp.get(key).data = value;
            deleteNode(mpp.get(key));
            insertAfterHead(mpp.get(key));
        }
        else
        {
            if(mpp.size() == cap)
            {
                mpp.remove(tail.prev.id);
                deleteNode(tail.prev);
                
                Node nn = new Node(key, value);
                insertAfterHead(nn);
                mpp.put(key,nn);
            }
            else
            {
                Node nn = new Node(key, value);
                insertAfterHead(nn);
                mpp.put(key,nn);
            }
        }

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */