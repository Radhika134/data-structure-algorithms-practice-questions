class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;

        int[] res = new int[n-k+1];
        int idx = 0;

        for(int i = 0; i < n; i++)
        {
            //koi element agar k window sw bahar ka h toh remove krdo
            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
            {
                dq.pollFirst();
            }

            // jb tk samller elemnts h deque ke last se remove krte rho
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            
            //add current ele index
            dq.offerLast(i);
           
            //pehli window bnte hi list mei daldo;  // aur phir hum baar add hota rhe
            if(i >= k - 1)
            {
                res[idx++] = (nums[dq.peekFirst()]);
            }


        }

        
       return res;
        
    }
}