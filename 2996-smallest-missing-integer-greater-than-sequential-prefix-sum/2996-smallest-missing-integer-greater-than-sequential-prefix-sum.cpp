class Solution {
public:
    int missingInteger(vector<int>& A) {
        int sum = A[0];

        for (int i = 1; i < A.size(); i++) {
            if (A[i] == A[i - 1] + 1) {
                sum = sum + A[i];
            } else {
                break;
            }
        }

        while (find(A.begin(), A.end(), sum) != A.end()) {
            sum++;
        }

        return sum;
    }
};