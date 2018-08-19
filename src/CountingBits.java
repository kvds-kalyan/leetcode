public class CountingBits {

    //for 1001,number of 1's is num of 1's in 100 and if last bit is 1 or not
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
