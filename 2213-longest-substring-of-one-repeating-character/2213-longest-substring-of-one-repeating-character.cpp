class Solution {
public:
    struct Node {
        int pre, suf, best, len;
        char leftChar, rightChar;
    };

    vector<Node> tree;
    string arr;

    Node makeLeaf(char c) {
        Node n;
        n.pre = n.suf = n.best = n.len = 1;
        n.leftChar = n.rightChar = c;
        return n;
    }

    Node merge(Node& left, Node& right) {
        Node res;
        res.len = left.len + right.len;
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        res.pre = left.pre;
        if (left.pre == left.len && left.rightChar == right.leftChar) {
            res.pre += right.pre;
        }

        res.suf = right.suf;
        if (right.suf == right.len && right.leftChar == left.rightChar) {
            res.suf += left.suf;
        }

        res.best = max(left.best, right.best);
        if (left.rightChar == right.leftChar) {
            res.best = max(res.best, left.suf + right.pre);
        }

        return res;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = makeLeaf(arr[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    void update(int node, int l, int r, int idx) {
        if (l == r) {
            tree[node] = makeLeaf(arr[l]);
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(2 * node, l, mid, idx);
        else update(2 * node + 1, mid + 1, r, idx);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        int n = s.size();
        arr = s;
        tree.resize(4 * n);
        build(1, 0, n - 1);

        int q = queryIndices.size();
        vector<int> ans(q);

        for (int i = 0; i < q; i++) {
            int idx = queryIndices[i];
            arr[idx] = queryCharacters[i];
            update(1, 0, n - 1, idx);
            ans[i] = tree[1].best;
        }

        return ans;
    }
};