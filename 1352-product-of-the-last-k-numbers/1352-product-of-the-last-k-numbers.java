class ProductOfNumbers {
    private int size = 0;  
    private int zero = -1;  
    private final List<Integer> where = new ArrayList<>(), factor = new ArrayList<>();  

    public void add(int num) {
        if (num == 0) {
            zero = size;
            where.clear();
            factor.clear();
        } else if (num > 1) {
            where.add(size);
            factor.add(num);
        }
        size++;
    }

    public int getProduct(int k) {
        int start = size - k;  
        if (zero >= start)
            return 0;
        int product = 1;
        for (int i = where.size() - 1; i >= 0 && where.get(i) >= start; i--)  // the stored numbers inside the window, newest first
            product *= factor.get(i);
        return product;
    }
}