class Solution {
    public int myAtoi(String s) {

        long ans = 0;
        int sign = 1;
        int i = 0;

        // Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
        else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        // Convert digits
        while (i < s.length() &&
               s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            ans = ans * 10 + (s.charAt(i) - '0');

            if (sign * ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign * ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int)(ans * sign);
    }
}