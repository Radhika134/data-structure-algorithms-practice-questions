class Solution {

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    boolean check(long x, int[] coins, int k) {

        long count = 0;
        int n = coins.length;

        // All non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long common = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    common = lcm(common, coins[i]);

                    if (common > x) {
                        break;
                    }
                }
            }

            if (common > x)
                continue;

            long multiples = x / common;

            if (bits % 2 == 1) {
                count += multiples;
            } else {
                count -= multiples;
            }
        }

        return count >= k;
    }

    public long findKthSmallest(int[] coins, int k) {

        long left = 1;
        long right = (long) k * coins[0];

        for (int coin : coins) {
            right = Math.min(right, (long) k * coin);
        }

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (check(mid, coins, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}