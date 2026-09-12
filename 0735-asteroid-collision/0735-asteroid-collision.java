class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<n; i++)
        {
            if(asteroids[i] > 0)
            {
                stk.push(asteroids[i]);
            }
            else
            {
                //jbtk stk mei pos h aur vo collide hoke destroy ho rha h
                while(!stk.isEmpty() && stk.peek() > 0 &&
                stk.peek() < Math.abs(asteroids[i]))
                {
                    stk.pop();
                }
                 
                //agar dono same size ke h
                if(!stk.isEmpty() && stk.peek() == Math.abs(asteroids[i]))
                {
                    stk.pop();
                    continue; //- asteroid bhi destroy kro vrna vo next if mei enter ho jaega
                }

                //agar stsk pehle se empty h toh hi - add kro ya phir already koi - pda ho
                if(stk.isEmpty() || stk.peek() < 0)
                {
                    stk.push(asteroids[i]);
                   
                }
                //vo cond jb stk.peek() > asteroids[i] mei koi if else nhi vo skip ho jaega
            }
        }

        int[] res = new int[stk.size()];
        int i = res.length-1;
        while(!stk.isEmpty())
        {
            res[i--] = stk.pop();
        }

        return res;
    }
}