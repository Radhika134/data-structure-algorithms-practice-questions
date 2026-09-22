class Node
{
    int id;
    int data;
    int freq;
    Node next = null;
    Node prev = null;

    public Node(int id, int data)
    {
        this.id = id;
        this.data = data;
        this.freq = 1;
    }
}

class DLL
{
    Node head;
    Node tail;

    public DLL(){
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        head.prev = null;

        tail.prev = head;
        tail.next = null;
    }

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

    public boolean isEmpty()
    {
        return head.next == tail;
    }

}

class LFUCache {
    HashMap<Integer, Node> mpp1;
    HashMap<Integer, DLL> mpp2;
    int minFreq;
    int capacity;
   
    public LFUCache(int capacity) {
        this.capacity = capacity;

        mpp1 = new HashMap<>();
        mpp2 = new HashMap<>();
        
        minFreq = 0;
    }
    
    public int get(int key) {
        if(!mpp1.containsKey(key))
        {
            return -1;
        }

        Node nn = mpp1.get(key);

        int oldFreq = nn.freq;
        DLL oldList = mpp2.get(oldFreq);
        oldList.deleteNode(nn);

        nn.freq++;

        DLL newList = mpp2.get(nn.freq);

        if(newList == null)
        {
            newList = new DLL();
            mpp2.put(nn.freq, newList);
        }

        newList.insertAfterHead(nn);

        if(oldFreq == minFreq && oldList.isEmpty())
        {
            minFreq++;
        }

        return nn.data;
        
       
       
    }
    
    public void put(int key, int value) {
        if(mpp1.containsKey(key))
        {
            Node nn = mpp1.get(key);
            int freq1 = nn.freq;

            DLL oldList = mpp2.get(freq1);

            nn.data = value;

            oldList.deleteNode(nn);
            nn.freq++;

            DLL newList = mpp2.get(nn.freq);
            if(newList == null)
            {
               newList = new DLL();
               mpp2.put(nn.freq, newList);
            }

            newList.insertAfterHead(nn);

            if(freq1 == minFreq && oldList.isEmpty())
            {
                minFreq++;
            }

        }
        else
        {
          //bnanai h new node cap dekho
        
            if(mpp1.size() == capacity)
            {
                DLL list1 = mpp2.get(minFreq);
                Node del = list1.tail.prev;
                list1.deleteNode(list1.tail.prev);

                mpp1.remove(del.id);

                Node nn = new Node(key, value);

                mpp1.put(key, nn);
                
                DLL list2 = mpp2.get(nn.freq);
                if(list2 == null)
                {
                    list2 = new DLL();
                    mpp2.put(nn.freq, list2);
                }

                list2.insertAfterHead(nn);

                minFreq = nn.freq;

            }
            else
            {
                Node nn = new Node(key, value);

                mpp1.put(key, nn);
                
                DLL list2 = mpp2.get(nn.freq);
                if(list2 == null)
                {
                    list2 = new DLL();
                    mpp2.put(nn.freq, list2);
                }
                
                list2.insertAfterHead(nn);

                minFreq = nn.freq;
            }
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */