class StockSpanner {

    Stack<int[]> stk;
    int idx ;
    

    public StockSpanner() {
        
        stk = new Stack<>();
        idx = 0;
    }
    
    public int next(int price) {
       
        int pgeIdx ;
        while(!stk.isEmpty() && stk.peek()[0] <= price)
        {
            stk.pop();
        }
        pgeIdx = (stk.isEmpty()) ? -1 : stk.peek()[1];
        int span = idx - pgeIdx;

        stk.push(new int[]{price, idx});
        idx++;

        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */