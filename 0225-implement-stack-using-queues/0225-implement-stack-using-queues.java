class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

    }

    public void push(int x) {
        q1.add(x);

    }

    public int pop() {
        
        int ans = -1;
        while (q1.size() > 1) {
          q2.add(q1.poll());
           
        }
        ans = q1.poll();
        while(!q2.isEmpty())
        {
            q1.add(q2.poll());
        }

        return ans;
    }

    public int top() {
       
        int ans = -1;
        while (q1.size() > 1) {
           
            q2.add(q1.poll());
            
        }
        ans = q1.peek();
        q2.add(q1.poll());
        while(!q2.isEmpty())
        {
            q1.add(q2.poll());
        }
        return ans;

    }

    public boolean empty() {
        if (q1.size() == 0)
            return true;
        return false;

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */