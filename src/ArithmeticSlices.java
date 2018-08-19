public class ArithmeticSlices {

    public static int numberOfArithmeticSlices(int[] A) {

        if(A.length<3)
            return 0;

        int diff[] = new int[A.length-1];
        int n[] = new int[A.length];

        for(int i=0;i<A.length-1;i++) {
            diff[i] = A[i+1]-A[i];
        }

        n[A.length-1] = 0;
        n[A.length-2] = 0;

        for(int i=A.length-3;i>=0;i--) {
            if(diff[i]==diff[i+1]) {
                n[i] = n[i+1]+1;
            }
        }

        int sum=0;
        for(int i=0;i<A.length;i++)
            sum+=n[i];
        return sum;

    }

    public static void main(String[] args) {
        int A[] = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(A));
    }
}
