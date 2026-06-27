class Solution {
public:
    int reverse(int x) {

       int rev = 0;
        while(x)
        {
            int rem = x%10;

            if( rev > INT_MAX / 10 || rev == INT_MAX && rev > 7) return 0;
            if(rev < INT_MIN / 10 || rev == INT_MIN && rev < -8) return 0;
            
            rev = rev*10 + rem;
            x = x/10;
        }
        return rev;
        
    }
};